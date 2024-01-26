package ds.stack;

public class ListStackTest extends StackTest {
    @Override
    public Stack<Integer> getDS() {
        return new ListStack<>();
    }
}
