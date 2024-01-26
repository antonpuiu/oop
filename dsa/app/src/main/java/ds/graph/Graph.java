package ds.graph;

import ds.graph.node.Node;
import ds.graph.visitor.GraphVisitor;
import ds.list.List;
import ds.set.VectorSet;

public abstract class Graph<NodeType extends Node<DataType, IndexType>, DataType, IndexType> {
    protected VectorSet<NodeType> nodes;

    public Graph() {
        nodes = new VectorSet<>();
    }

    public void addNode(NodeType node) {
        nodes.add(node);
    }

    public NodeType getNode(IndexType index) {
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

    public abstract List<NodeType> getNeighbors(IndexType index);
    public abstract void accept(GraphVisitor<NodeType, DataType, IndexType> visitor, IndexType index);
}
