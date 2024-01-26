package ds.set;

public class ListSetTest extends SetTest {
    @Override
    public Set<Integer> getDS() {
        return new ListSet<>();
    }
}
