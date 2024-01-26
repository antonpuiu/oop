package ds.list;

import java.util.Collection;

import ds.DSType;

public interface List<T> extends DSType<T>, Iterable<T> {
    boolean add(T value);

    boolean add(int index, T value);

    boolean addAll(Collection<? extends T> values);

    boolean addAll(int index, Collection<? extends T> values);

    boolean contains(Object value);

    boolean containsAll(Collection<T> values);

    boolean remove(Object value);

    T remove(int index);

    boolean removeAll(Collection<T> values);

    boolean retainAll(Collection<T> values);

    int indexOf(Object value);

    int lastIndexOf(Object value);

    int size();

    void clear();

    T get(int index);

    T set(int index, T value);

    boolean isEmpty();

    Object[] toArray();
}
