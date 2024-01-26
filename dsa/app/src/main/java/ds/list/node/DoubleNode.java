package ds.list.node;

public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> next, prev;

    public DoubleNode() {
        this(null, null, null);
    }

    public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
