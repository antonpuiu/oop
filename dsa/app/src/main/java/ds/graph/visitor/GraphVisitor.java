package ds.graph.visitor;

import ds.graph.Graph;
import ds.graph.node.Node;

public interface GraphVisitor<NodeType extends Node<DataType, IndexType>, DataType, IndexType> {
    public void visit(Graph<NodeType, DataType, IndexType> graph, IndexType index);
    public void action(NodeType node);
}
