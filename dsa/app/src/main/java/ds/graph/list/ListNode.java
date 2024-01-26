package ds.graph.list;

import java.util.Iterator;

import ds.graph.Edge;
import ds.graph.node.Node;
import ds.list.List;
import ds.list.custom.ArrayList;

public class ListNode<DataType, IndexType>
        extends Node<DataType, IndexType>
        implements Iterable<ListNode<DataType, IndexType>> {
    private ArrayList<Edge<DataType, IndexType>> neighbors;

    public ListNode(DataType data, IndexType index) {
        super(data, index);

        neighbors = new ArrayList<>();
    }

    public void addNeighbor(ListNode<DataType, IndexType> node) {
        neighbors.add(new Edge<>(this, node, null));
    }

    public void addNeighbor(ListNode<DataType, IndexType> node, double weight) {
        neighbors.add(new Edge<>(this, node, weight));
    }

    public void addNeighbors(List<ListNode<DataType, IndexType>> nodes) {
        for (var node : nodes)
            neighbors.add(new Edge<>(this, node, null));
    }

    public void removeNeighbor(Node<DataType, IndexType> node) {
        for (var neighbor : neighbors) {
            if (neighbor.getDst().equals(node)) {
                neighbors.remove(neighbor);
                return;
            }
        }
    }

    public List<ListNode<DataType, IndexType>> getNeighbors() {
        ArrayList<ListNode<DataType, IndexType>> result = new ArrayList<>();

        for (Edge<DataType, IndexType> edge : neighbors)
            result.add(edge.getDst());

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("ListNode [" + super.toString() + ", neighbors=[");

        if (neighbors.size() == 0)
            return builder.append("]]").toString();

        builder.append(neighbors.get(0).getDst().baseToString());

        for (int i = 1; i < neighbors.size(); i++)
            builder.append(", " + neighbors.get(i).getDst().baseToString());

        return builder.append("]]").toString();
    }

    @Override
    public Iterator<ListNode<DataType, IndexType>> iterator() {
        return new Iterator<ListNode<DataType,IndexType>>() {
            private int crt = 0;

            @Override
            public boolean hasNext() {
                return crt < neighbors.size();
            }

            @Override
            public ListNode<DataType, IndexType> next() {
                return neighbors.get(crt++).getDst();
            }
        };
    }
}
