package com.datatable.framework.core.web.core.route.adaptor;


import com.datatable.framework.core.runtime.Envelop;
import io.vertx.rxjava3.core.http.HttpServerResponse;


/**
 * json结果
 * @author xhz
 */
public class JsonWings implements Wings {
    @Override
    public void output(final HttpServerResponse response, final Envelop envelop) {
        response.end(envelop.outString()).subscribe();
    }
}
