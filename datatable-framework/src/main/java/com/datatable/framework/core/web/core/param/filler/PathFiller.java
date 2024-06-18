package com.datatable.framework.core.web.core.param.filler;

import com.datatable.framework.core.runtime.datatableSerializer;
import io.vertx.rxjava3.ext.web.RoutingContext;

/**
 * 处理.@PathParam
 * @author xhz
 */
public class PathFiller implements Filler {
    @Override
    public Object apply(final String name, final Class<?> paramType, final RoutingContext context) {
        return datatableSerializer.getValue(paramType, context.pathParam(name));
    }
}
