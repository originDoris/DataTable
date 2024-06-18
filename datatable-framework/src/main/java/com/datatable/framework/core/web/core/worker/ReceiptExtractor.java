package com.datatable.framework.core.web.core.worker;

import com.datatable.framework.core.annotation.Address;
import com.datatable.framework.core.annotation.Anno;
import com.datatable.framework.core.constants.ErrorInfoConstant;
import com.datatable.framework.core.constants.MessageConstant;
import com.datatable.framework.core.enums.ErrorCodeEnum;
import com.datatable.framework.core.exception.datatableException;
import com.datatable.framework.core.funcation.CubeFn;
import com.datatable.framework.core.runtime.datatableAnno;
import com.datatable.framework.core.web.core.param.resolver.MethodResolver;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import com.datatable.framework.core.web.core.Extractor;
import com.datatable.framework.core.web.core.inquirer.ReceiptInquirer;
import io.reactivex.rxjava3.core.Observable;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * address receipt 元数据转换
 *
 * @author xhz
 */
public class ReceiptExtractor implements Extractor<Set<Receipt>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptInquirer.class);

    private static final Set<String> ADDRESS = new TreeSet<>();

    static {
        final Set<Class<?>> endpoints = datatableAnno.getEndpoints();
        Observable.fromIterable(endpoints)
                .map(queue -> Anno.query(queue, Address.class))
                .subscribe(annotations -> Observable.fromArray(annotations)
                        .map(addressAnno -> ReflectionUtils.invoke(addressAnno, "value"))
                        .filter(Objects::nonNull)
                        .subscribe(address -> ADDRESS.add(address.toString()))
                        .dispose())
                .dispose();

        LOGGER.info(MessageFormat.format(MessageConstant.ADDRESS_IN, ADDRESS.size()));
        ADDRESS.forEach(item -> LOGGER.info(MessageFormat.format(MessageConstant.ADDRESS_IN, item)));
    }

    @Override
    public Set<Receipt> extract(final Class<?> clazz) {
        return CubeFn.getDefault(new HashSet<>(), () -> {

            CubeFn.outError(LOGGER, !ReflectionUtils.noarg(clazz), datatableException.class, ErrorCodeEnum.NO_ARG_CONSTRUCTOR, MessageFormat.format(ErrorInfoConstant.NO_ARG_CONSTRUCTOR_ERROR, clazz.getName()));
            CubeFn.outError(LOGGER, !Modifier.isPublic(clazz.getModifiers()), datatableException.class, ErrorCodeEnum.NO_ARG_CONSTRUCTOR, MessageFormat.format(ErrorInfoConstant.NOT_PUBLIC_ERROR, clazz.getName()));
            final Set<Receipt> receipts = new HashSet<>();
            final Method[] methods = clazz.getDeclaredMethods();
            Observable.fromArray(methods)
                    .filter(MethodResolver::isValid)
                    .filter(method -> method.isAnnotationPresent(Address.class))
                    .map(this::extract)
                    .filter(Objects::nonNull)
                    .subscribe(receipts::add)
                    .dispose();
            return receipts;
        }, clazz);
    }

    private Receipt extract(final Method method) {
        final Class<?> clazz = method.getDeclaringClass();
        final Annotation annotation = method.getDeclaredAnnotation(Address.class);
        final String address = ReflectionUtils.invoke(annotation, "value");

        CubeFn.outError(LOGGER, !ADDRESS.contains(address),
                datatableException.class, ErrorCodeEnum.ADDRESS_NOT_EXIST_ERROR, MessageFormat.format(ErrorInfoConstant.ADDRESS_NOT_EXIST_ERROR, address));
        final Receipt receipt = new Receipt();
        receipt.setMethod(method);
        receipt.setAddress(address);

        final Object proxy = ReflectionUtils.singleton(clazz);
        receipt.setProxy(proxy);
        return receipt;
    }
}
