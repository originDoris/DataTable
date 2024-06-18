package com.datatable.framework.core.options.transformer.wall;

import com.datatable.framework.core.enums.WallType;
import com.datatable.framework.core.options.transformer.Transformer;
import com.datatable.framework.core.web.core.secure.Cliff;
import io.vertx.core.json.JsonObject;

/**
 * 表达式解析器
 *
 * @author xhz
 */
public class MongoWall implements Transformer<Cliff> {
    @Override
    public Cliff transform(JsonObject input) {
        final Cliff cliff = new Cliff();
        cliff.setType(WallType.MONGO);
        cliff.setConfig(input.getJsonObject("config"));
        return cliff;
    }
}
