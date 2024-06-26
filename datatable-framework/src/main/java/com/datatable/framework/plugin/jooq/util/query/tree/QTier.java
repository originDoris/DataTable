package com.datatable.framework.plugin.jooq.util.query.tree;


import com.datatable.framework.core.funcation.CubeFn;

import java.util.HashSet;
import java.util.Set;

/**
 * 分支节点 必须是and 或or
 * @author xhz
 */
public class QTier implements QBranch {

    private transient final QOp op;
    private transient final Set<QNode> nodes = new HashSet<>();

    private transient Integer level = 0;

    private QTier(final QOp op) {
        this.op = null == op ? QOp.AND : op;
    }

    static QTier create(final QOp op) {
        return new QTier(op);
    }

    @Override
    public boolean isLeaf() {
        return false;
    }


    @Override
    public QOp op() {
        return this.op;
    }

    @Override
    public QNode level(final Integer level) {
        this.level = level;
        return this;
    }

    @Override
    public Set<QNode> nodes() {
        return this.nodes;
    }

    @Override
    public QTier add(final QNode node) {
        this.nodes.add(node);
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder source = new StringBuilder();
        CubeFn.exec(this.level, () -> source.append("\t"));
        source.append("Branch").append(",");
        source.append("OP：").append(this.op).append(",");
        source.append("Node：").append("\n");
        this.nodes.forEach(node -> {
            CubeFn.exec(this.level, () -> source.append("\t"));
            source.append(node).append("\n");
        });
        return source.toString();
    }
}
