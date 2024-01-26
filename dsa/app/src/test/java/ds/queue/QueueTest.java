package ds.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ds.DSTest;
import ds.list.List;
import ds.list.custom.ArrayList;

public abstract class QueueTest extends DSTest<Queue<Integer>> {
    private List<Integer> initializer;

    public QueueTest() {
        initializer = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
            initializer.add(i);
    }

    private void fill() {
        for (Integer value : initializer)
            ds.enqueue(value);
    }

    @Test
    void testSimple() {
        fill();

        for (int i = 1; i <= 10; i++) {
            assertEquals(i, ds.peek());
            assertEquals(i, ds.dequeue());
        }

        assertEquals(null, ds.dequeue());
    }
}
