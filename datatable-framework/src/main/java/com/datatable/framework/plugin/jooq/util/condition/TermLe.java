package com.datatable.framework.plugin.jooq.util.condition;

import com.datatable.framework.plugin.jooq.util.DateValidator;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;

@SuppressWarnings("all")
public class TermLe implements Term {
    @Override
    public Condition where(final Field field, final String fieldName, final Object value) {
        if (DateValidator.isValidDate(value.toString())) {
            return DSL.field(fieldName).le( DateValidator.convertToLocalDateTime(value.toString()));
        }
        return DSL.field(fieldName).le(value);
    }
}
