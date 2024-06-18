package com.datatable.framework.core.web.core.param.serialization;

import com.datatable.framework.core.constants.ErrorInfoConstant;
import com.datatable.framework.core.exception.datatableException;
import com.datatable.framework.core.funcation.CubeFn;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

import java.text.MessageFormat;

/**
 * BaseSaber
 *
 * @author xhz
 */
public abstract class BaseFieldSaber implements FieldSerializable {
    void verifyInput(final boolean condition,
                     final Class<?> paramType,
                     final String literal) {
        CubeFn.outError(getLogger(), condition, datatableException.class,
                MessageFormat.format(ErrorInfoConstant.FIELD_SERIALIZABLE_ERROR, paramType, literal));
    }

    protected Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public <T> Object from(final T input) {
        return input;
    }

    @Override
    public Object from(final Class<?> paramType,
                       final String literal) {
        return literal;
    }
}
