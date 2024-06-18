package com.datatable.repository.tables.mappers;

import io.vertx.sqlclient.Row;
import java.util.function.Function;

public class RowMappers {

        private RowMappers(){}

        public static Function<Row,com.datatable.repository.tables.pojos.DtApp> getDtAppMapper() {
                return row -> {
                        com.datatable.repository.tables.pojos.DtApp pojo = new com.datatable.repository.tables.pojos.DtApp();
                        pojo.setId(row.getLong("id"));
                        pojo.setGmtCreate(row.getLocalDateTime("gmt_create"));
                        pojo.setGmtModified(row.getLocalDateTime("gmt_modified"));
                        pojo.setAppName(row.getString("app_name"));
                        pojo.setAppDesc(row.getString("app_desc"));
                        pojo.setCreator(row.getLong("creator"));
                        pojo.setEditor(row.getLong("editor"));
                        pojo.setIsDelete(row.getShort("is_delete"));
                        pojo.setTenantId(row.getLong("tenant_id"));
                        return pojo;
                };
        }

        public static Function<Row,com.datatable.repository.tables.pojos.DtField> getDtFieldMapper() {
                return row -> {
                        com.datatable.repository.tables.pojos.DtField pojo = new com.datatable.repository.tables.pojos.DtField();
                        pojo.setId(row.getLong("id"));
                        pojo.setGmtCreate(row.getLocalDateTime("gmt_create"));
                        pojo.setGmtModified(row.getLocalDateTime("gmt_modified"));
                        pojo.setCreator(row.getLong("creator"));
                        pojo.setEditor(row.getLong("editor"));
                        pojo.setFieldName(row.getString("field_name"));
                        pojo.setFieldDesc(row.getString("field_desc"));
                        pojo.setFieldType(row.getString("field_type"));
                        pojo.setFieldProperty(row.getJsonObject("field_property"));
                        pojo.setIsDelete(row.getShort("is_delete"));
                        pojo.setTenantId(row.getLong("tenant_id"));
                        pojo.setAppId(row.getLong("app_id"));
                        pojo.setTemplateId(row.getLong("template_id"));
                        return pojo;
                };
        }

        public static Function<Row,com.datatable.repository.tables.pojos.DtTemplate> getDtTemplateMapper() {
                return row -> {
                        com.datatable.repository.tables.pojos.DtTemplate pojo = new com.datatable.repository.tables.pojos.DtTemplate();
                        pojo.setId(row.getLong("id"));
                        pojo.setGmtCreate(row.getLocalDateTime("gmt_create"));
                        pojo.setGmtModified(row.getLocalDateTime("gmt_modified"));
                        pojo.setCreator(row.getLong("creator"));
                        pojo.setEditor(row.getLong("editor"));
                        pojo.setTemplateName(row.getString("template_name"));
                        pojo.setTemplateDesc(row.getString("template_desc"));
                        pojo.setTenantId(row.getLong("tenant_id"));
                        pojo.setAppId(row.getLong("app_id"));
                        pojo.setIsDelete(row.getShort("is_delete"));
                        return pojo;
                };
        }

        public static Function<Row,com.datatable.repository.tables.pojos.DtTenant> getDtTenantMapper() {
                return row -> {
                        com.datatable.repository.tables.pojos.DtTenant pojo = new com.datatable.repository.tables.pojos.DtTenant();
                        pojo.setId(row.getLong("id"));
                        pojo.setGmtCreate(row.getLocalDateTime("gmt_create"));
                        pojo.setGmtModified(row.getLocalDateTime("gmt_modified"));
                        pojo.setCreator(row.getLong("creator"));
                        pojo.setEditor(row.getLong("editor"));
                        pojo.setTenantName(row.getString("tenant_name"));
                        pojo.setTenantDesc(row.getString("tenant_desc"));
                        pojo.setIsDelete(row.getShort("is_delete"));
                        pojo.setTenantStatus(row.getString("tenant_status"));
                        return pojo;
                };
        }

        public static Function<Row,com.datatable.repository.tables.pojos.DtUser> getDtUserMapper() {
                return row -> {
                        com.datatable.repository.tables.pojos.DtUser pojo = new com.datatable.repository.tables.pojos.DtUser();
                        pojo.setId(row.getLong("id"));
                        pojo.setGmtCreate(row.getLong("gmt_create"));
                        pojo.setGmtModified(row.getLong("gmt_modified"));
                        pojo.setUserName(row.getString("user_name"));
                        pojo.setUserAccount(row.getString("user_account"));
                        pojo.setUserPassword(row.getString("user_password"));
                        pojo.setUserStatus(row.getString("user_status"));
                        pojo.setIsDelete(row.getShort("is_delete"));
                        pojo.setTenantId(row.getLong("tenant_id"));
                        pojo.setAppId(row.getLong("app_id"));
                        return pojo;
                };
        }

        public static Function<Row,com.datatable.repository.tables.pojos.DtView> getDtViewMapper() {
                return row -> {
                        com.datatable.repository.tables.pojos.DtView pojo = new com.datatable.repository.tables.pojos.DtView();
                        pojo.setId(row.getLong("id"));
                        pojo.setGmtCreate(row.getLocalDateTime("gmt_create"));
                        pojo.setGmtModified(row.getLocalDateTime("gmt_modified"));
                        pojo.setCreator(row.getLong("creator"));
                        pojo.setEditor(row.getLong("editor"));
                        pojo.setViewName(row.getString("view_name"));
                        pojo.setViewDesc(row.getString("view_desc"));
                        pojo.setViewType(row.getString("view_type"));
                        pojo.setTenantId(row.getLong("tenant_id"));
                        pojo.setAppId(row.getLong("app_id"));
                        pojo.setIsDelete(row.getShort("is_delete"));
                        pojo.setTemplateId(row.getLong("template_id"));
                        pojo.setViewConfig(row.getJsonObject("view_config"));
                        return pojo;
                };
        }

}
