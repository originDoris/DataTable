/*
 * This file is generated by jOOQ.
 */
package com.datatable.repository;


import com.datatable.repository.tables.DtApp;
import com.datatable.repository.tables.DtField;
import com.datatable.repository.tables.DtTemplate;
import com.datatable.repository.tables.DtTenant;
import com.datatable.repository.tables.DtUser;
import com.datatable.repository.tables.DtView;
import com.datatable.repository.tables.records.DtAppRecord;
import com.datatable.repository.tables.records.DtFieldRecord;
import com.datatable.repository.tables.records.DtTemplateRecord;
import com.datatable.repository.tables.records.DtTenantRecord;
import com.datatable.repository.tables.records.DtUserRecord;
import com.datatable.repository.tables.records.DtViewRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DtAppRecord> DT_APP_PK = Internal.createUniqueKey(DtApp.DT_APP, DSL.name("dt_app_pk"), new TableField[] { DtApp.DT_APP.ID }, true);
    public static final UniqueKey<DtFieldRecord> DT_FIELD_PK = Internal.createUniqueKey(DtField.DT_FIELD, DSL.name("dt_field_pk"), new TableField[] { DtField.DT_FIELD.ID }, true);
    public static final UniqueKey<DtTemplateRecord> DT_TEMPLATE_PK = Internal.createUniqueKey(DtTemplate.DT_TEMPLATE, DSL.name("dt_template_pk"), new TableField[] { DtTemplate.DT_TEMPLATE.ID }, true);
    public static final UniqueKey<DtTenantRecord> DT_TENANT_PK = Internal.createUniqueKey(DtTenant.DT_TENANT, DSL.name("dt_tenant_pk"), new TableField[] { DtTenant.DT_TENANT.ID }, true);
    public static final UniqueKey<DtUserRecord> DT_USER_PK = Internal.createUniqueKey(DtUser.DT_USER, DSL.name("dt_user_pk"), new TableField[] { DtUser.DT_USER.ID }, true);
    public static final UniqueKey<DtViewRecord> DT_VIEW_PK = Internal.createUniqueKey(DtView.DT_VIEW, DSL.name("dt_view_pk"), new TableField[] { DtView.DT_VIEW.ID }, true);
}
