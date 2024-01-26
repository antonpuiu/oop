package ds.list.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ds.list.List;

public class FixedList<T> implements List<T> {
    private java.util.List<T> values;
    private int length;

    public FixedList() {
        this(10);
    }

    public FixedList(int size) {
        values = new ArrayList<>();

        for (int i = 0; i < size; i++)
            values.add(null);

        length = 0;
    }

    public int capacity() {
        return values.size();
    }

    @Override
    public boolean add(T value) {
        if (length >= values.size())
            return false;

        values.set(length++, value);

        return true;
    }

    @Override
    public boolean add(int index, T value) {
        if (index >= values.size() || index < 0)
            throw new IndexOutOfBoundsException("[FixedList]::add");

        values.set(index, value);
        length++;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        for (T value : values) {
            if (length >= this.values.size())
                break;

            this.values.set(length++, value);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        for (T value : values) {
            if (index >= this.values.size())
                break;

            this.values.set(index++, value);
        }

        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < values.size(); i++)
            values.set(i, null);

        length = 0;
    }

    @Override
    public boolean contains(Object value) {
        return values.contains(value);
    }

    @Override
    public boolean containsAll(Collection<T> values) {
        return values.containsAll(values);
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
        return length == 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return values.lastIndexOf(value);
    }

    @Override
    public boolean remove(Object value) {
        values.set(values.indexOf(value), null);
        length--;

        return true;
    }

    @Override
    public T remove(int index) {
        T result = values.get(index);

        values.set(index, null);
        length--;

        return result;
    }

    @Override
    public boolean removeAll(Collection<T> values) {
        for (T value : values)
            while (this.values.contains(value)) {
                this.values.set(this.values.indexOf(value), null);
                length--;
            }

        return true;
    }

    @Override
    public boolean retainAll(Collection<T> values) {
        for (T value : this.values)
            if (!values.contains(value))
                while (this.values.contains(value)) {
                    this.values.set(this.values.indexOf(value), null);
                    length--;
                }

        return true;
    }

    @Override
    public T set(int index, T value) {
        return values.set(index, value);
    }

    @Override
    public int size() {
        return length;
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
