package ds.list.custom;

import ds.list.List;
import ds.list.ListTest;

public class ArrayListTest extends ListTest {
    @Override
    public List<Integer> getDS() {
        return new ArrayList<>();
    }
}
