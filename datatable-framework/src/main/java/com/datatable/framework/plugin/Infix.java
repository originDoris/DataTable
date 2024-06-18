package com.datatable.framework.plugin;

import com.datatable.framework.core.constants.ErrorInfoConstant;
import com.datatable.framework.core.enums.ErrorCodeEnum;
import com.datatable.framework.core.funcation.CubeFn;
import com.datatable.framework.core.options.visitor.InjectVisitor;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;


import java.text.MessageFormat;
import java.util.function.Function;

interface InfixTool {

    static JsonObject init(
            final Logger logger,
            final String key,
            final Class<?> clazz) {
        InjectVisitor injectVisitor = ReflectionUtils.singleton(InjectVisitor.class);
        JsonObject options = injectVisitor.getConfig(key);
        CubeFn.outError(logger, null == options,
                com.datatable.framework.core.exception.DataTableException.class,
                ErrorCodeEnum.CONFIG_KEY_MISSING_ERROR,
                MessageFormat.format(ErrorInfoConstant.CONFIG_KEY_MISSING_ERROR, clazz, key));
        return options;
    }

    static <R> R init(
            final JsonObject config,
            final Function<JsonObject, R> executor) {
        return executor.apply(config);
    }
}

/**
 * 插件根类
 * @author xhz
 */
public interface Infix {

    static <R> R initTp(final String key,
                        final Function<JsonObject, R> executor,
                        final Class<?> clazz) {
        final Logger logger = LoggerFactory.getLogger(clazz);
        final JsonObject options = InfixTool.init(logger, key, clazz);
        final JsonObject config = null == options.getJsonObject(key) ? new JsonObject() : options.getJsonObject(key);
        return InfixTool.init(config, executor);
    }

    static <R> R init(final String key,
                      final Function<JsonObject, R> executor,
                      final Class<?> clazz) {
        final Logger logger = LoggerFactory.getLogger(clazz);
        final JsonObject options = InfixTool.init(logger, key, clazz);
        return InfixTool.init(options, executor);
    }

    <T> T get();
}
