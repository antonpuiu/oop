package ds.stack;

import ds.list.node.SimpleNode;

public class ListStack<T> implements Stack<T> {
    SimpleNode<T> head;

    public ListStack() {
        head = null;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public T peek() {
        return head == null ? null : head.data;
    }

    @Override
    public T pop() {
        T data = null;

        if (head == null)
            return null;

        data = head.data;
        head = head.next;

        return data;
    }

    @Override
    public void push(T value) {
        if (head == null) {
            head = new SimpleNode<>(value);

            return;
        }

        head = new SimpleNode<>(value, head);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("[");

        if (head == null)
            return builder.append("]").toString();

        builder.append(head.data);
        SimpleNode<T> crt = head.next;

        while (crt != null) {
            builder.append(" " + crt.data);
            crt = crt.next;
        }

        builder.append("]");
        return null;
    }
}
