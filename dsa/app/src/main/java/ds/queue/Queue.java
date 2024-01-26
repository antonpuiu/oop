package ds.queue;

public interface Queue<T> {
    public void enqueue(T value);

    public T dequeue();

    public T peek();

    public boolean empty();
}
