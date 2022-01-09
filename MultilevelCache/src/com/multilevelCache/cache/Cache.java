package com.multilevelCache.cache;

import com.multilevelCache.cache.evictionPolicy.EvictionPolicy;
import com.multilevelCache.cache.storage.Storage;

public class Cache<K, V> {
    private Storage<K, V> storage;
    private EvictionPolicy<K> evictionPolicy;
    private Integer capacity;
    private Integer readTime;
    private Integer writeTime;

    public Cache(Storage<K, V> storage, EvictionPolicy<K> evictionPolicy, Integer capacity, Integer readTime, Integer writeTime) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
        this.capacity = capacity;
        this.readTime = readTime;
        this.writeTime = writeTime;
    }

    public void put(K k, V v){
        if(storage.isFull()){
            evictionPolicy.evictKey(k);
        }
        storage.add(k, v);
        evictionPolicy.latestAccessedKey(k);
    }

    public V get(K k){
        V value = storage.get(k);
        evictionPolicy.latestAccessedKey(k);
        return value;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public Integer getWriteTime() {
        return writeTime;
    }
}
