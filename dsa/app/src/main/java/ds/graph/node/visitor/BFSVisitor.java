package ds.graph.node.visitor;

import ds.graph.list.ListNode;
import ds.graph.node.Node.NodeColor;
import ds.queue.ListQueue;
import ds.queue.Queue;

public abstract class BFSVisitor<DataType, IndexType> implements NodeVisitor<DataType, IndexType> {
    private Queue<ListNode<DataType, IndexType>> queue;

    public BFSVisitor() {
        queue = new ListQueue<>();
    }

    public abstract void perform(ListNode<DataType, IndexType> node);

    @Override
    public void visit(ListNode<DataType, IndexType> node) {
        perform(node);

        for (ListNode<DataType, IndexType>.Edge edge : node)
            queue.enqueue(edge.getDst());

        node.setColor(NodeColor.GRAY);

        while (!queue.empty()) {
            var crtNode = queue.dequeue();

            if (!crtNode.getColor().equals(NodeColor.WHITE))
                continue;

            perform(crtNode);

            for (var edge : crtNode)
                queue.enqueue(edge.getDst());

            crtNode.setColor(NodeColor.GRAY);
        }
    }
}
