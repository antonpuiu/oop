package ds.graph;

import ds.graph.node.Node;
import ds.set.VectorSet;

public class Graph<DataType, IndexType> {
    protected VectorSet<Node<DataType, IndexType>> nodes;

    public Graph() {
        nodes = new VectorSet<>();
    }

    public void addNode(Node<DataType, IndexType> node) {
        nodes.add(node);
    }

    public void removeNode(Node<DataType, IndexType> node) {
        nodes.remove(node);
    }

    public Node<DataType, IndexType> getNode(IndexType index) {
        for (var node : nodes)
            if (node.getIndex().equals(index))
                return node;

        return null;
    }

    public boolean removeNode(IndexType index) {
        for (var node : nodes) {
            if (node.getIndex().equals(index)) {
                nodes.remove(node);

                return true;
            }
        }

        return false;
    }
}
