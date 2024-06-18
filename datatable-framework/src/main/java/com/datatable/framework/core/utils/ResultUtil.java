package com.datatable.framework.core.utils;

import com.datatable.framework.core.enums.ErrorCodeEnum;
import com.datatable.framework.core.exception.InternalServerException;
import com.datatable.framework.core.exception.ParamException;
import com.datatable.framework.core.exception.WebException;
import com.datatable.framework.core.funcation.CubeFn;
import com.datatable.framework.core.runtime.Envelop;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

/**
 * 返回信息工具类
 *
 * @author xhz
 */
public class ResultUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultUtil.class);

    @SuppressWarnings("all")
    public static <T> Envelop toEnvelop(final T entity) {
        return CubeFn.getDefault(Envelop.ok(),
                () -> CubeFn.getSemi(entity instanceof com.datatable.framework.core.exception.DataTableException, LOGGER,
                        () -> Envelop.failure((WebException) entity),
                        () -> {
                            if (Envelop.class == entity.getClass()) {
                                return (Envelop) entity;
                            } else {
                                return Envelop.success(entity);
                            }
                        }),
                entity);
    }


    public static com.datatable.framework.core.exception.DataTableException toError(final Class<?> clazz, final Throwable error) {
        return CubeFn.getSemi(error instanceof ParamException, LOGGER,
                () -> (ParamException) error,
                () -> new InternalServerException(ErrorCodeEnum.INTERNAL_ERROR,  error.getMessage()));
    }
}
