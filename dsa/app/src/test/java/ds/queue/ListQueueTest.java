package ds.queue;

public class ListQueueTest extends QueueTest {
    @Override
    public Queue<Integer> getDS() {
        return new ListQueue<>();
    }
}
