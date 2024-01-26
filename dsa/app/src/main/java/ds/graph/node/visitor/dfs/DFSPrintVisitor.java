package ds.graph.node.visitor.dfs;

import ds.graph.node.Node;

public class DFSPrintVisitor<NodeType extends Node<DataType, IndexType>, DataType, IndexType>
    extends DFSVisitor<NodeType, DataType, IndexType> {
    @Override
    public void action(NodeType node) {
        System.out.println(node);
    }
}
