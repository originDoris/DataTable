package com.datatable.framework.plugin.jooq.database;

import com.datatable.framework.core.enums.DatabaseType;
import org.jooq.SQLDialect;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

interface Pool {

    ConcurrentMap<String, DataPool> POOL_DYNAMIC = new ConcurrentHashMap<>();

    ConcurrentMap<DatabaseType, SQLDialect> DIALECT = new ConcurrentHashMap<DatabaseType, SQLDialect>() {
        {
            this.put(DatabaseType.MYSQL5, SQLDialect.MYSQL);
            this.put(DatabaseType.ORACLE12, SQLDialect.DEFAULT);
            this.put(DatabaseType.POSTGRESQL, SQLDialect.POSTGRES);
        }
    };
}
