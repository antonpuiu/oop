package lab10.task1;

import java.util.*;

public class MultiMapValue<K, V> {
    private HashMap<K, ArrayList<V>> hashMap = new HashMap<>();

    public void add(K key, V value) {
        if (!hashMap.containsKey(key))
            hashMap.put(key, new ArrayList<V>());

        hashMap.get(key).add(value);
    }

    public void addAll(K key, List<V> values) {
        if (!hashMap.containsKey(key))
            hashMap.put(key, new ArrayList<V>());

        hashMap.get(key).addAll(values);
    }

    public void addAll(MultiMapValue<K, V> map) {
        for (K key : map.hashMap.keySet()) {
            if (!hashMap.containsKey(key))
                hashMap.put(key, new ArrayList<V>());

            hashMap.get(key).addAll(map.hashMap.get(key));
        }
    }

    public V getFirst(K key) {
        if (!hashMap.containsKey(key))
            return null;

        return hashMap.get(key).get(0);
    }

    public List<V> getValues(K key) {
        return hashMap.get(key);
    }

    public boolean containsKey(K key) {
        return hashMap.containsKey(key);
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public List<V> remove(K key) {
        return hashMap.remove(key);
    }

    public int size() {
        return hashMap.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hashMap == null) ? 0 : hashMap.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        MultiMapValue<K, V> other = (MultiMapValue<K, V>) obj;

        if (hashMap == null)
            if (other.hashMap != null)
                return false;
        else if (!hashMap.equals(other.hashMap))
            return false;

        return true;
    }
}
