package ds.set;

import java.util.Comparator;
import java.util.Iterator;

import ds.list.List;
import ds.list.custom.SortedList;

public class SortedSet<T> extends Set<T> {
    private SortedList<T> list;

    public SortedSet(Comparator<T> comparator) {
        list = new SortedList<>(comparator);
        values = list;
    }

    public void setComparator(Comparator<T> comparator) {
        ((SortedList<T>)values).setComparator(comparator);
    }

    @Override
    protected List<T> getDS() {
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return ((SortedList<T>)values).iterator();
    }
}
