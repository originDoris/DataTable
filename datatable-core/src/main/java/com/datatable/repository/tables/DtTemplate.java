/*
 * This file is generated by jOOQ.
 */
package com.datatable.repository.tables;


import com.datatable.repository.Indexes;
import com.datatable.repository.Keys;
import com.datatable.repository.Public;
import com.datatable.repository.tables.records.DtTemplateRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 模版
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DtTemplate extends TableImpl<DtTemplateRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.dt_template</code>
     */
    public static final DtTemplate DT_TEMPLATE = new DtTemplate();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DtTemplateRecord> getRecordType() {
        return DtTemplateRecord.class;
    }

    /**
     * The column <code>public.dt_template.id</code>.
     */
    public final TableField<DtTemplateRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.dt_template.gmt_create</code>. 创建时间
     */
    public final TableField<DtTemplateRecord, LocalDateTime> GMT_CREATE = createField(DSL.name("gmt_create"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "创建时间");

    /**
     * The column <code>public.dt_template.gmt_modified</code>. 修改时间
     */
    public final TableField<DtTemplateRecord, LocalDateTime> GMT_MODIFIED = createField(DSL.name("gmt_modified"), SQLDataType.LOCALDATETIME(6), this, "修改时间");

    /**
     * The column <code>public.dt_template.creator</code>. 创建人
     */
    public final TableField<DtTemplateRecord, Long> CREATOR = createField(DSL.name("creator"), SQLDataType.BIGINT.nullable(false), this, "创建人");

    /**
     * The column <code>public.dt_template.editor</code>. 更新人
     */
    public final TableField<DtTemplateRecord, Long> EDITOR = createField(DSL.name("editor"), SQLDataType.BIGINT, this, "更新人");

    /**
     * The column <code>public.dt_template.template_name</code>.
     */
    public final TableField<DtTemplateRecord, String> TEMPLATE_NAME = createField(DSL.name("template_name"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.dt_template.template_desc</code>. 描述
     */
    public final TableField<DtTemplateRecord, String> TEMPLATE_DESC = createField(DSL.name("template_desc"), SQLDataType.VARCHAR(255), this, "描述");

    /**
     * The column <code>public.dt_template.tenant_id</code>.
     */
    public final TableField<DtTemplateRecord, Long> TENANT_ID = createField(DSL.name("tenant_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.dt_template.app_id</code>. 应用id
     */
    public final TableField<DtTemplateRecord, Long> APP_ID = createField(DSL.name("app_id"), SQLDataType.BIGINT.nullable(false), this, "应用id");

    /**
     * The column <code>public.dt_template.is_delete</code>. 0 否 1 是
     */
    public final TableField<DtTemplateRecord, Short> IS_DELETE = createField(DSL.name("is_delete"), SQLDataType.SMALLINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.SMALLINT)), this, "0 否 1 是");

    private DtTemplate(Name alias, Table<DtTemplateRecord> aliased) {
        this(alias, aliased, null);
    }

    private DtTemplate(Name alias, Table<DtTemplateRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("模版"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.dt_template</code> table reference
     */
    public DtTemplate(String alias) {
        this(DSL.name(alias), DT_TEMPLATE);
    }

    /**
     * Create an aliased <code>public.dt_template</code> table reference
     */
    public DtTemplate(Name alias) {
        this(alias, DT_TEMPLATE);
    }

    /**
     * Create a <code>public.dt_template</code> table reference
     */
    public DtTemplate() {
        this(DSL.name("dt_template"), null);
    }

    public <O extends Record> DtTemplate(Table<O> child, ForeignKey<O, DtTemplateRecord> key) {
        super(child, key, DT_TEMPLATE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.DT_TEMPLATE_APP_ID_INDEX, Indexes.DT_TEMPLATE_TENANT_ID_INDEX);
    }

    @Override
    public UniqueKey<DtTemplateRecord> getPrimaryKey() {
        return Keys.DT_TEMPLATE_PK;
    }

    @Override
    public DtTemplate as(String alias) {
        return new DtTemplate(DSL.name(alias), this);
    }

    @Override
    public DtTemplate as(Name alias) {
        return new DtTemplate(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DtTemplate rename(String name) {
        return new DtTemplate(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DtTemplate rename(Name name) {
        return new DtTemplate(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, LocalDateTime, LocalDateTime, Long, Long, String, String, Long, Long, Short> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
