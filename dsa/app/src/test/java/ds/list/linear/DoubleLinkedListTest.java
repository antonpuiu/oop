package ds.list.linear;

import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    @Test
    public void testAdd() {
        // fill();
        // assertEquals(10, list.size());

        // for (int i = 0; i < 10; i++)
        //     assertEquals(i + 1, list.get(i));
    }

    @Test
    public void testAddIndex() {
        // int values[] = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10 };

        // fill();
        // list.add(4, 5);

        // assertEquals(values.length, list.size());
        // assertEquals(5, list.get(4));

        // for (int i = 0; i < values.length; i++)
        //     assertEquals(values[i], list.get(i));
    }

    @Test
    public void testAddLastIndex() {
        // fill();
        // list.add(list.size(), 100);

        // assertEquals(initializer.size() + 1, list.size());
        // assertEquals(100, list.get(list.size() - 1));
    }

    @Test
    public void testAddZeroIndex() {
        // Integer value = -5;

        // fill();
        // list.add(0, value);

        // assertEquals(value, list.get(0));
    }

    @Test
    public void testAddAll() {
        // int values[] = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10 };
        // list.addAll(List.of(1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10));

        // for (int i = 0; i < values.length; i++)
        //     assertEquals(values[i], list.get(i));

        // assertEquals(values.length, list.size());
    }

    @Test
    public void testAddAllOffset() {
        // List<Integer> inserted = Arrays.asList(1, 2, 3, 4);
        // int i = 0;

        // fill();
        // list.addAll(list.size(), inserted);

        // for (Integer value : Stream.concat(initializer.stream(), inserted.stream()).collect(Collectors.toList()))
        //     assertEquals(value, list.get(i++));

        // list = new DoubleLinkedList<>();
        // fill();

        // list.addAll(0, inserted);
        // i = 0;

        // for (Integer value : Stream.concat(inserted.stream(), initializer.stream()).collect(Collectors.toList()))
        //     assertEquals(value, list.get(i++));
    }

    @Test
    public void testClear() {
        // fill();
        // list.clear();

        // assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        // fill();

        // for (var value : initializer)
        //     assertEquals(true, list.contains(value));
    }

    @Test
    public void testContainsAll() {
        // fill();

        // assertEquals(true, list.containsAll(initializer));
    }

    @Test
    public void testGet() {
        // fill();

        // for (int i = 0; i < list.size(); i++)
        //     assertEquals(initializer.get(i), list.get(i));
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
