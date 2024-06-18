package com.datatable.framework.core.web.core.route.adaptor;

import com.datatable.framework.core.runtime.Envelop;
import io.vertx.rxjava3.core.http.HttpServerResponse;


/**
 *
 * @author xhz
 */
public class BufferWings implements Wings {
    @Override
    public void output(final HttpServerResponse response, final Envelop envelop) {
        response.end(envelop.outBuffer()).subscribe();
    }
}
