package ds.graph.node.visitor.bfs;

import ds.graph.node.Node;

public class BFSPrintVisitor<NodeType extends Node<DataType, IndexType>, DataType, IndexType>
    extends BFSVisitor<NodeType, DataType, IndexType> {
    @Override
    public void action(NodeType node) {
        System.out.println(node);
    }
}
