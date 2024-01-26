package ds.graph.list;

import java.util.Iterator;

import ds.graph.node.Node;
import ds.graph.node.visitor.NodeVisitor;
import ds.list.List;
import ds.list.custom.ArrayList;

public class ListNode<DataType, IndexType>
    extends Node<DataType, IndexType>
    implements Iterable<ListNode<DataType, IndexType>.Edge> {
    private ArrayList<Edge> neighbors;

    public ListNode(DataType data, IndexType index) {
        super(data, index);

        neighbors = new ArrayList<>();
    }

    public void addNeighbor(ListNode<DataType, IndexType> node) {
        neighbors.add(new Edge(this, node, null));
    }

    public void addNeighbors(List<ListNode<DataType, IndexType>> nodes) {
        for (var node : nodes)
            neighbors.add(new Edge(this, node, null));
    }

    public void addNeighbor(ListNode<DataType, IndexType> node, double weight) {
        neighbors.add(new Edge(this, node, weight));
    }

    public void removeNeighbor(Node<DataType, IndexType> node) {
        for (var neighbor : neighbors) {
            if (neighbor.getDst().equals(node)) {
                neighbors.remove(neighbor);
                break;
            }
        }
    }

    @Override
    public void accept(NodeVisitor<DataType, IndexType> visitor) {
        visitor.visit(this);
    }

    @Override
    public Iterator<Edge> iterator() {
        return neighbors.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{" + data.toString() + "|" + index.toString() + "}" + "[");
        builder.append("(" +
                           neighbors.get(0).getDst().data.toString() +
                           ", " +
                           neighbors.get(0).getDst().index.toString() +
                           ")");

        for (int i = 1; i < neighbors.size(); i++)
            builder.append(", (" +
                           neighbors.get(i).getDst().data.toString() +
                           ", " +
                           neighbors.get(i).getDst().index.toString() +
                           ")");

        return builder.append("]").toString();
    }

    public class Edge {
        private ListNode<DataType, IndexType> src;
        private ListNode<DataType, IndexType> dst;
        private Double weight;

        public Edge(ListNode<DataType, IndexType> src, ListNode<DataType, IndexType> dst) {
            this.src = src;
            this.dst = dst;
        }

        public Edge(ListNode<DataType, IndexType> src, ListNode<DataType, IndexType> dst, Double weight) {
            this(src, dst);
            this.weight = weight;
        }

        public ListNode<DataType, IndexType> getSrc() {
            return src;
        }

        public ListNode<DataType, IndexType> getDst() {
            return dst;
        }

        public double getWeight() {
            return weight;
        }
    }
}
