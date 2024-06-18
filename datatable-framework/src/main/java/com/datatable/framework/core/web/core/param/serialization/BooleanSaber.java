package com.datatable.framework.core.web.core.param.serialization;

import com.datatable.framework.core.funcation.CubeFn;
import com.datatable.framework.core.utils.FieldUtil;
/**
 * Boolean
 * @author xhz
 */
public class BooleanSaber extends BaseFieldSaber {



    @Override
    public Object from(final Class<?> paramType,
                       final String literal) {
        return CubeFn.getSemi(boolean.class == paramType || Boolean.class == paramType, getLogger(),
                () -> {
                    verifyInput(!FieldUtil.isBoolean(literal), paramType, literal);
                    return Boolean.parseBoolean(literal);
                }, () -> Boolean.FALSE);
    }
}
