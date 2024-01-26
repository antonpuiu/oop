package ds.list.circular;

import ds.list.List;
import ds.list.ListTest;

public class SimpleLinkedListTest extends ListTest {
    @Override
    public List<Integer> getDS() {
        return new SimpleLinkedList<>();
    }
}
