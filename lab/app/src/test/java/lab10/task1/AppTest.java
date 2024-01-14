package lab10.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {
    private MultiMapValue<String, String> map;

    @BeforeEach
    public void setup() {
        map = new MultiMapValue<>();
    }

    @AfterEach
    public void clean() {
        map = null;
    }

    @Test
    public void testAddElementWithOneValue() {
        map.add("key", "value");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(1, map.getValues("key").size());
    }

    @Test
    public void testAddElementWithMoreValues() {
        map.add("key", "value1");
        map.add("key", "value2");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(2, map.getValues("key").size());
    }

    @Test
    public void testAddTwoElements() {
        map.add("key1", "value");
        map.add("key2", "value");

        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals("value", map.getFirst("key1"));
        Assertions.assertEquals("value", map.getFirst("key2"));
    }

    @Test
    public void testGetFirst() {
        map.add("key", "value1");
        map.add("key", "value2");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals("value1", map.getFirst("key"));
    }

    @Test
    public void testContainsKey() {
        for (int i = 1; i <= 10; i++)
            map.add("key " + i, "value " + i);

        for (int i = 1; i <= 10; i++)
            Assertions.assertEquals(true, map.containsKey("key " + i));
    }

    @Test
    public void testSize() {
        for (int i = 1; i <= 10; i++)
            map.add("key " + i, "value " + i);

        Assertions.assertEquals(10, map.size());
    }

    @Test
    public void testRemoveKey() {
        for (int i = 1; i <= 10; i++)
            map.add("key " + i, "value " + i);

        map.remove("key 5");

        Assertions.assertEquals(false, map.containsKey("key 5"));
    }

    @Test
    public void testAddAllWithList() {
        ArrayList<String> values = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
            values.add("value " + i);

        map.addAll("key", values);
        Assertions.assertEquals(true, values.equals(map.getValues("key")));
    }

    @Test
    public void testAddAllWithMultiMapValue() {
        MultiMapValue<String, String> multiMap = new MultiMapValue<>();
        ArrayList<String> values = new ArrayList<>();

        for (int i = 1; i <= 10; i++)
            values.add("value " + i);

        multiMap.addAll("key", values);
        map.addAll(multiMap);

        Assertions.assertEquals(true, map.equals(multiMap));
    }
}
