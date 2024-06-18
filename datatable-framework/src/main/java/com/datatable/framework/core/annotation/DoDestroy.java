package com.datatable.framework.core.annotation;

import java.lang.annotation.*;

/**
 * 服务停止前执行
 *
 * @author xhz
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DoDestroy {
}
