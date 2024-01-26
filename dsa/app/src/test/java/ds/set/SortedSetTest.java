package ds.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class SortedSetTest extends SetTest {
    @Override
    public Set<Integer> getDS() {
        return new SortedSet<Integer>(new Comparator<Integer>() {
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
    public void testAddReversed() {
        for (int i = 10; i >= 1; i--)
            ds.add(i);

        for (int i = 1; i <= 10; i++)
            assertEquals(i, ds.get(i - 1));
    }

    @Test
    @Override
    public void testAddAllOffset() {
        List<Integer> inserted = Arrays.asList(1, 2, 3, 4);
        int i = 0;

        fill();
        ds.addAll(ds.size(), inserted);

        for (Integer value : Stream.concat(initializer.stream(), inserted.stream()).sorted().collect(Collectors.toList()))
            assertEquals(value, ds.get(i++));

        ds = getDS();
        fill();

        ds.addAll(0, inserted);
        i = 0;

        for (Integer value : Stream.concat(inserted.stream(), initializer.stream()).sorted().collect(Collectors.toList()))
            assertEquals(value, ds.get(i++));
    }
}
