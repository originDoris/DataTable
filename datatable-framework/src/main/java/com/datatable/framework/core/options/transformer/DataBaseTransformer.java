package com.datatable.framework.core.options.transformer;

import com.datatable.framework.core.options.DataBaseOptions;
import io.vertx.core.json.JsonObject;

/**
 * DataBaseTransformer
 *
 * @author xhz
 */
public class DataBaseTransformer implements Transformer<DataBaseOptions>{
    @Override
    public DataBaseOptions transform(JsonObject input) {
        return input == null ? new DataBaseOptions() : new DataBaseOptions(input);
    }
}
