create table public.dt_template
(
    id            bigint
        constraint dt_template_pk
            primary key,
    gmt_create    timestamp          not null,
    gmt_modified  timestamp,
    creator       bigint             not null,
    editor        bigint,
    template_name varchar(50)        not null,
    template_desc varchar(255),
    tenant_id     bigint             not null,
    app_id        bigint             not null,
    is_delete     smallint default 0 not null
);

comment on table public.dt_template is '模版';

comment on column public.dt_template.gmt_create is '创建时间';

comment on column public.dt_template.gmt_modified is '修改时间';

comment on column public.dt_template.creator is '创建人';

comment on column public.dt_template.editor is '更新人';

comment on column public.dt_template.template_desc is '描述';

comment on column public.dt_template.app_id is '应用id';

comment on column public.dt_template.is_delete is '0 否 1 是';

create index dt_template_app_id_index
    on public.dt_template (app_id);

create index dt_template_tenant_id_index
    on public.dt_template (tenant_id);



create table public.dt_field
(
    id             bigint
        constraint dt_field_pk
            primary key,
    gmt_create     timestamp   not null,
    gmt_modified   timestamp,
    creator        bigint      not null,
    editor         bigint,
    field_name     varchar(50) not null,
    field_desc     varchar(255),
    field_type     varchar(30) not null,
    field_property jsonb,
    is_delete      smallint default 0 not null,
    tenant_id      bigint      not null,
    app_id         bigint      not null,
    template_id    bigint      not null
);

comment on table public.dt_field is '字段信息';

comment on column public.dt_field.gmt_create is '创建时间';

comment on column public.dt_field.gmt_modified is '修改时间';

comment on column public.dt_field.creator is '创建人';

comment on column public.dt_field.editor is '更新人';

comment on column public.dt_field.field_name is '字段名称';

comment on column public.dt_field.field_desc is '字段描述';

comment on column public.dt_field.field_type is '字段类型';

comment on column public.dt_field.field_property is '字段属性';

comment on column public.dt_field.is_delete is '0 否 1 是';

comment on column public.dt_field.tenant_id is '租户id';

comment on column public.dt_field.app_id is '应用id';

comment on column public.dt_field.template_id is '模版id';

create index dt_field_app_id_index
    on public.dt_field (app_id);

create index dt_field_template_id_index
    on public.dt_field (template_id);

create index dt_field_tenant_id_index
    on public.dt_field (tenant_id);



create table public.dt_view
(
    id           bigint             not null
        constraint dt_view_pk
            primary key,
    gmt_create   timestamp          not null,
    gmt_modified timestamp,
    creator      bigint             not null,
    editor       bigint,
    view_name    varchar(50)        not null,
    view_desc    varchar(255),
    view_type    varchar(30),
    tenant_id    bigint             not null,
    app_id       bigint             not null,
    is_delete    smallint default 0 not null,
    template_id  bigint             not null,
    view_config  jsonb
);

comment on table public.dt_view is '视图';

comment on column public.dt_view.gmt_create is '创建时间';

comment on column public.dt_view.gmt_modified is '修改日期';

comment on column public.dt_view.creator is '创建人';

comment on column public.dt_view.editor is '修改人';

comment on column public.dt_view.view_name is '视图名称';

comment on column public.dt_view.view_desc is '视图描述';

comment on column public.dt_view.view_type is '视图类型';

comment on column public.dt_view.tenant_id is '租户id';

comment on column public.dt_view.app_id is '应用id';

comment on column public.dt_view.is_delete is '0 否 1 是';

comment on column public.dt_view.template_id is '模版id';

comment on column public.dt_view.view_config is '视图配置';

create index dt_view_app_id_index
    on public.dt_view (app_id);

create index dt_view_template_id_index
    on public.dt_view (template_id);

create index dt_view_tenant_id_index
    on public.dt_view (tenant_id);


create table public.dt_tenant
(
    id            bigint
        constraint dt_tenant_pk
            primary key,
    gmt_create    timestamp,
    gmt_modified  timestamp,
    creator       bigint             not null,
    editor        bigint,
    tenant_name   varchar(50),
    tenant_desc   varchar(255),
    is_delete     smallint default 0 not null,
    tenant_status varchar(30)        not null
);

comment on table public.dt_tenant is '租户';

comment on column public.dt_tenant.gmt_create is '创建时间';

comment on column public.dt_tenant.gmt_modified is '修改时间';

comment on column public.dt_tenant.creator is '创建人';

comment on column public.dt_tenant.editor is '更新人';

comment on column public.dt_tenant.tenant_name is '租户名称';

comment on column public.dt_tenant.tenant_desc is '租户描述';

comment on column public.dt_tenant.is_delete is '0 否 1 是';

comment on column public.dt_tenant.tenant_status is '租户状态';


create table public.dt_app
(
    id           bigint
        constraint dt_app_pk
            primary key,
    gmt_create   timestamp          not null,
    gmt_modified timestamp,
    app_name     varchar(50)        not null,
    app_desc     varchar(255),
    creator      bigint             not null,
    editor       bigint,
    is_delete    smallint default 0 not null,
    tenant_id    bigint             not null
);

comment on table public.dt_app is 'app';

comment on column public.dt_app.gmt_create is '创建时间';

comment on column public.dt_app.gmt_modified is '更新时间';

comment on column public.dt_app.app_name is '应用名称';

comment on column public.dt_app.app_desc is '应用描述';

comment on column public.dt_app.creator is '创建人';

comment on column public.dt_app.editor is '更新人';

comment on column public.dt_app.is_delete is '0 否 1 是';

comment on column public.dt_app.tenant_id is '租户id';

create index dt_app_tenant_id_index
    on public.dt_app (tenant_id);


create table public.dt_user
(
    id            bigint
        constraint dt_user_pk
            primary key,
    gmt_create    bigint             not null,
    gmt_modified  bigint,
    user_name     varchar(50)        not null,
    user_account  varchar(128)       not null,
    user_password varchar(256)       not null,
    user_status   varchar(20)        not null,
    is_delete     smallint default 0 not null,
    tenant_id     bigint             not null,
    app_id        bigint             not null
);

comment on table public.dt_user is '用户信息';

comment on column public.dt_user.gmt_create is '创建时间';

comment on column public.dt_user.gmt_modified is '修改时间';

comment on column public.dt_user.user_name is '用户名';

comment on column public.dt_user.user_account is '账号';

comment on column public.dt_user.user_password is '密码';

comment on column public.dt_user.user_status is '用户状态';

comment on column public.dt_user.is_delete is '0 否 1 是';

comment on column public.dt_user.tenant_id is '租户id';

comment on column public.dt_user.app_id is '应用id';

create index dt_user_app_id_index
    on public.dt_user (app_id);

create index dt_user_tenant_id_index
    on public.dt_user (tenant_id);

create index dt_user_user_status_index
    on public.dt_user (user_status);


