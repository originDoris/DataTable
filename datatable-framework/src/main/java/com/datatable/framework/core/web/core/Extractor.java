package com.datatable.framework.core.web.core;

/**
 * Extractor
 *
 * @author xhz
 */
public interface Extractor<T> {

    T extract(Class<?> clazz);
}
