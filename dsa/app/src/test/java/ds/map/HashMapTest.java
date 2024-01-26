package ds.map;

public class HashMapTest extends MapTest {
    @Override
    public Map<Integer, Integer> getDS() {
        return new HashMap<>();
    }
}
