package com.datatable.framework.plugin.jooq.util;

import com.datatable.framework.plugin.jooq.JooqInfix;
import com.datatable.framework.plugin.jooq.rx3.VertxDAO;
import com.datatable.framework.plugin.jooq.util.condition.JooqCond;
import com.datatable.framework.plugin.jooq.util.query.Inquiry;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
 * Join Operation Complex JqTool Component
 */
@SuppressWarnings("all")
class JqJoinder {
    /*
     * Class -> Analyzer
     */
    private transient final ConcurrentMap<Class<?>, JqAnalyzer> ANALYZERS = new ConcurrentHashMap<>();
    /*
     * Table prefix: Name -> Alias
     */
    private transient final ConcurrentMap<String, String> PREFIX_MAP = new ConcurrentHashMap<>();
    /*
     * Mapping assist for calculation
     */
    private transient final ConcurrentMap<Class<?>, String> CLASS_MAP = new ConcurrentHashMap<>();
    private transient final ConcurrentMap<String, Class<?>> NAME_MAP = new ConcurrentHashMap<>();
    /*
     * Field Map
     */
    private transient final ConcurrentMap<String, String> FIELD_TABLE_MAP = new ConcurrentHashMap<>();
    private transient final ConcurrentMap<String, String> COLUMN_MAP = new ConcurrentHashMap<>();
    private transient final ConcurrentMap<String, Field> FIELD_MAP = new ConcurrentHashMap<>();
    /*
     * Next table ( exclude the first added table here )
     */
    private transient final List<String> TABLES = new ArrayList<>();

    private transient final List<JqEdge> EDGES = new ArrayList<>();

    private transient String firstKey;
    private transient String firstValue;
    private JqJoinder talbe;

    JqJoinder() {
    }

    <T> JqJoinder add(final Class<T> daoCls, final String field) {
        /*
         * Stored analyzer by daoCls
         */
        this.putDao(daoCls);
        /*
         * The first
         */
        final String firstTable = this.CLASS_MAP.get(daoCls);
        this.firstKey = firstTable;
        this.firstValue = field;
        return this;
    }

    <T> JqJoinder join(final Class<?> daoCls, final String field) {
        /*
         * Support three tables only as max table here
         * It means that if there exist more than 3 tables, we recommend
         * to re-design database instead of using `JOIN`
         * Because multi tables join may caused performance issue.
         */
        if (2 < this.ANALYZERS.size()) {
            throw new RuntimeException("Join table counter limitation! ");
        }
        /*
         * Stored analyzer by daoCls
         */
        putDao(daoCls);
        /*
         * Build Relation
         */
        final String toTable = this.CLASS_MAP.get(daoCls);
        this.TABLES.add(toTable);
        /*
         * JqEdge
         */
        {
            final JqEdge edge = new JqEdge();
            edge.setFrom(firstKey, firstValue);

            edge.setTo(toTable, field);
            this.EDGES.add(edge);
        }
        return this;
    }

    private <T> void putDao(final Class<T> daoCls) {
        /*
         * Analyzer building
         */
        final VertxDAO vertxDAO = (VertxDAO) JooqInfix.getDao(daoCls);
        final JqAnalyzer analyzer = JqAnalyzer.get(vertxDAO);
        final String tableName = analyzer.table();
        this.ANALYZERS.put(daoCls, analyzer);
        {
            this.CLASS_MAP.put(daoCls, tableName);
            this.NAME_MAP.put(tableName, daoCls);
        }
        /*
         * Table Name -> Table Alias mapping
         */
        final Integer size = this.ANALYZERS.size();
        final String tableAlias = "T" + size;
        this.PREFIX_MAP.put(tableName, DSL.table(tableAlias).getName());
        /*
         * Field -> Table
         */
        final ConcurrentMap<String, Field> fields = analyzer.columns();
        for (String fieldName : fields.keySet()) {
            final Field field = fields.get(fieldName);
            this.FIELD_MAP.put(fieldName, field);
            /*
             * Column Field here
             */
            if (!this.FIELD_TABLE_MAP.containsKey(field.getName())) {
                this.FIELD_TABLE_MAP.put(field.getName(), tableAlias);
                /*
                 * Column -> Field
                 */
                this.COLUMN_MAP.put(field.getName(), fieldName);
            }
        }
    }



    private Integer searchCount(final Inquiry inquiry) {
        /*
         * DSLContext
         */
        final DSLContext context = JooqInfix.getDSL();
        final Table table = getTable();
        if (Objects.isNull(table)) {
            throw new RuntimeException("Table null issue! ");
        }
        /*
         * Started step
         */
        final Field original = FIELD_MAP.get(firstValue);
        final Field field = DSL.field(this.PREFIX_MAP.get(firstKey) + "." + original.getName());
        final SelectWhereStep started = context.select(field).from(table);
        /*
         * Condition for "criteria"
         */
        if (null != inquiry.getCriteria()) {
            final Condition condition = JooqCond.transform(inquiry.getCriteria().toJson(),
                    this::getColumn, this::getTable);
            started.where(condition);
        }
        return started.fetch().size();
    }


    private Field getColumn(final String field) {
        final Field found = this.FIELD_MAP.get(field);
        if (Objects.isNull(found)) {
            return null;
        } else {
            return found;
        }
    }

    private String getTable(final String field) {
        return this.FIELD_TABLE_MAP.get(field);
    }

    private Table<Record> getTable() {
        /*
         * Two tables or one table
         */
        if (!this.PREFIX_MAP.isEmpty()) {
            /*
             * The first table
             */
            Table<Record> first = getTableRecord(firstKey);
            if (this.TABLES.isEmpty()) {
                return first;
            } else {
                /*
                 * First and Second
                 */
                final int size = this.TABLES.size();
                TableOnConditionStep<Record> conditionStep;
                final String tableName = this.TABLES.get(0);
                final Table<Record> record = getTableRecord(tableName);
                conditionStep = buildCondition(first, record, this.EDGES.get(0));
                for (int idx = 1; idx < size; idx++) {
                    final String middleName = this.TABLES.get(idx);
                    final Table<Record> next = getTableRecord(middleName);
                    conditionStep = buildCondition(conditionStep, next, this.EDGES.get(idx));
                }
                return conditionStep;
            }
        } else return null;

    }

    private TableOnConditionStep<Record> buildCondition(
            final Table<Record> from,
            final Table<Record> to,
            final JqEdge edge) {
        /*
         * T1 join T2 on T1.Field1 = T2.Field2
         */
        /*
         * T1
         */
        final String majorField = edge.getFromField();
        final JqAnalyzer major = findByName(edge.getFromTable());
        final Field hitted = major.column(majorField);
        final String fromPrefix = PREFIX_MAP.get(edge.getFromTable());
        final Field hittedField = DSL.field(fromPrefix + "." + hitted.getName());
        /*
         * T2
         */
        final String toField = edge.getToField();
        final JqAnalyzer toTable = findByName(edge.getToTable());
        final Field joined = toTable.column(toField);
        final String toPrefix = PREFIX_MAP.get(edge.getToTable());
        final Field joinedField = DSL.field(toPrefix + "." + joined.getName());
        /*
         * Left Join here
         */
        return from.leftJoin(to).on(hittedField.eq(joinedField));
    }

    private Table<Record> getTableRecord(final String table) {
        final String alias = this.PREFIX_MAP.get(table);
        return DSL.table(DSL.name(table)).as(DSL.name(alias));
    }

    private JqAnalyzer findByName(final String name) {
        final Class<?> daoCls = this.NAME_MAP.get(name);
        return this.ANALYZERS.get(daoCls);
    }
}
