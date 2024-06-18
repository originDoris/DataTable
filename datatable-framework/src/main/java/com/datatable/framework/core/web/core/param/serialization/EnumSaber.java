package com.datatable.framework.core.web.core.param.serialization;

import com.datatable.framework.core.funcation.CubeFn;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;

/**
 * Enum
 * @author xhz
 */
public class EnumSaber extends BaseFieldSaber {
    @Override
    public <T> Object from(final T input) {
        return CubeFn.getDefault(null, () -> {
            Object reference = null;
            if (input instanceof Enum) {
                reference = ReflectionUtils.invoke(input, "name");
            }
            return reference;
        }, input);
    }
}
