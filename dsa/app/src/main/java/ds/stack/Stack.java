package ds.stack;

public interface Stack<T> {
    public boolean empty();

    public T peek();

    public T pop();

    public void push(T value);
}
