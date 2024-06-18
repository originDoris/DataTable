package com.datatable.framework.core.options.visitor;

import com.datatable.framework.core.options.ProxyOptions;
import com.datatable.framework.core.options.transformer.ProxyOptionsTransformer;
import com.datatable.framework.core.options.transformer.Transformer;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import io.vertx.core.json.JsonObject;


/**
 * ProxyOptionsVisitor
 *
 * @author xhz
 */
public class ProxyOptionsVisitor implements ConfigVisitor<ProxyOptions> {

    public static final String KEY = "proxy";

    private transient final Transformer<ProxyOptions> proxyOptionsTransformer = ReflectionUtils.singleton(ProxyOptionsTransformer.class);

    @Override
    public ProxyOptions visit(String... keys) throws com.datatable.framework.core.exception.DataTableException {
        JsonObject config = getConfig(KEY);
        if (config == null) {
            return new ProxyOptions();
        }
        return proxyOptionsTransformer.transform(config);
    }
}
