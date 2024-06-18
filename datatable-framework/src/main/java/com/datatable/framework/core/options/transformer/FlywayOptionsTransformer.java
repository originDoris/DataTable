package com.datatable.framework.core.options.transformer;

import com.datatable.framework.core.options.FlywayOptions;
import io.vertx.core.json.JsonObject;

/**
 * 表达式解析器
 *
 * @author xhz
 */
public class FlywayOptionsTransformer implements Transformer<FlywayOptions>{
    @Override
    public FlywayOptions transform(JsonObject input) {
        return null == input ? new FlywayOptions() : new FlywayOptions(input);
    }
}
