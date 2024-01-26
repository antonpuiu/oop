package ds.graph;

import org.junit.jupiter.api.Test;

import ds.DSTest;
import ds.graph.list.ListGraph;
import ds.graph.list.ListNode;
import ds.graph.node.visitor.BFSPrintVisitor;
import ds.graph.node.visitor.NodeVisitor;

public class ListGraphTest extends DSTest<ListGraph<Integer, Integer, Integer>> {
    @Override
    public ListGraph<Integer, Integer, Integer> getDS() {
        return new ListGraph<>();
    }

    @Test
    public void testSimple() {
        ListNode<Integer, Integer> node0 = new ListNode<>(10, 0);
        ListNode<Integer, Integer> node1 = new ListNode<>(15, 1);
        ListNode<Integer, Integer> node2 = new ListNode<>(20, 2);
        ListNode<Integer, Integer> node3 = new ListNode<>(25, 3);
        ListNode<Integer, Integer> node4 = new ListNode<>(30, 4);

        ds.addNode(node0);
        ds.addNode(node1);
        ds.addNode(node2);
        ds.addNode(node3);
        ds.addNode(node4);

        node0.addNeighbor(node1);
        node0.addNeighbor(node2);

        node1.addNeighbor(node2);
        node1.addNeighbor(node3);
        node1.addNeighbor(node4);

        node2.addNeighbor(node0);
        node2.addNeighbor(node3);

        node3.addNeighbor(node1);
        node3.addNeighbor(node4);

        node4.addNeighbor(node1);

        NodeVisitor<Integer, Integer> bfs = new BFSPrintVisitor<Integer, Integer>();
        // NodeVisitor dfs = new DFSVisitor();

        node0.accept(bfs);

        // for (var node : ds)
        //     node.accept(bfs);
    }
}
