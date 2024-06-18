package com.datatable.framework.plugin.jooq.rx3;

import com.datatable.framework.plugin.jooq.shared.QueryResult;
import com.datatable.framework.plugin.jooq.shared.UnifiedQueryExecutor;
import io.reactivex.rxjava3.core.Single;

/**
 * RXQueryExecutor
 *
 * @author xhz
 */
public interface RXQueryExecutor extends UnifiedQueryExecutor<Single<Integer>,Single<QueryResult>> {
}
