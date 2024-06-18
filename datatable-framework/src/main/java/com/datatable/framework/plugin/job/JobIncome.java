package com.datatable.framework.plugin.job;

import com.datatable.framework.core.runtime.Envelop;
import com.datatable.framework.core.web.core.job.phase.Refer;
import io.reactivex.rxjava3.core.Single;

/**
 * 这个接口提供给job消费
 * @author xhz
 */
public interface JobIncome {

    Single<Envelop> beforeAsync(final Envelop envelop);

    Single<Refer> underway();
}
