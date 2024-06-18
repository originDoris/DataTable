package com.datatable.framework.plugin.annotation;

import java.lang.annotation.*;

/**
 * mongo 插件注解
 * @author xhz
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Mongo {
}
