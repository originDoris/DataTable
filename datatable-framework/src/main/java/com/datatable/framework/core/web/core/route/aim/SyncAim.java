package com.datatable.framework.core.web.core.route.aim;

import com.datatable.framework.core.funcation.CubeFn;
import com.datatable.framework.core.runtime.Envelop;
import com.datatable.framework.core.web.core.agent.Event;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.vertx.core.Handler;
import io.vertx.rxjava3.ext.web.RoutingContext;

/**
 * SyncAim 不适用eventBus时 请求 - 响应模式
 * @author xhz
 */
public class SyncAim extends BaseAim implements Aim<RoutingContext> {
    @Override
    public Handler<RoutingContext> attack(final Event event) {
        return CubeFn.getDefault(null, () -> (context) -> this.exec(() -> {
            // 构建参数
            final Object[] arguments = this.buildArgs(context, event);

            try {
                final Object result = this.invoke(event, arguments);
                Single<Envelop> next = Flower.next(context, result);
                Disposable subscribe = next.subscribe(dataRes -> {
                    Answer.reply(context, dataRes, event);
                });
            } catch (final Throwable ex) {
                final Envelop envelop = Envelop.failure(ex);
                Answer.reply(context, envelop);
            }

        }, context, event), event);
    }
}
