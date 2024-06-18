package com.datatable.framework.core.options.transformer;

import io.vertx.core.json.JsonObject;


/**
 * @Description:  JsonObject 数据转换接口
 * @author xhz
 */
public interface Transformer<T> {

    T transform(JsonObject input);
}
