package com.datatable.framework.core.exception;

import com.datatable.framework.core.enums.ErrorCodeEnum;

/**
 * 构建Event异常
 *
 * @author xhz
 */
public class EventSourceException extends DataTableException {
    public EventSourceException(ErrorCodeEnum code, String message) {
        super(code, message);
    }

    public EventSourceException(String message) {
        super(message);
    }

    public EventSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventSourceException(Throwable cause) {
        super(cause);
    }

    public EventSourceException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }
}
