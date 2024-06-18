/*
 * This file is generated by jOOQ.
 */
package com.datatable.repository.tables;


import com.datatable.repository.Indexes;
import com.datatable.repository.Keys;
import com.datatable.repository.Public;
import com.datatable.repository.tables.records.DtAppRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * app
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DtApp extends TableImpl<DtAppRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.dt_app</code>
     */
    public static final DtApp DT_APP = new DtApp();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DtAppRecord> getRecordType() {
        return DtAppRecord.class;
    }

    /**
     * The column <code>public.dt_app.id</code>.
     */
    public final TableField<DtAppRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.dt_app.gmt_create</code>. 创建时间
     */
    public final TableField<DtAppRecord, LocalDateTime> GMT_CREATE = createField(DSL.name("gmt_create"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "创建时间");

    /**
     * The column <code>public.dt_app.gmt_modified</code>. 更新时间
     */
    public final TableField<DtAppRecord, LocalDateTime> GMT_MODIFIED = createField(DSL.name("gmt_modified"), SQLDataType.LOCALDATETIME(6), this, "更新时间");

    /**
     * The column <code>public.dt_app.app_name</code>. 应用名称
     */
    public final TableField<DtAppRecord, String> APP_NAME = createField(DSL.name("app_name"), SQLDataType.VARCHAR(50).nullable(false), this, "应用名称");

    /**
     * The column <code>public.dt_app.app_desc</code>. 应用描述
     */
    public final TableField<DtAppRecord, String> APP_DESC = createField(DSL.name("app_desc"), SQLDataType.VARCHAR(255), this, "应用描述");

    /**
     * The column <code>public.dt_app.creator</code>. 创建人
     */
    public final TableField<DtAppRecord, Long> CREATOR = createField(DSL.name("creator"), SQLDataType.BIGINT.nullable(false), this, "创建人");

    /**
     * The column <code>public.dt_app.editor</code>. 更新人
     */
    public final TableField<DtAppRecord, Long> EDITOR = createField(DSL.name("editor"), SQLDataType.BIGINT, this, "更新人");

    /**
     * The column <code>public.dt_app.is_delete</code>. 0 否 1 是
     */
    public final TableField<DtAppRecord, Short> IS_DELETE = createField(DSL.name("is_delete"), SQLDataType.SMALLINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.SMALLINT)), this, "0 否 1 是");

    /**
     * The column <code>public.dt_app.tenant_id</code>. 租户id
     */
    public final TableField<DtAppRecord, Long> TENANT_ID = createField(DSL.name("tenant_id"), SQLDataType.BIGINT.nullable(false), this, "租户id");

    private DtApp(Name alias, Table<DtAppRecord> aliased) {
        this(alias, aliased, null);
    }

    private DtApp(Name alias, Table<DtAppRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("app"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.dt_app</code> table reference
     */
    public DtApp(String alias) {
        this(DSL.name(alias), DT_APP);
    }

    /**
     * Create an aliased <code>public.dt_app</code> table reference
     */
    public DtApp(Name alias) {
        this(alias, DT_APP);
    }

    /**
     * Create a <code>public.dt_app</code> table reference
     */
    public DtApp() {
        this(DSL.name("dt_app"), null);
    }

    public <O extends Record> DtApp(Table<O> child, ForeignKey<O, DtAppRecord> key) {
        super(child, key, DT_APP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.DT_APP_TENANT_ID_INDEX);
    }

    @Override
    public UniqueKey<DtAppRecord> getPrimaryKey() {
        return Keys.DT_APP_PK;
    }

    @Override
    public DtApp as(String alias) {
        return new DtApp(DSL.name(alias), this);
    }

    @Override
    public DtApp as(Name alias) {
        return new DtApp(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DtApp rename(String name) {
        return new DtApp(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DtApp rename(Name name) {
        return new DtApp(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, LocalDateTime, LocalDateTime, String, String, Long, Long, Short, Long> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
