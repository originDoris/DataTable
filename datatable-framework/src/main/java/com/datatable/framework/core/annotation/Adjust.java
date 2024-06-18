package com.datatable.framework.core.annotation;

import com.datatable.framework.core.constants.Orders;

import java.lang.annotation.*;

/**
 * 配置event 路由的顺序 默认Orders.EVENT
 *
 * @author xhz
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Adjust {

    int value() default Orders.EVENT;
}
