/*
 * This file is generated by jOOQ.
 */
package com.datatable.repository.tables.interfaces;


import com.datatable.framework.plugin.jooq.generate.VertxPojo;

import io.vertx.core.json.JsonObject;

import java.io.Serializable;
import java.time.LocalDateTime;


import static com.datatable.framework.plugin.jooq.generate.VertxPojo.*;
/**
 * 字段信息
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IDtField extends VertxPojo, Serializable {

    /**
     * Setter for <code>public.dt_field.id</code>.
     */
    public IDtField setId(Long value);

    /**
     * Getter for <code>public.dt_field.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>public.dt_field.gmt_create</code>. 创建时间
     */
    public IDtField setGmtCreate(LocalDateTime value);

    /**
     * Getter for <code>public.dt_field.gmt_create</code>. 创建时间
     */
    public LocalDateTime getGmtCreate();

    /**
     * Setter for <code>public.dt_field.gmt_modified</code>. 修改时间
     */
    public IDtField setGmtModified(LocalDateTime value);

    /**
     * Getter for <code>public.dt_field.gmt_modified</code>. 修改时间
     */
    public LocalDateTime getGmtModified();

    /**
     * Setter for <code>public.dt_field.creator</code>. 创建人
     */
    public IDtField setCreator(Long value);

    /**
     * Getter for <code>public.dt_field.creator</code>. 创建人
     */
    public Long getCreator();

    /**
     * Setter for <code>public.dt_field.editor</code>. 更新人
     */
    public IDtField setEditor(Long value);

    /**
     * Getter for <code>public.dt_field.editor</code>. 更新人
     */
    public Long getEditor();

    /**
     * Setter for <code>public.dt_field.field_name</code>. 字段名称
     */
    public IDtField setFieldName(String value);

    /**
     * Getter for <code>public.dt_field.field_name</code>. 字段名称
     */
    public String getFieldName();

    /**
     * Setter for <code>public.dt_field.field_desc</code>. 字段描述
     */
    public IDtField setFieldDesc(String value);

    /**
     * Getter for <code>public.dt_field.field_desc</code>. 字段描述
     */
    public String getFieldDesc();

    /**
     * Setter for <code>public.dt_field.field_type</code>. 字段类型
     */
    public IDtField setFieldType(String value);

    /**
     * Getter for <code>public.dt_field.field_type</code>. 字段类型
     */
    public String getFieldType();

    /**
     * Setter for <code>public.dt_field.field_property</code>. 字段属性
     */
    public IDtField setFieldProperty(JsonObject value);

    /**
     * Getter for <code>public.dt_field.field_property</code>. 字段属性
     */
    public JsonObject getFieldProperty();

    /**
     * Setter for <code>public.dt_field.is_delete</code>. 0 否 1 是
     */
    public IDtField setIsDelete(Short value);

    /**
     * Getter for <code>public.dt_field.is_delete</code>. 0 否 1 是
     */
    public Short getIsDelete();

    /**
     * Setter for <code>public.dt_field.tenant_id</code>. 租户id
     */
    public IDtField setTenantId(Long value);

    /**
     * Getter for <code>public.dt_field.tenant_id</code>. 租户id
     */
    public Long getTenantId();

    /**
     * Setter for <code>public.dt_field.app_id</code>. 应用id
     */
    public IDtField setAppId(Long value);

    /**
     * Getter for <code>public.dt_field.app_id</code>. 应用id
     */
    public Long getAppId();

    /**
     * Setter for <code>public.dt_field.template_id</code>. 模版id
     */
    public IDtField setTemplateId(Long value);

    /**
     * Getter for <code>public.dt_field.template_id</code>. 模版id
     */
    public Long getTemplateId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IDtField
     */
    public void from(IDtField from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IDtField
     */
    public <E extends IDtField> E into(E into);

        @Override
        public default IDtField fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setId,json::getLong,"id","java.lang.Long");
                setOrThrow(this::setGmtCreate,key -> {String s = json.getString(key); return s==null?null:java.time.LocalDateTime.parse(s);},"gmt_create","java.time.LocalDateTime");
                setOrThrow(this::setGmtModified,key -> {String s = json.getString(key); return s==null?null:java.time.LocalDateTime.parse(s);},"gmt_modified","java.time.LocalDateTime");
                setOrThrow(this::setCreator,json::getLong,"creator","java.lang.Long");
                setOrThrow(this::setEditor,json::getLong,"editor","java.lang.Long");
                setOrThrow(this::setFieldName,json::getString,"field_name","java.lang.String");
                setOrThrow(this::setFieldDesc,json::getString,"field_desc","java.lang.String");
                setOrThrow(this::setFieldType,json::getString,"field_type","java.lang.String");
                setOrThrow(this::setFieldProperty,json::getJsonObject,"field_property","io.vertx.core.json.JsonObject");
                setOrThrow(this::setIsDelete,key -> {Integer i = json.getInteger(key); return i==null?null:i.shortValue();},"is_delete","java.lang.Short");
                setOrThrow(this::setTenantId,json::getLong,"tenant_id","java.lang.Long");
                setOrThrow(this::setAppId,json::getLong,"app_id","java.lang.Long");
                setOrThrow(this::setTemplateId,json::getLong,"template_id","java.lang.Long");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("id",getId());
                json.put("gmt_create",getGmtCreate()==null?null:getGmtCreate().toString());
                json.put("gmt_modified",getGmtModified()==null?null:getGmtModified().toString());
                json.put("creator",getCreator());
                json.put("editor",getEditor());
                json.put("field_name",getFieldName());
                json.put("field_desc",getFieldDesc());
                json.put("field_type",getFieldType());
                json.put("field_property",getFieldProperty());
                json.put("is_delete",getIsDelete());
                json.put("tenant_id",getTenantId());
                json.put("app_id",getAppId());
                json.put("template_id",getTemplateId());
                return json;
        }

}
