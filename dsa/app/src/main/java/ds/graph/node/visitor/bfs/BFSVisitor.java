package ds.graph.node.visitor.bfs;

import ds.graph.Graph;
import ds.graph.node.Node;
import ds.graph.node.Node.NodeColor;
import ds.graph.node.visitor.NodeVisitor;
import ds.queue.ListQueue;
import ds.queue.Queue;

public abstract class BFSVisitor<NodeType extends Node<DataType, IndexType>, DataType, IndexType>
    implements NodeVisitor<NodeType, DataType, IndexType> {
    private Queue<NodeType> queue;

    public BFSVisitor() {
        queue = new ListQueue<>();
    }

    @Override
    public void visit(Graph<NodeType, DataType, IndexType> graph, IndexType index) {
        NodeType node = graph.getNode(index);

        node.setColor(NodeColor.GRAY);
        queue.enqueue(node);

        while (!queue.empty()) {
            NodeType crtNode = queue.dequeue();

            action(crtNode);

            for (var neighbor : graph.getNeighbors(crtNode.getIndex())) {
                if (neighbor.getColor().equals(NodeColor.WHITE)) {
                    neighbor.setColor(NodeColor.GRAY);
                    queue.enqueue(neighbor);
                }
            }

            crtNode.setColor(NodeColor.BLACK);
        }
    }
}
