package ds.list.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import ds.list.List;
import ds.list.ListTest;

public class FixedListTest extends ListTest {
    @Override
    public List<Integer> getDS() {
        return new FixedList<>(10);
    }

    @Test
    public void testCustom() {
        for (int i = 0; i < 10; i++)
            ds.add(i);

        System.out.println(ds);
        System.out.println(ds.add(1));
    }

    @Test
    public void testAddAll() {
        int values[] = { 1, 2, 3, 4, 5};
        ds.addAll(java.util.List.of(1, 2, 3, 4, 5));

        for (int i = 0; i < values.length; i++)
            assertEquals(values[i], ds.get(i));

        assertEquals(values.length, ds.size());
    }

    @Test
    @Override
    public void testAddLastIndex() {
        fill(4);
        ds.add(ds.size(), 100);

        System.out.println(ds);

        assertEquals(5, ds.size());
        assertEquals(100, ds.get(ds.size() - 1));
    }

    @Test
    @Override
    public void testAddIndex() {
        int values[] = { 1, 2, 3, 4 };

        fill(4);
        ds.add(4, 5);

        assertEquals(values.length + 1 , ds.size());
        assertEquals(5, ds.get(4));

        for (int i = 0; i < values.length; i++)
            assertEquals(values[i], ds.get(i));
    }

    @Test
    @Override
    public void testAddAllOffset() {
        java.util.List<Integer> inserted = Arrays.asList(1, 2, 3, 4);
        int i = 0;

        fill(3);
        ds.addAll(ds.size(), inserted);

        System.out.println(Stream.concat(initializer.subList(0, 3).stream(), inserted.stream()).collect(Collectors.toList()));
        System.out.println(ds);

        for (Integer value : Stream.concat(initializer.subList(0, 3).stream(), inserted.stream()).collect(Collectors.toList()))
            assertEquals(value, ds.get(i++));
    }
}
