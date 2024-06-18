package com.datatable.framework.core.web.core.param.resolver;


import com.datatable.framework.core.exception.WebException;
import com.datatable.framework.core.web.core.param.ParamContainer;
import io.vertx.rxjava3.ext.web.RoutingContext;

/**
 * form 转换 预留
 * @author xhz
 */
public class XFormResolver<T> implements Resolver<T> {

    @Override
    public ParamContainer<T> resolve(final RoutingContext context,
                                     final ParamContainer<T> income) throws WebException {
        return income;
    }
}