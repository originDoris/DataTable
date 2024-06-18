package com.datatable.framework.core.options.visitor;

import com.datatable.framework.core.constants.StringsConstant;
import com.datatable.framework.core.utils.config.ConfigTool;
import io.vertx.core.json.JsonObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * 配置文件 - 访问者
 *
 * @author xhz
 */

public interface ConfigVisitor<T> {
    T visit(String... keys) throws com.datatable.framework.core.exception.DataTableException;

    default JsonObject getConfig(String key){
        String env = System.getProperty(StringsConstant.ENV, StringsConstant.DEV);
        try {
            JsonObject data = ConfigTool.read(env, null);
            if (StringUtils.isBlank(key)) {
                return data;
            }
            return data.getJsonObject(key);
        } catch (IOException e) {
            throw new com.datatable.framework.core.exception.DataTableException(e);
        }
    }
}
