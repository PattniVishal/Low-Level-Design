package com.multilevelCache.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K, V> implements Storage<K, V>{
    Map<K, V> map;
    Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    @Override
    public void add(K k, V v) {
        map.put(k, v);
    }

    @Override
    public V get(K k) {
        return map.get(k);
    }

    @Override
    public boolean isFull() {
        return map.size() == capacity;
    }
}
