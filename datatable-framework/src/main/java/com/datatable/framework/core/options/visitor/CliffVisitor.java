package com.datatable.framework.core.options.visitor;

import com.datatable.framework.core.options.transformer.CliffTransformer;
import com.datatable.framework.core.options.transformer.Transformer;
import com.datatable.framework.core.utils.reflection.ReflectionUtils;
import com.datatable.framework.core.web.core.secure.Cliff;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 表达式解析器
 *
 * @author xhz
 */
@Slf4j
public class CliffVisitor implements ConfigVisitor<Cliff> {
    public static final String KEY = "secure";

    private transient final Transformer<Cliff> cliffTransformer = ReflectionUtils.singleton(CliffTransformer.class);

    @Override
    public Cliff visit(String... keys) throws com.datatable.framework.core.exception.DataTableException {
        JsonObject config = getConfig(KEY);
        log.info("加载配置文件前缀：{}, name:{},data:{}", KEY, this.getClass().getSimpleName(), config);
        return this.cliffTransformer.transform(config);
    }
}
