package com.datatable.framework.core.annotation;

import com.datatable.framework.core.constants.DefaultConstant;
import com.datatable.framework.core.enums.ServerType;

import java.lang.annotation.*;

/**
 * Agent 注解用来标记Verticle
 *
 * @author xhz
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Agent {


    int instances() default DefaultConstant.DEFAULT_INSTANCES;

    String group() default DefaultConstant.DEFAULT_GROUP;

    ServerType type() default ServerType.HTTP;

    boolean ha() default false;
}
