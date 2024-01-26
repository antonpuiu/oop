package ds.list.custom;

import java.util.Collection;
import java.util.Iterator;

import ds.list.List;

public class ArrayList<T> implements List<T> {
    private java.util.ArrayList<T> values;

    public ArrayList() {
        values = new java.util.ArrayList<>();
    }

    @Override
    public boolean add(int index, T value) {
        values.add(index, value);

        return true;
    }

    @Override
    public boolean add(T value) {
        return values.add(value);
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        return this.values.addAll(values);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        return this.values.addAll(index, values);
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
