package com.datatable.framework.core.web.core.job;


import com.datatable.framework.core.web.core.worker.Mission;

/**
 * JobStore
 * @author xhz
 */
public interface JobStore extends JobReader {


    JobStore remove(Mission mission);

    JobStore update(Mission mission);

    JobStore add(Mission mission);
}
