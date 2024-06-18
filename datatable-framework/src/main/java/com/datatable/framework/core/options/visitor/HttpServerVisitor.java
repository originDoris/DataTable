package com.datatable.framework.core.options.visitor;

import com.datatable.framework.core.enums.ServerType;
import com.datatable.framework.core.funcation.CubeFn;
import com.datatable.framework.core.options.transformer.HttpServerOptionsTransformer;
import com.datatable.framework.core.options.transformer.Transformer;
import com.datatable.framework.core.utils.JsonUtil;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * HttpServerVisitor
 *
 * @author xhz
 */
public class HttpServerVisitor implements ServerVisitor<HttpServerOptions> {


    private transient final Transformer<HttpServerOptions> httpServerOptionsTransformer = ReflectionUtils.singleton(HttpServerOptionsTransformer.class);
    @Override
    public ConcurrentMap<Integer, HttpServerOptions> visit(String... keys) throws com.datatable.framework.core.exception.DataTableException {
        JsonObject config = getConfig(null);
        return visit(config.getJsonArray(KEY));
    }

    private ConcurrentMap<Integer, HttpServerOptions> visit(final JsonArray serverData) {
        final ConcurrentMap<Integer, HttpServerOptions> map = new ConcurrentHashMap<>();
        this.extract(serverData, map);
        return map;
    }

    protected void extract(final JsonArray serverData, final ConcurrentMap<Integer, HttpServerOptions> map) {
        if (serverData == null) {
            return;
        }
        for (Object serverDatum : serverData) {
            JsonObject item = JsonUtil.toJsonObject(serverDatum);
            if (this.isServer(item)) {
                JsonObject jsonObject = item.getJsonObject(YKEY_CONFIG);
                final int port = this.extractPort(jsonObject);
                final HttpServerOptions options = this.httpServerOptionsTransformer.transform(jsonObject);
                CubeFn.safeNull(() -> {
                    map.put(port, options);
                }, port, options);
            }

        }
    }

    protected boolean isServer(final JsonObject item) {
        return this.getType().match(item.getString(YKEY_TYPE));
    }

    private int extractPort(final JsonObject config) {
        if (null != config) {
            return config.getInteger("port", HttpServerOptions.DEFAULT_PORT);
        }
        return HttpServerOptions.DEFAULT_PORT;
    }

    protected ServerType getType() {
        return ServerType.HTTP;
    }
}
