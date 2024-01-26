package ds.list.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import ds.list.List;

public class SortedList<T> implements List<T> {
    private ArrayList<T> values;
    private Comparator<T> comparator;

    public SortedList() {
        this(null);
    }

    public SortedList(Comparator<T> comparator) {
        this.comparator = comparator;

        values = new ArrayList<>();
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean add(T value) {
        for (int i = 0; i < values.size(); i++) {
            if (comparator.compare(value, values.get(i)) < 0) {
                values.add(i, value);
                return true;
            }
        }

        values.add(value);

        return true;
    }

    @Override
    public boolean add(int index, T value) {
        return add(value);
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        for (T value : values)
            add(value);

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        return addAll(values);
    }

    @Override
    public void clear() {
        values.clear();
    }

    @Override
    public boolean contains(Object value) {
        return values.contains(value);
    }

    @Override
    public boolean containsAll(Collection<T> values) {
        return this.values.containsAll(values);
    }

    @Override
    public T get(int index) {
        return values.get(index);
    }

    @Override
    public int indexOf(Object value) {
        return values.indexOf(value);
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public int lastIndexOf(Object value) {
        return values.lastIndexOf(value);
    }

    @Override
    public boolean remove(Object value) {
        return values.remove(value);
    }

    @Override
    public T remove(int index) {
        return values.remove(index);
    }

    @Override
    public boolean removeAll(Collection<T> values) {
        return this.values.removeAll(values);
    }

    @Override
    public boolean retainAll(Collection<T> values) {
        return this.values.retainAll(values);
    }

    @Override
    public T set(int index, T value) {
        return values.set(index, value);
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public Object[] toArray() {
        return values.toArray();
    }

    @Override
    public String toString() {
        return values.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }
}
