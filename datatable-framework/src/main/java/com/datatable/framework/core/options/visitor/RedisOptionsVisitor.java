package com.datatable.framework.core.options.visitor;

import com.datatable.framework.core.options.transformer.RedisOptionsTransformer;
import com.datatable.framework.core.options.transformer.Transformer;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import io.vertx.core.json.JsonObject;
import io.vertx.redis.client.RedisOptions;

/**
 * RedisOptionsVisitor
 *
 * @author xhz
 */
public class RedisOptionsVisitor implements ConfigVisitor<RedisOptions> {

    public static final String KEY = "redis";

    private transient final Transformer<RedisOptions> redisOptionsTransformer = ReflectionUtils.singleton(RedisOptionsTransformer.class);

    @Override
    public RedisOptions visit(String... keys) throws com.datatable.framework.core.exception.DataTableException {
        JsonObject config = getConfig(KEY);
        if (config == null) {
            return new RedisOptions();
        }
        return redisOptionsTransformer.transform(config);
    }
}
