package ds.list.linear;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ds.list.List;
import ds.list.node.SimpleNode;

public class SimpleLinkedList<T> implements List<T> {
    protected SimpleNode<T> head;
    protected int size;

    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    protected SimpleNode<T> getLastNode() {
        if (head == null)
            return null;

        return getLastNode(head);
    }

    protected SimpleNode<T> getLastNode(SimpleNode<T> head) {
        SimpleNode<T> crt = head;

        if (head == null)
            throw new NullPointerException("[SimpleNode<T>] Head node is null");

        while (crt.next != null)
            crt = crt.next;

        return crt;
    }

    protected SimpleNode<T> getNthNode(SimpleNode<T> head, int index) {
        SimpleNode<T> crt = head;

        if (head == null)
            throw new NullPointerException("[SimpleNode<T>] Head node is null");

        if (index >= size)
            throw new IndexOutOfBoundsException();

        while (index > 0) {
            crt = crt.next;
            index--;
        }

        return crt;
    }

    @Override
    public boolean add(T value) {
        if (head == null) {
            head = new SimpleNode<T>(value);
            size++;

            return true;
        }

        getLastNode().next = new SimpleNode<T>(value);
        size++;

        return true;
    }

    @Override
    public boolean add(int index, T value) {
        if (index == 0) {
            head = new SimpleNode<>(value, head);
            size++;

            return true;
        }

        SimpleNode<T> crt = getNthNode(head, index - 1);
        SimpleNode<T> oldNext = crt.next;

        crt.next = new SimpleNode<>(value, oldNext);
        size++;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> values) {
        SimpleNode<T> crt = getLastNode();

        for (var value : values) {
            if (crt == null) {
                crt = new SimpleNode<>(value);
                head = crt;
                continue;
            }

            crt.next = new SimpleNode<>(value);
            crt = crt.next;
        }

        size += values.size();

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> values) {
        if (index > size)
            throw new IndexOutOfBoundsException("[SimpleLinkedList<T>::addAll]");
        if (index == 0) {
            if (head == null) {
                addAll(values);

                return true;
            }

            SimpleNode<T> savedHead = head;
            int savedSize = size;

            head = null;
            size = 0;

            addAll(values);
            getLastNode().next = savedHead;
            size += savedSize;

            return true;
        }

        SimpleNode<T> crt = getNthNode(head, index - 1);
        SimpleNode<T> oldNext = crt.next;
        SimpleNode<T> savedHead = head;

        head = null;
        addAll(values);

        crt.next = head;
        getLastNode(head).next = oldNext;

        head = savedHead;

        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object value) {
        SimpleNode<T> crt = head;

        while (crt != null) {
            if (crt.data.equals(value))
                return true;

            crt = crt.next;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<T> values) {
        for (T value : values) {
            SimpleNode<T> crt = head;
            int i = 0;
            boolean found = false;

            while (i < size) {
                if (crt.data == value) {
                    found = true;
                    break;
                }

                i++;
                crt = crt.next;
            }

            if (!found)
                return false;
        }

        return true;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return getNthNode(head, index).data;
    }

    @Override
    public int indexOf(Object value) {
        SimpleNode<T> crt = head;
        int i = 0;

        while (crt != null) {
            if (crt.data.equals(value))
                return i;

            i++;
            crt = crt.next;
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        SimpleNode<T> crt = head;
        int i = 0;
        int result = -1;

        while (crt != null) {
            if (crt.data.equals(value))
                result = i;

            i++;
            crt = crt.next;
        }

        return result;
    }

    @Override
    public boolean remove(Object value) {
        SimpleNode<T> prev, crt;

        prev = null;
        crt = head;

        while (crt != null) {
            if (crt.data.equals(value)) {
                if (prev == null)
                    head = head.next;
                else
                    prev.next = crt.next;

                size--;

                return true;
            }

            prev = crt;
            crt = crt.next;
        }

        return false;
    }

    @Override
    public T remove(int index) {
        SimpleNode<T> prev = getNthNode(head, index - 1);
        SimpleNode<T> crt = getNthNode(prev, index);

        prev.next = crt.next;
        size--;

        return crt.data;
    }

    @Override
    public boolean removeAll(Collection<T> values) {
        boolean result = true;

        for (T value : values)
            result = result && remove(value);

        return result;
    }

    @Override
    public boolean retainAll(Collection<T> values) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        SimpleNode<T> crt = head;
        boolean result = true;
        int i = 0;

        while (crt != null) {
            if (values.contains(crt.data))
                indexes.add(i);

            i++;
            crt = crt.next;
        }

        for (Integer index : indexes)
            result = result && remove(index);

        return result;
    }

    @Override
    public T set(int index, T value) {
        if (index >= size)
            throw new IndexOutOfBoundsException("[SimpleLinkedList<T>]::set");

        SimpleNode<T> crt = head;

        while (index != 0) {
            crt = crt.next;
            index--;
        }

        T oldData = crt.data;
        crt.data = value;

        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        int i = 0;

        SimpleNode<T> crt = head;

        while (crt != null) {
            elements[i++] = crt.data;
            crt = crt.next;
        }

        return elements;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        SimpleNode<T> crt = head;

        builder.append("List [" + size + "]:");

        for (int i = 0; i < size; i++) {
            builder.append(" " + crt.data);
            crt = crt.next;
        }

        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private SimpleNode<T> crt = null;

            @Override
            public T next() {
                return crt.data;
            }

            @Override
            public boolean hasNext() {
                if (crt == null) {
                    crt = head;

                    return crt != null;
                } else {
                    crt = crt.next;

                    return crt != null;
                }
            }
        };
    }
}
