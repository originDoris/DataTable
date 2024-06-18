package com.datatable.framework.plugin.redis;

import com.datatable.framework.core.annotation.Plugin;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import com.datatable.framework.plugin.Infix;
import com.datatable.framework.plugin.Plugins;
import io.vertx.redis.client.RedisOptions;
import io.vertx.rxjava3.core.Vertx;
import io.vertx.rxjava3.redis.client.Redis;
import io.vertx.rxjava3.redis.client.RedisAPI;

import java.util.concurrent.atomic.AtomicReference;

/**
 * redis 插件
 *
 * @author xhz
 */
@Plugin
@SuppressWarnings("unchecked")
public class RedisInfix implements Infix {

    private static final AtomicReference<RedisAPI> REDIS = new AtomicReference<>();

    public static void init(final Vertx vertx) {
        RedisOptions init = Infix.init(Plugins.Infix.REDIS, RedisOptions::new, RedisInfix.class);
        if (REDIS.get() == null) {
            RedisAPI api = RedisAPI.api(Redis.createClient(vertx, init));
            REDIS.set(api);
        }
    }

    @Override
    public RedisInfix get() {
        return ReflectionUtils.singleton(RedisInfix.class);
    }


    public RedisAPI getRedis(){
       return REDIS.get();
    }



}
