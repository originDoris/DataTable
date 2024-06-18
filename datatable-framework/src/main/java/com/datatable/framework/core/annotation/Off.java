package com.datatable.framework.core.annotation;

import com.datatable.framework.core.web.core.job.DefaultClass;

import java.lang.annotation.*;

/**
 * @author xhz
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Off {


    String address() default "";

    Class<?> outcome() default DefaultClass.class;
}
