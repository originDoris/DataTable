package com.datatable.framework.core.options.visitor;

import io.vertx.core.json.JsonObject;

/**
 * 插件配置读取
 *
 * @author xhz
 */
public class InjectVisitor implements ConfigVisitor<JsonObject> {
    @Override
    public JsonObject visit(String... keys) throws com.datatable.framework.core.exception.DataTableException {
        return getConfig(keys[0]);
    }
}
