package com.datatable.framework.core.web.core.inquirer;


import com.datatable.framework.core.annotation.Consumer;
import com.datatable.framework.core.annotation.Di;
import com.datatable.framework.core.annotation.EndPoint;
import io.reactivex.rxjava3.core.Observable;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class DiInquirer implements Inquirer<Set<Class<?>>> {

    @Override
    public Set<Class<?>> scan(final Set<Class<?>> allClasses) {
        final Set<Class<?>> pointers = new HashSet<>();
        // Filter Queue & Event
        Observable.fromIterable(allClasses)
                .filter(clazz -> !clazz.isAnnotationPresent(Consumer.class) &&
                        !clazz.isAnnotationPresent(EndPoint.class))
                .filter(this::isValid)
                .subscribe(pointers::add)
                .dispose();
        return pointers;
    }

    private boolean isValid(final Class<?> clazz) {
       return clazz.isAnnotationPresent(Di.class);
    }
}
