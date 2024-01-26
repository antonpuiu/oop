package ds.graph.list;

import java.util.Iterator;

import ds.graph.Graph;
import ds.graph.node.Node;

public class ListGraph<DataType, IndexType, WeightType>
    extends Graph<DataType, IndexType>
    implements Iterable<Node<DataType, IndexType>> {
    @Override
    public Iterator<Node<DataType, IndexType>> iterator() {
        return nodes.iterator();
    }
}
