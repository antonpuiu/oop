package ds.set;

import java.util.Iterator;

import ds.list.List;
import ds.list.linear.SimpleLinkedList;

public class ListSet<T> extends Set<T> {
    @Override
    protected List<T> getDS() {
        return new SimpleLinkedList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return ((SimpleLinkedList<T>)values).iterator();
    }
}
