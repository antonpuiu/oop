package ds.set;

import java.util.Collection;

import ds.list.List;

public abstract class Set<T> implements List<T> {
    protected List<T> values;

    public Set() {
        values = getDS();
    }

    protected abstract List<T> getDS();

    @Override
    public boolean add(T value) {
        if (values.contains(value))
            return false;

        return values.add(value);
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        for (T value : values) {
            if (this.values.contains(value))
                continue;

            this.values.add(value);
        }

        return true;
    }

    @Override
    public void clear() {
        values.clear();
    }

    public boolean contains(Object value) {
        return values.contains(value);
    }

    @Override
    public boolean containsAll(Collection<T> values) {
        return this.values.containsAll(values);
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public boolean remove(Object value) {
        return values.remove(value);
    }

    @Override
    public boolean removeAll(Collection<T> values) {
        return values.removeAll(values);
    }

    @Override
    public boolean retainAll(Collection<T> values) {
        return values.retainAll(values);
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
    public boolean add(int index, T value) {
        values.add(index, value);

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        return this.values.addAll(index, values);
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
    public int lastIndexOf(Object value) {
        return values.lastIndexOf(value);
    }

    @Override
    public T remove(int index) {
        return values.remove(index);
    }

    @Override
    public T set(int index, T value) {
        return values.set(index, value);
    }
}
