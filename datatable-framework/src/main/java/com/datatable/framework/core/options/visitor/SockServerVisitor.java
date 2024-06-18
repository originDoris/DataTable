package com.datatable.framework.core.options.visitor;

import com.datatable.framework.core.enums.ServerType;

/**
 * Sock服务配置
 *
 * @author xhz
 */
public class SockServerVisitor extends HttpServerVisitor {
    @Override
    public ServerType getType() {
        return ServerType.SOCK;
    }
}
