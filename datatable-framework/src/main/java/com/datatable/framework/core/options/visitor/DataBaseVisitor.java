package com.datatable.framework.core.options.visitor;

import com.datatable.framework.core.options.DataBaseOptions;
import com.datatable.framework.core.options.transformer.DataBaseTransformer;
import com.datatable.framework.core.options.transformer.Transformer;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;

/**
 * DataBaseVisitor
 *
 * @author xhz
 */
public class DataBaseVisitor implements ConfigVisitor<DataBaseOptions> {

    private transient final Transformer<DataBaseOptions> dataBaseOptionsTransformer = ReflectionUtils.singleton(DataBaseTransformer.class);

    @Override
    public DataBaseOptions visit(String... keys) throws com.datatable.framework.core.exception.DataTableException {
        return dataBaseOptionsTransformer.transform(getConfig(keys[0]));
    }
}
