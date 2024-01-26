package ds.list.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import ds.list.List;
import ds.list.ListTest;

public class SortedListTest extends ListTest {
    @Override
    public List<Integer> getDS() {
        return new SortedList<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer arg0, Integer arg1) {
                    if (arg0 > arg1)
                        return 1;
                    else if (arg0 < arg1)
                        return -1;

                    return 0;
                }
            });
    }

    @Test
    @Override
    public void testAddAllOffset() {
        java.util.List<Integer> inserted = Arrays.asList(1, 2, 3, 4);
        int i = 0;

        fill();
        ds.addAll(ds.size(), inserted);

        for (Integer value : Stream.concat(initializer.stream(), inserted.stream()).sorted().collect(Collectors.toList()))
            assertEquals(value, ds.get(i++));
    }
}
