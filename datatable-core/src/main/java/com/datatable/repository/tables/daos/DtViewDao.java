/*
 * This file is generated by jOOQ.
 */
package com.datatable.repository.tables.daos;


import com.datatable.framework.plugin.jooq.shared.reactive.AbstractReactiveVertxDAO;
import com.datatable.repository.tables.DtView;
import com.datatable.repository.tables.records.DtViewRecord;

import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.reactivex.rxjava3.core.Single;
import java.util.Optional;
import com.datatable.framework.plugin.jooq.rx3.ReactiveRXQueryExecutor;
/**
 * 视图
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DtViewDao extends AbstractReactiveVertxDAO<DtViewRecord, com.datatable.repository.tables.pojos.DtView, Long, Single<List<com.datatable.repository.tables.pojos.DtView>>, Single<Optional<com.datatable.repository.tables.pojos.DtView>>, Single<Integer>, Single<Long>> implements com.datatable.framework.plugin.jooq.rx3.VertxDAO<DtViewRecord,com.datatable.repository.tables.pojos.DtView,Long> {

        /**
     * @param configuration The Configuration used for rendering and query
     * execution.
     * @param vertx the vertx instance
     */
        public DtViewDao(Configuration configuration, io.vertx.rxjava3.sqlclient.SqlClient delegate) {
                super(DtView.DT_VIEW, com.datatable.repository.tables.pojos.DtView.class, new ReactiveRXQueryExecutor<DtViewRecord,com.datatable.repository.tables.pojos.DtView,Long>(configuration,delegate,com.datatable.repository.tables.mappers.RowMappers.getDtViewMapper()));
        }

        @Override
        protected Long getId(com.datatable.repository.tables.pojos.DtView object) {
                return object.getId();
        }

        /**
     * Find records that have <code>gmt_create IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByGmtCreate(Collection<LocalDateTime> values) {
                return findManyByCondition(DtView.DT_VIEW.GMT_CREATE.in(values));
        }

        /**
     * Find records that have <code>gmt_create IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByGmtCreate(Collection<LocalDateTime> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.GMT_CREATE.in(values),limit);
        }

        /**
     * Find records that have <code>gmt_modified IN (values)</code>
     * asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByGmtModified(Collection<LocalDateTime> values) {
                return findManyByCondition(DtView.DT_VIEW.GMT_MODIFIED.in(values));
        }

        /**
     * Find records that have <code>gmt_modified IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByGmtModified(Collection<LocalDateTime> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.GMT_MODIFIED.in(values),limit);
        }

        /**
     * Find records that have <code>creator IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByCreator(Collection<Long> values) {
                return findManyByCondition(DtView.DT_VIEW.CREATOR.in(values));
        }

        /**
     * Find records that have <code>creator IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByCreator(Collection<Long> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.CREATOR.in(values),limit);
        }

        /**
     * Find records that have <code>editor IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByEditor(Collection<Long> values) {
                return findManyByCondition(DtView.DT_VIEW.EDITOR.in(values));
        }

        /**
     * Find records that have <code>editor IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByEditor(Collection<Long> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.EDITOR.in(values),limit);
        }

        /**
     * Find records that have <code>view_name IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewName(Collection<String> values) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_NAME.in(values));
        }

        /**
     * Find records that have <code>view_name IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewName(Collection<String> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_NAME.in(values),limit);
        }

        /**
     * Find records that have <code>view_desc IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewDesc(Collection<String> values) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_DESC.in(values));
        }

        /**
     * Find records that have <code>view_desc IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewDesc(Collection<String> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_DESC.in(values),limit);
        }

        /**
     * Find records that have <code>view_type IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewType(Collection<String> values) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_TYPE.in(values));
        }

        /**
     * Find records that have <code>view_type IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewType(Collection<String> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_TYPE.in(values),limit);
        }

        /**
     * Find records that have <code>tenant_id IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByTenantId(Collection<Long> values) {
                return findManyByCondition(DtView.DT_VIEW.TENANT_ID.in(values));
        }

        /**
     * Find records that have <code>tenant_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByTenantId(Collection<Long> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.TENANT_ID.in(values),limit);
        }

        /**
     * Find records that have <code>app_id IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByAppId(Collection<Long> values) {
                return findManyByCondition(DtView.DT_VIEW.APP_ID.in(values));
        }

        /**
     * Find records that have <code>app_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByAppId(Collection<Long> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.APP_ID.in(values),limit);
        }

        /**
     * Find records that have <code>is_delete IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByIsDelete(Collection<Short> values) {
                return findManyByCondition(DtView.DT_VIEW.IS_DELETE.in(values));
        }

        /**
     * Find records that have <code>is_delete IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByIsDelete(Collection<Short> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.IS_DELETE.in(values),limit);
        }

        /**
     * Find records that have <code>template_id IN (values)</code>
     * asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByTemplateId(Collection<Long> values) {
                return findManyByCondition(DtView.DT_VIEW.TEMPLATE_ID.in(values));
        }

        /**
     * Find records that have <code>template_id IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByTemplateId(Collection<Long> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.TEMPLATE_ID.in(values),limit);
        }

        /**
     * Find records that have <code>view_config IN (values)</code>
     * asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewConfig(Collection<JsonObject> values) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_CONFIG.in(values));
        }

        /**
     * Find records that have <code>view_config IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtView>> findManyByViewConfig(Collection<JsonObject> values, int limit) {
                return findManyByCondition(DtView.DT_VIEW.VIEW_CONFIG.in(values),limit);
        }

        @Override
        public ReactiveRXQueryExecutor<DtViewRecord,com.datatable.repository.tables.pojos.DtView,Long> queryExecutor(){
                return (ReactiveRXQueryExecutor<DtViewRecord,com.datatable.repository.tables.pojos.DtView,Long>) super.queryExecutor();
        }
}