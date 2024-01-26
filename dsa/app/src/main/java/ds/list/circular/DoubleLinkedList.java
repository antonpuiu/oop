package ds.list.circular;

import java.util.Collection;
import java.util.Iterator;

import ds.list.List;

public class DoubleLinkedList<T> implements List<T> {
    @Override
    public boolean add(T value) {
        return false;
    }

    @Override
    public boolean add(int index, T value) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<T> values) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<T> values) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<T> values) {
        return false;
    }

    @Override
    public T set(int index, T value) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
