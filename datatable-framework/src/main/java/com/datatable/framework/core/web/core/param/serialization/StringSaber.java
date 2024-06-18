package com.datatable.framework.core.web.core.param.serialization;

import com.datatable.framework.core.funcation.CubeFn;


/**
 * String
 * @author xhz
 */
public class StringSaber extends BaseFieldSaber {

    @Override
    public Object from(final Class<?> paramType,
                       final String literal) {
        return CubeFn.getDefault(null, () ->
                        CubeFn.getSemi(String.class == paramType, getLogger(),
                                () -> literal, () -> ""),
                paramType, literal);
    }
}
