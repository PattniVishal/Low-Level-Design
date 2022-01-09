package com.multilevelCache.cache.storage;

public interface Storage<K, V> {
    public void add(K k, V v);
    public V get(K k);
    public boolean isFull();
}
