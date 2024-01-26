package ds.queue;

import ds.list.node.DoubleNode;

public class ListQueue<T> implements Queue<T> {
    private DoubleNode<T> head, tail;

    public ListQueue() {
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(T value) {
        if (head == null) {
            head = new DoubleNode<>(value, null, null);
            tail = head;

            return;
        }

        DoubleNode<T> newNode = new DoubleNode<>(value, head, null);
        head.prev = newNode;
        head = newNode;
    }

    @Override
    public T dequeue() {
        T data = null;

        if (tail == null)
            return null;

        data = tail.data;
        tail = tail.prev;

        if (tail == null)
            head = null;

        return data;
    }

    @Override
    public T peek() {
        if (tail == null)
            return null;

        return tail.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        if (head == null)
            return builder.append("]").toString();

        builder.append(head.data);

        DoubleNode<T> crt = head.next;

        while (crt != null) {
            builder.append(" " + crt.data);
            crt = crt.next;
        }

        builder.append("]");

        return builder.toString();
    }

    @Override
    public boolean empty() {
        return head == null;
    }
}
