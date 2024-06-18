package com.datatable.framework.plugin.jooq.shared.reactive;

import com.datatable.framework.plugin.jooq.shared.AbstractVertxDAO;
import com.datatable.framework.plugin.jooq.shared.QueryExecutor;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UpdatableRecord;

import java.util.function.Function;

/**
 * 所有响应式DAO的抽象类
 * @author xhz
 */
public abstract class AbstractReactiveVertxDAO<R extends UpdatableRecord<R>, P, T, FIND_MANY, FIND_ONE,EXECUTE, INSERT_RETURNING> extends AbstractVertxDAO<R,P,T,FIND_MANY,FIND_ONE, EXECUTE, INSERT_RETURNING> {

    private final Function<Object,T> keyConverter;

    protected AbstractReactiveVertxDAO(Table<R> table, Class<P> type, QueryExecutor<R, T, FIND_MANY, FIND_ONE, EXECUTE, INSERT_RETURNING> queryExecutor) {
        super(table, type, queryExecutor);
        if(queryExecutor.configuration().dialect().family().equals(SQLDialect.POSTGRES)){
            this.keyConverter = generatePostgresKeyConverter(table);
        }else{
            if(table.getPrimaryKey().getFieldsArray().length == 1){
                this.keyConverter = generateMySQLKeyConverter(table);
            }else{
                this.keyConverter = o -> {
                    throw new UnsupportedOperationException("Only single numeric primary keys allowed");
                };
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Function<Object,T> generatePostgresKeyConverter(Table<R> table){
        return o -> {
            Row row = (Row) o;
            TableField<R, ?>[] fields = table.getPrimaryKey().getFieldsArray();
            if(fields.length == 1){
                return (T)row.getValue(fields[0].getName());
            }
            Object[] values = new Object[row.size()];
            for(int i=0;i<row.size();i++){
                values[i] = row.getValue(i);
            }
            return compositeKeyRecord(values);
        };
    }

    @SuppressWarnings("unchecked")
    private Function<Object,T> generateMySQLKeyConverter(Table<R> table){
        Class<?> pkType = table.getPrimaryKey().getFieldsArray()[0].getType();
        if(pkType.equals(Long.class)){
            return o -> {
                RowSet<Row> rs = (RowSet<Row>) o;
                return (T) extractMysqlLastInsertProperty().apply(rs);
            };
        }else if(pkType.equals(Integer.class)){
            return o -> {
                RowSet<Row> rs = (RowSet<Row>) o;
                return (T)(Integer) (extractMysqlLastInsertProperty().apply(rs).intValue());
            };
        }else if(pkType.equals(Short.class)){
            return o -> {
                RowSet<Row> rs = (RowSet<Row>) o;
                return (T)(Short) (extractMysqlLastInsertProperty().apply(rs).shortValue());
            };
        }else if(pkType.equals(Byte.class)){
            return o -> {
                RowSet<Row> rs = (RowSet<Row>) o;
                return (T)(Byte) (extractMysqlLastInsertProperty().apply(rs).byteValue());
            };
        }
        /*
         * https://github.com/jklingsporn/vertx-jooq/issues/203
         * Non-numeric primary keys are not generated and must be extracted from the inserted POJO/Record.
         * Do not fail on creation, but on usage.
         */
        return o-> {
            throw new UnsupportedOperationException("Unsupported primary key type '"+pkType+"' for insertReturning");
        };
    }

    protected Function<RowSet<Row>,Long> extractMysqlLastInsertProperty(){
        throw new UnsupportedOperationException();
    }

    @Override
    protected Function<Object,T> keyConverter(){
        return this.keyConverter;
    }

    @Override
    public INSERT_RETURNING insertReturningPrimary(P object) {
        return queryExecutor().insertReturning(dslContext -> dslContext
                        .insertInto(getTable())
                        .set(newRecord(dslContext, object))
                        .returning(getTable().getPrimaryKey().getFieldsArray()),
                keyConverter());
    }
}
