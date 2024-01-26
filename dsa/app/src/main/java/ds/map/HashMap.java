package ds.map;

import ds.list.custom.FixedList;
import ds.list.linear.SimpleLinkedList;
import ds.set.ListSet;
import ds.set.Set;
import ds.set.VectorSet;

public class HashMap<K, V> implements Map<K, V> {
    private ListSet<K> keys;
    private FixedList<SimpleLinkedList<HashMapEntry>> values;

    public HashMap() {
        keys = new ListSet<>();
        values = new FixedList<>(4096);

        for (int i = 0; i < 4096; i++)
            values.add(new SimpleLinkedList<>());
    }

    private int hashFunction(K key) {
        return key.hashCode() & (values.capacity() - 1);
    }

    @Override
    public void clear() {
        values.clear();
        keys.clear();
    }

    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(V value) {
        for (K key : keys)
            for (HashMapEntry entry : values.get(hashFunction(key)))
                if (entry.value.equals(value))
                    return true;

        return false;
    }

    @Override
    public V get(K key) {
        if (!keys.contains(key))
            return null;

        for (HashMapEntry entry : values.get(hashFunction(key)))
            if (entry.key.equals(key))
                return entry.value;

        return null;
    }

    @Override
    public boolean isEmpty() {
        return keys.size() == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new VectorSet<>();

        for (K key : keys)
            result.add(key);

        return result;
    }

    @Override
    public void put(K key, V value) {
        if (!keys.contains(key))
            keys.add(key);

        SimpleLinkedList<HashMapEntry> buckets = values.get(hashFunction(key));
        boolean existing = false;

        for (HashMapEntry entry : buckets) {
            if (entry.key.equals(key)) {
                existing = true;
                entry.value = value;
                break;
            }
        }

        if (!existing)
            buckets.add(new HashMapEntry(key, value));
    }

    @Override
    public void putAll(Map<K, V> map) {
        for (K key : map.keySet()) {
            put(key, map.get(key));
        }
    }

    @Override
    public V remove(K key) {
        SimpleLinkedList<HashMapEntry> buckets = values.get(hashFunction(key));
        V oldValue = null;

        if (!keys.contains(key))
            return null;

        for (HashMapEntry entry : buckets) {
            if (entry.key.equals(key)) {
                oldValue = entry.value;
                buckets.remove(entry);

                break;
            }
        }

        keys.remove(key);

        return oldValue;
    }

    @Override
    public V replace(K key, V value) {
        SimpleLinkedList<HashMapEntry> buckets = values.get(hashFunction(key));
        V oldValue = null;

        if (!keys.contains(key))
            return null;

        for (HashMapEntry entry : buckets) {
            if (entry.key.equals(key)) {
                oldValue = entry.value;
                entry.value = value;

                break;
            }
        }

        return oldValue;
    }

    @Override
    public int size() {
        return keys.size();
    }

    private class HashMapEntry implements Entry<K, V> {
        private K key;
        private V value;

        public HashMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;

            this.value = value;

            return oldValue;
        }
    }
}
