package com.multilevelCache;

import com.multilevelCache.cache.Cache;

import java.util.List;

public class MultilevelCache<K, V> {
    private List<Cache<K, V>> cacheLevels;

    public MultilevelCache(List<Cache<K, V>> cacheLevels) {
        this.cacheLevels = cacheLevels;
    }

    public V READ(K key) {
        Integer readTime = 0, writeTime = 0;
        int i = 0;
        V value = null;
        for (; i < cacheLevels.size(); i++) {
            Cache<K, V> cache = cacheLevels.get(i);
            value = cache.get(key);
            readTime += cache.getReadTime();
            if (value != null) {
                break;
            }
        }
        i--;
        for (; i >= 0; i--) {
            Cache<K, V> cache = cacheLevels.get(i);
            cache.put(key, value);
            writeTime += cache.getWriteTime();
        }

        System.out.println("VALUE : " + value + ", readTime: " + readTime + ", writeTime: " + writeTime);
        return value;
    }

    public void WRITE(K key, V value) {
        Integer writeTime = 0;
        for (Cache<K, V> cache: cacheLevels) {
            cache.put(key, value);
            writeTime += cache.getWriteTime();
        }
        System.out.println("writeTime: " + writeTime);
    }
}
