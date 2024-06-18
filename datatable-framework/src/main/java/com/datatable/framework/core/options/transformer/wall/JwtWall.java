package com.datatable.framework.core.options.transformer.wall;

import com.datatable.framework.core.enums.WallType;
import com.datatable.framework.core.options.transformer.Transformer;
import com.datatable.framework.core.web.core.secure.Cliff;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;
import lombok.Data;

/**
 * jwt 配置解析
 *
 * @author xhz
 */
@Data
public class JwtWall implements Transformer<Cliff> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtWall.class);
    @Override
    public Cliff transform(JsonObject input) {
        final Cliff cliff = new Cliff();
        cliff.setType(WallType.JWT);
        cliff.setConfig(input.getJsonObject("config"));
        return cliff;
    }
}
