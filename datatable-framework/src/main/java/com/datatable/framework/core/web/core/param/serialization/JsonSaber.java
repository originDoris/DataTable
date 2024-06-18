package com.datatable.framework.core.web.core.param.serialization;

import com.datatable.framework.core.enums.ErrorCodeEnum;
import com.datatable.framework.core.exception.datatableException;
import com.datatable.framework.core.funcation.CubeFn;
import io.vertx.core.json.DecodeException;
import java.util.function.Function;

/**
 * Json
 * @author xhz
 */
public abstract class JsonSaber extends BaseFieldSaber {

    @Override
    public Object from(final Class<?> paramType,
                       final String literal) {
        return CubeFn.getDefault(null, () -> CubeFn.getSemi(isValid(paramType), getLogger(),
                        () -> {
                            try {
                                return getFun().apply(literal);
                            } catch (final DecodeException ex) {
                                throw new datatableException(ErrorCodeEnum.PARAM_ERROR_CODE, "字符串必须是标准JSON格式！");
                            }
                        }, () -> null),
                paramType, literal);
    }

    protected abstract boolean isValid(final Class<?> paramType);

    protected abstract <T> Function<String, T> getFun();
}
