package ds.graph.node.visitor;

import ds.graph.list.ListNode;

public interface NodeVisitor<DataType, IndexType> {
    public void visit(ListNode<DataType, IndexType> node);
}
