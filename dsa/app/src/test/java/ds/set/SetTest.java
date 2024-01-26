package ds.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ds.list.ListTest;

import org.junit.jupiter.api.Test;

public abstract class SetTest extends ListTest {
    @Test
    public void testAdd() {
        fill();
        assertEquals(10, ds.size());

        for (int i = 0; i < 10; i++)
            assertEquals(i + 1, ds.get(i));
    }

    @Test
    public void testAddIndex() {
        int values[] = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10 };

        fill();
        ds.add(4, 5);

        assertEquals(values.length, ds.size());
        assertEquals(5, ds.get(4));

        for (int i = 0; i < values.length; i++)
            assertEquals(values[i], ds.get(i));
    }

    @Test
    public void testAddLastIndex() {
        fill();
        ds.add(ds.size(), 100);

        assertEquals(initializer.size() + 1, ds.size());
        assertEquals(100, ds.get(ds.size() - 1));
    }

    @Test
    public void testAddZeroIndex() {
        Integer value = -5;

        fill();
        ds.add(0, value);

        assertEquals(value, ds.get(0));
    }

    @Test
    public void testAddAll() {
        int values[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ds.addAll(List.of(1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10));

        for (int i = 0; i < values.length; i++)
            assertEquals(values[i], ds.get(i));

        assertEquals(values.length, ds.size());
    }

    @Test
    public void testAddAllOffset() {
        List<Integer> inserted = Arrays.asList(1, 2, 3, 4);
        int i = 0;

        fill();
        ds.addAll(ds.size(), inserted);

        for (Integer value : Stream.concat(initializer.stream(), inserted.stream()).collect(Collectors.toList()))
            assertEquals(value, ds.get(i++));

        ds = getDS();
        fill();

        ds.addAll(0, inserted);
        i = 0;

        for (Integer value : Stream.concat(inserted.stream(), initializer.stream()).collect(Collectors.toList()))
            assertEquals(value, ds.get(i++));
    }

    @Test
    public void testClear() {
        fill();
        ds.clear();

        assertEquals(0, ds.size());
    }

    @Test
    public void testContains() {
        fill();

        for (var value : initializer)
            assertEquals(true, ds.contains(value));
    }

    @Test
    public void testContainsAll() {
        fill();

        assertEquals(true, ds.containsAll(initializer));
    }

    @Test
    public void testGet() {
        fill();

        for (int i = 0; i < ds.size(); i++)
            assertEquals(initializer.get(i), ds.get(i));
    }

    @Test
    public void testIndexOf() {
    }

    @Test
    public void testIsEmpty() {
    }

    @Test
    public void testLastIndexOf() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testRemoveAll() {
    }

    @Test
    public void testRetainAll() {
    }

    @Test
    public void testSet() {
    }

    @Test
    public void testSize() {
    }

    @Test
    public void testToArray() {
    }
}
