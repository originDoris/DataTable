package com.datatable.framework.plugin.jooq.shared.postgres;

import io.vertx.core.json.JsonArray;
import org.jooq.Converter;
import org.jooq.JSONB;

import java.util.function.Function;

/**
 * JSONBToJsonArray
 * @author xhz
 */
public class JSONBToJsonArrayBinding extends PGJsonToVertxJsonBinding<JSONB, JsonArray> {

    @Override
    public Converter<JSONB, JsonArray> converter() {
        return JSONBToJsonArrayConverter.getInstance();
    }

    @Override
    Function<String, JSONB> valueOf() {
        return JSONB::valueOf;
    }

    @Override
    String coerce() {
        return "::jsonb";
    }

}
