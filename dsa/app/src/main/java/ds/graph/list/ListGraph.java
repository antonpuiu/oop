package ds.graph.list;

import java.util.Iterator;

import ds.graph.Graph;
import ds.graph.visitor.GraphVisitor;
import ds.list.List;

public class ListGraph<NodeType extends ListNode<DataType, IndexType>, DataType, IndexType>
        extends Graph<NodeType, DataType, IndexType>
        implements Iterable<NodeType> {
    @Override
    public Iterator<NodeType> iterator() {
        return nodes.iterator();
    }

    @Override
    public void accept(GraphVisitor<NodeType, DataType, IndexType> visitor, IndexType index) {
        visitor.visit(this, index);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<NodeType> getNeighbors(IndexType index) {
        for (NodeType node : nodes) {
            if (node.getIndex().equals(index))
                return (List<NodeType>) node.getNeighbors();
        }

        return null;
    }
}
