package ds.list.circular;

import java.util.Collection;

import ds.list.node.SimpleNode;

public class SimpleLinkedList<T> extends ds.list.linear.SimpleLinkedList<T> {

    @Override
    protected SimpleNode<T> getLastNode(SimpleNode<T> head) {
        SimpleNode<T> crt = head;
        int i = 0;

        if (head == null)
            throw new NullPointerException("[SimpleNode<T>] Head node is null");

        while (i < this.size - 1) {
            crt = crt.next;
            i++;
        }

        return crt;
    }

    @Override
    public boolean add(T value) {
        super.add(value);
        getLastNode().next = head;

        return true;
    }

    @Override
    public boolean add(int index, T value) {
        super.add(index, value);

        if (index == size - 1)
            getLastNode().next = head;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        super.addAll(values);
        getLastNode().next = head;

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("[SimpleLinkedList]::addAll");

        if (index == size)
            return addAll(values);

        super.addAll(index, values);
        getLastNode().next = head;

        return true;
    }
}
