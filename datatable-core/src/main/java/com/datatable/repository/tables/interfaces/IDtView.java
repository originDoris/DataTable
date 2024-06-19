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
 * 视图
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IDtView extends VertxPojo, Serializable {

    /**
     * Setter for <code>public.dt_view.id</code>.
     */
    public IDtView setId(Long value);

    /**
     * Getter for <code>public.dt_view.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>public.dt_view.gmt_create</code>. 创建时间
     */
    public IDtView setGmtCreate(LocalDateTime value);

    /**
     * Getter for <code>public.dt_view.gmt_create</code>. 创建时间
     */
    public LocalDateTime getGmtCreate();

    /**
     * Setter for <code>public.dt_view.gmt_modified</code>. 修改日期
     */
    public IDtView setGmtModified(LocalDateTime value);

    /**
     * Getter for <code>public.dt_view.gmt_modified</code>. 修改日期
     */
    public LocalDateTime getGmtModified();

    /**
     * Setter for <code>public.dt_view.creator</code>. 创建人
     */
    public IDtView setCreator(Long value);

    /**
     * Getter for <code>public.dt_view.creator</code>. 创建人
     */
    public Long getCreator();

    /**
     * Setter for <code>public.dt_view.editor</code>. 修改人
     */
    public IDtView setEditor(Long value);

    /**
     * Getter for <code>public.dt_view.editor</code>. 修改人
     */
    public Long getEditor();

    /**
     * Setter for <code>public.dt_view.view_name</code>. 视图名称
     */
    public IDtView setViewName(String value);

    /**
     * Getter for <code>public.dt_view.view_name</code>. 视图名称
     */
    public String getViewName();

    /**
     * Setter for <code>public.dt_view.view_desc</code>. 视图描述
     */
    public IDtView setViewDesc(String value);

    /**
     * Getter for <code>public.dt_view.view_desc</code>. 视图描述
     */
    public String getViewDesc();

    /**
     * Setter for <code>public.dt_view.view_type</code>. 视图类型
     */
    public IDtView setViewType(String value);

    /**
     * Getter for <code>public.dt_view.view_type</code>. 视图类型
     */
    public String getViewType();

    /**
     * Setter for <code>public.dt_view.tenant_id</code>. 租户id
     */
    public IDtView setTenantId(Long value);

    /**
     * Getter for <code>public.dt_view.tenant_id</code>. 租户id
     */
    public Long getTenantId();

    /**
     * Setter for <code>public.dt_view.app_id</code>. 应用id
     */
    public IDtView setAppId(Long value);

    /**
     * Getter for <code>public.dt_view.app_id</code>. 应用id
     */
    public Long getAppId();

    /**
     * Setter for <code>public.dt_view.is_delete</code>. 0 否 1 是
     */
    public IDtView setIsDelete(Short value);

    /**
     * Getter for <code>public.dt_view.is_delete</code>. 0 否 1 是
     */
    public Short getIsDelete();

    /**
     * Setter for <code>public.dt_view.template_id</code>. 模版id
     */
    public IDtView setTemplateId(Long value);

    /**
     * Getter for <code>public.dt_view.template_id</code>. 模版id
     */
    public Long getTemplateId();

    /**
     * Setter for <code>public.dt_view.view_config</code>. 视图配置
     */
    public IDtView setViewConfig(JsonObject value);

    /**
     * Getter for <code>public.dt_view.view_config</code>. 视图配置
     */
    public JsonObject getViewConfig();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IDtView
     */
    public void from(IDtView from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IDtView
     */
    public <E extends IDtView> E into(E into);

        @Override
        public default IDtView fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setId,json::getLong,"id","java.lang.Long");
                setOrThrow(this::setGmtCreate,key -> {String s = json.getString(key); return s==null?null:java.time.LocalDateTime.parse(s);},"gmt_create","java.time.LocalDateTime");
                setOrThrow(this::setGmtModified,key -> {String s = json.getString(key); return s==null?null:java.time.LocalDateTime.parse(s);},"gmt_modified","java.time.LocalDateTime");
                setOrThrow(this::setCreator,json::getLong,"creator","java.lang.Long");
                setOrThrow(this::setEditor,json::getLong,"editor","java.lang.Long");
                setOrThrow(this::setViewName,json::getString,"view_name","java.lang.String");
                setOrThrow(this::setViewDesc,json::getString,"view_desc","java.lang.String");
                setOrThrow(this::setViewType,json::getString,"view_type","java.lang.String");
                setOrThrow(this::setTenantId,json::getLong,"tenant_id","java.lang.Long");
                setOrThrow(this::setAppId,json::getLong,"app_id","java.lang.Long");
                setOrThrow(this::setIsDelete,key -> {Integer i = json.getInteger(key); return i==null?null:i.shortValue();},"is_delete","java.lang.Short");
                setOrThrow(this::setTemplateId,json::getLong,"template_id","java.lang.Long");
                setViewConfig(com.datatable.repository.tables.converters.Converters.COM_DATATABLE_FRAMEWORK_PLUGIN_JOOQ_SHARED_POSTGRES_JSONBTOJSONOBJECTCONVERTER_INSTANCE.rowConverter().from(json.getJsonObject("view_config")));
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
                json.put("view_name",getViewName());
                json.put("view_desc",getViewDesc());
                json.put("view_type",getViewType());
                json.put("tenant_id",getTenantId());
                json.put("app_id",getAppId());
                json.put("is_delete",getIsDelete());
                json.put("template_id",getTemplateId());
                json.put("view_config",com.datatable.repository.tables.converters.Converters.COM_DATATABLE_FRAMEWORK_PLUGIN_JOOQ_SHARED_POSTGRES_JSONBTOJSONOBJECTCONVERTER_INSTANCE.rowConverter().to(getViewConfig()));
                return json;
        }

}
