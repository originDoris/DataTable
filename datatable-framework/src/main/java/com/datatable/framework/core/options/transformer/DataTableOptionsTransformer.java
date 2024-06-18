package com.datatable.framework.core.options.transformer;

import io.vertx.core.json.JsonObject;

/**
 * PoolOptions 转换器
 *
 * @author xhz
 */
public class DataTableOptionsTransformer implements Transformer<com.datatable.framework.core.options.DataTableOptions>{
    @Override
    public com.datatable.framework.core.options.DataTableOptions transform(JsonObject input) {
        return null == input ? new com.datatable.framework.core.options.DataTableOptions() : new com.datatable.framework.core.options.DataTableOptions(input);
    }
}
