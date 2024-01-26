package ds.graph.node.visitor.dfs;

import ds.graph.Graph;
import ds.graph.node.Node;
import ds.graph.node.Node.NodeColor;
import ds.graph.node.visitor.NodeVisitor;
import ds.list.List;
import ds.stack.ListStack;
import ds.stack.Stack;

public abstract class DFSVisitor<NodeType extends Node<DataType, IndexType>, DataType, IndexType>
    implements NodeVisitor<NodeType, DataType, IndexType> {
    private Stack<NodeType> stack;

    public DFSVisitor() {
        stack = new ListStack<>();
    }

    @Override
    public void visit(Graph<NodeType, DataType, IndexType> graph, IndexType index) {
        NodeType node = graph.getNode(index);

        node.setColor(NodeColor.GRAY);
        stack.push(node);

        while (!stack.empty()) {
            NodeType crtNode = stack.peek();
            List<NodeType> neighbors = graph.getNeighbors(crtNode.getIndex());
            boolean newNeighbor = false;

            action(crtNode);

            for (NodeType neighbor : neighbors) {
                if (neighbor.getColor().equals(NodeColor.WHITE)) {
                    neighbor.setColor(NodeColor.GRAY);
                    stack.push(neighbor);
                    newNeighbor = true;
                    break;
                }
            }

            if (newNeighbor)
                continue;

            crtNode.setColor(NodeColor.BLACK);
            stack.pop();
        }
    }
}
