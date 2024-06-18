package com.datatable.framework.core.web.core.param.serialization;


import com.datatable.framework.core.constants.ErrorInfoConstant;
import com.datatable.framework.core.enums.ErrorCodeEnum;
import com.datatable.framework.core.exception.datatableException;
import com.datatable.framework.core.funcation.CubeFn;

import java.io.File;
import java.text.MessageFormat;

/**
 * file
 * @author xhz
 */
public class FileSaber extends BaseFieldSaber {

    @Override
    public Object from(final Class<?> paramType,
                       final String filename) {
        return CubeFn.getDefault(null, () -> {
            final File file = new File(filename);
            CubeFn.outError(getLogger(), !file.exists() || !file.canRead(), datatableException.class, ErrorCodeEnum.FILE_NOT_EXIST_ERROR, MessageFormat.format(ErrorInfoConstant.FILE_NOT_EXIST_ERROR, filename, paramType));
            return file;
        }, paramType, filename);
    }
}
