package ds.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ds.DSTest;
import ds.list.List;
import ds.list.custom.ArrayList;

public abstract class StackTest extends DSTest<Stack<Integer>> {
    private List<Integer> initializer;

    public StackTest() {
        initializer = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
            initializer.add(i);
    }

    private void fill() {
        for (Integer value : initializer)
            ds.push(value);
    }

    @Test
    void testSimple() {
        assertTrue(ds.empty());

        fill();

        for (int i = 10; i >= 1; i--) {
            assertEquals(i, ds.peek());
            assertEquals(i, ds.pop());
        }

        assertEquals(null, ds.pop());
    }

    @Test
    public void testPushAndPeek() {
        Stack<String> stack = new ListStack<>();
        stack.push("Hello");
        assertFalse(stack.empty());
        assertEquals("Hello", stack.peek());
    }

    @Test
    public void testPushAndPop() {
        Stack<Double> stack = new ListStack<>();
        stack.push(3.14);
        assertFalse(stack.empty());
        assertEquals(3.14, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    public void testMultiplePushAndPop() {
        Stack<Integer> stack = new ListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.empty());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    public void testPeekOnEmptyStack() {
        Stack<String> stack = new ListStack<>();
        assertNull(stack.peek());
    }

    @Test
    public void testPopOnEmptyStack() {
        Stack<Integer> stack = new ListStack<>();
        assertNull(stack.pop());
    }

    @Test
    public void testPushPopPeekMixedOperations() {
        Stack<Integer> stack = new ListStack<>();

        assertTrue(stack.empty());

        stack.push(1);
        stack.push(2);
        assertFalse(stack.empty());
        assertEquals(2, stack.peek());

        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());

        stack.push(4);
        assertEquals(4, stack.pop());
        assertFalse(stack.empty());

        stack.push(5);
        assertEquals(5, stack.pop());
        assertEquals(1, stack.pop());

        assertTrue(stack.empty());
        assertNull(stack.peek());
        assertNull(stack.pop());
    }

    @Test
    public void testMixedDataTypes() {
        Stack<Object> stack = new ListStack<>();

        assertTrue(stack.empty());

        stack.push("Hello");
        stack.push(42);
        stack.push(3.14);

        assertFalse(stack.empty());

        assertEquals(3.14, stack.pop());
        assertEquals(42, stack.pop());
        assertEquals("Hello", stack.pop());

        assertTrue(stack.empty());
    }

    @Test
    public void testLargeNumberOfOperations() {
        Stack<Integer> stack = new ListStack<>();

        assertTrue(stack.empty());

        // Push 1000 elements
        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }

        assertFalse(stack.empty());
        assertEquals(999, stack.peek());

        // Pop 500 elements
        for (int i = 0; i < 500; i++) {
            assertEquals(999 - i, stack.pop());
        }

        assertFalse(stack.empty());
        assertEquals(499, stack.peek());

        // Push 500 more elements
        for (int i = 1000; i < 1500; i++) {
            stack.push(i);
        }

        assertFalse(stack.empty());
        assertEquals(1499, stack.peek());

        // Pop all remaining elements
        for (int i = 0; i < 500; i++) {
            assertEquals(1499 - i, stack.pop());
        }

        for (int i = 0; i < 500; i++)
            assertEquals(499 - i, stack.pop());

        assertTrue(stack.empty());
        assertNull(stack.peek());
        assertNull(stack.pop());
    }
}
