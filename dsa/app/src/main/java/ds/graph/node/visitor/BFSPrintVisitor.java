package ds.graph.node.visitor;

import ds.graph.list.ListNode;

public class BFSPrintVisitor<DataType, IndexType> extends BFSVisitor<DataType, IndexType> {
    @Override
    public void perform(ListNode<DataType, IndexType> node) {
        System.out.println(node);
    }
}
