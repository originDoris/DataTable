package com.datatable.framework.plugin.jooq.generate.rx3;

import com.datatable.framework.plugin.jooq.generate.builder.DelegatingVertxGenerator;
import com.datatable.framework.plugin.jooq.generate.builder.PredefinedNamedInjectionStrategy;
import com.datatable.framework.plugin.jooq.generate.builder.VertxGeneratorBuilder;

/**
 *
 * @author xhz
 **/
public class RXReactiveGuiceVertxGenerator extends DelegatingVertxGenerator {

    public RXReactiveGuiceVertxGenerator() {
        super(VertxGeneratorBuilder.init().withRX3API().withPostgresReactiveDriver().withGuice(true, PredefinedNamedInjectionStrategy.DISABLED).build());
    }
}
