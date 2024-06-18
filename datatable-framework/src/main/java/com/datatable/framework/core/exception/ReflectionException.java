package com.datatable.framework.core.exception;

import com.datatable.framework.core.enums.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xhz
 * @Description: 参数异常
 */
@EqualsAndHashCode(callSuper = true)
public class ReflectionException extends DataTableException {

    public ReflectionException(ErrorCodeEnum code, String message) {
        super(code, message);
    }

    public ReflectionException(String message) {
        super(message);
    }

    public ReflectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionException(Throwable cause) {
        super(cause);
    }

    public ReflectionException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }
}
