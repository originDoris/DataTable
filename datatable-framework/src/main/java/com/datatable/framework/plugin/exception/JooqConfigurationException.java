package com.datatable.framework.plugin.exception;

import com.datatable.framework.core.enums.ErrorCodeEnum;

/**
 * 表达式解析器
 *
 * @author xhz
 */
public class JooqConfigurationException extends com.datatable.framework.core.exception.DataTableException {
    public JooqConfigurationException(ErrorCodeEnum code, String message) {
        super(code, message);
    }

    public JooqConfigurationException() {
        super("jooq configuration is null!");
    }

    public JooqConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JooqConfigurationException(Throwable cause) {
        super(cause);
    }

    public JooqConfigurationException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }
}
