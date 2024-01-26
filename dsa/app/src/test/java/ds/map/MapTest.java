package ds.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ds.DSTest;
import ds.set.Set;

public abstract class MapTest extends DSTest<ds.map.Map<Integer, Integer>> {
    private ArrayList<Integer> keys, values;

    public MapTest() {
        keys = new ArrayList<>();
        values = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            keys.add(i);
            values.add(10 * i);
        }
    }

    private void fill() {
        for (int i = 0; i < keys.size(); i++)
            ds.put(keys.get(i), values.get(i));
    }

    @Test
    public void testClear() {
        fill();
        ds.clear();
        assertEquals(0, ds.size());
    }

    @Test
    public void testContainsKey() {
        fill();

        for (Integer key : keys)
            assertEquals(true, ds.containsKey(key));
    }

    @Test
    public void testContainsValue() {
        fill();

        for (Integer value : values)
            assertEquals(true, ds.containsValue(value));
    }

    @Test
    public void testPut() {
    }

    @Test
    public void testPutAll() {
        HashMap<Integer, Integer> newMap = new HashMap<>();

        for (int i = 0; i < keys.size(); i++)
            newMap.put(keys.get(i), values.get(i));

        ds.putAll(newMap);

        for (Integer key : newMap.keySet())
            assertEquals(ds.get(key), newMap.get(key));
    }

    @Test
    public void testRemove() {
        fill();

        for (int i = 0; i < 10; i++)
            ds.remove(keys.get(i));

        assertEquals(keys.size() - 10, ds.size());

        for (int i = 10; i < keys.size(); i++)
            assertEquals(values.get(i), ds.get(keys.get(i)));
    }

    @Test
    public void testReplace() {
        fill();

        for (int i = 0; i < keys.size(); i++)
            ds.replace(keys.get(i), values.get(i) * 10);

        for (int i = 0; i < keys.size(); i++)
            assertEquals(values.get(i) * 10, ds.get(keys.get(i)));
    }

    @Test
    public void testGet() {
        fill();

        for (int i = 0; i < keys.size(); i++)
            assertEquals(values.get(i), ds.get(keys.get(i)));
    }

    @Test
    public void testSize() {
        fill();

        assertEquals(keys.size(), ds.size());
    }

    @Test
    public void testIsEmpty() {
        fill();

        assertEquals(false, ds.isEmpty());

        ds.clear();

        assertEquals(true, ds.isEmpty());
    }

    @Test
    public void testKeySet() {
        fill();

        Set<Integer> keySet = ds.keySet();

        assertEquals(keys.size(), keySet.size());

        for (Integer key : ds.keySet())
            assertTrue(keys.contains(key));
    }
}
