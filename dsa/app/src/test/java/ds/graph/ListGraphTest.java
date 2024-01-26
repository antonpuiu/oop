package ds.graph;

import org.junit.jupiter.api.Test;

import ds.DSTest;
import ds.graph.list.ListGraph;
import ds.graph.list.ListNode;
import ds.graph.node.visitor.NodeVisitor;
import ds.graph.node.visitor.bfs.BFSPrintVisitor;
import ds.graph.node.visitor.dfs.DFSPrintVisitor;

public class ListGraphTest extends DSTest<ListGraph<ListNode<Integer, Integer>, Integer, Integer>> {
    @Override
    public ListGraph<ListNode<Integer, Integer>, Integer, Integer> getDS() {
        return new ListGraph<>();
    }

    @Test
    public void testBFS() {
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

        NodeVisitor<ListNode<Integer, Integer>, Integer, Integer> bfs = new BFSPrintVisitor<>();

        for (var node : ds)
            ds.accept(bfs, node.getIndex());
    }

    @Test
    public void testDFS() {
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

        NodeVisitor<ListNode<Integer, Integer>, Integer, Integer> dfs = new DFSPrintVisitor<>();

        for (var node : ds)
            ds.accept(dfs, node.getIndex());
    }
}
