package ds.list.node;

public class SimpleNode<T> {
    public T data;
    public SimpleNode<T> next;

    public SimpleNode() {
        this(null, null);
    }

    public SimpleNode(T data) {
        this(data, null);
    }

    public SimpleNode(T data, SimpleNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
