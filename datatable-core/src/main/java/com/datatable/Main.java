package com.datatable;

import com.datatable.framework.core.annotation.StartUp;
import com.datatable.framework.core.vertx.VertxApplication;

/**
 * 启动类
 *
 * @author xhz
 */
@StartUp(scanBasePackages = "com.datatable")
public class Main {
    public static void main(String[] args) {
        VertxApplication.run(Main.class);
    }
}