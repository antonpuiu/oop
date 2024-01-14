package lab10.task2;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class TreeImpl<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root = null;
    private int size = 0;

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            node = new Node<T>(value, null, null);
            return node;
        }

        if (value.compareTo(node.getValue()) < 0)
            node.setLeft(insert(node.getLeft(), value));
        else if (value.compareTo(node.getValue()) > 0)
            node.setRight(insert(node.getRight(), value));

        return node;
    }

    @Override
    public void addValue(T value) {
        if (root == null) {
            root = new Node<T>(value, null, null);
            size++;
            return;
        }

        insert(root, value);
        size++;
    }

    @Override
    public void addAll(List<T> values) {
        for (T value : values)
            insert(root, value);

        size += values.size();
    }

    @Override
    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> result = new HashSet<>();
        PriorityQueue<Node<T>> queue = new PriorityQueue<>();

        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> crt = queue.poll();

            if (crt.getValue().compareTo(inf) >= 0 && crt.getValue().compareTo(sup) <= 0)
                result.add(crt.getValue());

            if (crt.getLeft() != null)
                queue.add(crt.getLeft());

            if (crt.getRight() != null)
                queue.add(crt.getRight());
        }

        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "TreeImpl [root=" + root + ", size=" + size + "]";
    }
}
