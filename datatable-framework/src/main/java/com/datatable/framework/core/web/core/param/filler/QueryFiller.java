package com.datatable.framework.core.web.core.param.filler;

import com.datatable.framework.core.runtime.datatableSerializer;
import io.vertx.rxjava3.core.MultiMap;
import io.vertx.rxjava3.ext.web.RoutingContext;

/**
 * 处理@QueryParam
 * @author xhz
 */
public class QueryFiller implements Filler {

    @Override
    public Object apply(final String name, final Class<?> paramType, final RoutingContext context) {
        MultiMap entries = context.queryParams();
        return datatableSerializer.getValue(paramType, entries.get(name));
    }
}
