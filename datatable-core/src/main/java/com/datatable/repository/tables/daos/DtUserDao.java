/*
 * This file is generated by jOOQ.
 */
package com.datatable.repository.tables.daos;


import com.datatable.framework.plugin.jooq.shared.reactive.AbstractReactiveVertxDAO;
import com.datatable.repository.tables.DtUser;
import com.datatable.repository.tables.records.DtUserRecord;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.reactivex.rxjava3.core.Single;
import java.util.Optional;
import com.datatable.framework.plugin.jooq.rx3.ReactiveRXQueryExecutor;
/**
 * 用户信息
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DtUserDao extends AbstractReactiveVertxDAO<DtUserRecord, com.datatable.repository.tables.pojos.DtUser, Long, Single<List<com.datatable.repository.tables.pojos.DtUser>>, Single<Optional<com.datatable.repository.tables.pojos.DtUser>>, Single<Integer>, Single<Long>> implements com.datatable.framework.plugin.jooq.rx3.VertxDAO<DtUserRecord,com.datatable.repository.tables.pojos.DtUser,Long> {

        /**
     * @param configuration The Configuration used for rendering and query
     * execution.
     * @param vertx the vertx instance
     */
        public DtUserDao(Configuration configuration, io.vertx.rxjava3.sqlclient.SqlClient delegate) {
                super(DtUser.DT_USER, com.datatable.repository.tables.pojos.DtUser.class, new ReactiveRXQueryExecutor<DtUserRecord,com.datatable.repository.tables.pojos.DtUser,Long>(configuration,delegate,com.datatable.repository.tables.mappers.RowMappers.getDtUserMapper()));
        }

        @Override
        protected Long getId(com.datatable.repository.tables.pojos.DtUser object) {
                return object.getId();
        }

        /**
     * Find records that have <code>gmt_create IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByGmtCreate(Collection<Long> values) {
                return findManyByCondition(DtUser.DT_USER.GMT_CREATE.in(values));
        }

        /**
     * Find records that have <code>gmt_create IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByGmtCreate(Collection<Long> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.GMT_CREATE.in(values),limit);
        }

        /**
     * Find records that have <code>gmt_modified IN (values)</code>
     * asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByGmtModified(Collection<Long> values) {
                return findManyByCondition(DtUser.DT_USER.GMT_MODIFIED.in(values));
        }

        /**
     * Find records that have <code>gmt_modified IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByGmtModified(Collection<Long> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.GMT_MODIFIED.in(values),limit);
        }

        /**
     * Find records that have <code>user_name IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserName(Collection<String> values) {
                return findManyByCondition(DtUser.DT_USER.USER_NAME.in(values));
        }

        /**
     * Find records that have <code>user_name IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserName(Collection<String> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.USER_NAME.in(values),limit);
        }

        /**
     * Find records that have <code>user_account IN (values)</code>
     * asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserAccount(Collection<String> values) {
                return findManyByCondition(DtUser.DT_USER.USER_ACCOUNT.in(values));
        }

        /**
     * Find records that have <code>user_account IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserAccount(Collection<String> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.USER_ACCOUNT.in(values),limit);
        }

        /**
     * Find records that have <code>user_password IN (values)</code>
     * asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserPassword(Collection<String> values) {
                return findManyByCondition(DtUser.DT_USER.USER_PASSWORD.in(values));
        }

        /**
     * Find records that have <code>user_password IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserPassword(Collection<String> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.USER_PASSWORD.in(values),limit);
        }

        /**
     * Find records that have <code>user_status IN (values)</code>
     * asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserStatus(Collection<String> values) {
                return findManyByCondition(DtUser.DT_USER.USER_STATUS.in(values));
        }

        /**
     * Find records that have <code>user_status IN (values)</code>
     * asynchronously limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByUserStatus(Collection<String> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.USER_STATUS.in(values),limit);
        }

        /**
     * Find records that have <code>is_delete IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByIsDelete(Collection<Short> values) {
                return findManyByCondition(DtUser.DT_USER.IS_DELETE.in(values));
        }

        /**
     * Find records that have <code>is_delete IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByIsDelete(Collection<Short> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.IS_DELETE.in(values),limit);
        }

        /**
     * Find records that have <code>tenant_id IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByTenantId(Collection<Long> values) {
                return findManyByCondition(DtUser.DT_USER.TENANT_ID.in(values));
        }

        /**
     * Find records that have <code>tenant_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByTenantId(Collection<Long> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.TENANT_ID.in(values),limit);
        }

        /**
     * Find records that have <code>app_id IN (values)</code> asynchronously
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByAppId(Collection<Long> values) {
                return findManyByCondition(DtUser.DT_USER.APP_ID.in(values));
        }

        /**
     * Find records that have <code>app_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Single<List<com.datatable.repository.tables.pojos.DtUser>> findManyByAppId(Collection<Long> values, int limit) {
                return findManyByCondition(DtUser.DT_USER.APP_ID.in(values),limit);
        }

        @Override
        public ReactiveRXQueryExecutor<DtUserRecord,com.datatable.repository.tables.pojos.DtUser,Long> queryExecutor(){
                return (ReactiveRXQueryExecutor<DtUserRecord,com.datatable.repository.tables.pojos.DtUser,Long>) super.queryExecutor();
        }
}
