package ds.map;

import ds.set.Set;

public interface Map<K, V> {
    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    void put(K key, V value);

    void putAll(Map<K, V> map);

    V remove(K key);

    V replace(K key, V value);

    V get(K key);

    int size();

    boolean isEmpty();

    Set<K> keySet();

    public static interface Entry<K, V> {
        public K getKey();
        public V getValue();
        public V setValue(V value);
    }
}
