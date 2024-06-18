package com.datatable.framework.core.web.core.thread;

import com.datatable.framework.core.constants.MessageConstant;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import com.datatable.framework.core.web.core.Extractor;
import com.datatable.framework.core.web.core.agent.Event;
import com.datatable.framework.core.web.core.agent.EventExtractor;
import com.datatable.framework.core.web.core.agent.Hook;
import com.datatable.framework.core.web.core.agent.InitialExtractor;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * 扫描所有的Initial方法
 *
 * @author xhz
 */
@Slf4j
public class InitialThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitialThread.class);

    @Getter
    private final Set<Hook> hooks = new HashSet<>();

    private final transient Extractor<Set<Hook>> extractor = ReflectionUtils.newInstance(InitialExtractor.class);

    private final transient Class<?> reference;

    public InitialThread(final Class<?> clazz) {
        this.setName("datatable-initial-scanner-" + this.getId());
        this.reference = clazz;
    }

    @Override
    public void run() {
        if (null != this.reference) {
            this.hooks.addAll(this.extractor.extract(this.reference));
            LOGGER.info(MessageFormat.format(MessageConstant.SCANNED_INITIALS, this.reference.getName(), this.hooks.size()));
        }
    }

}
