package com.multilevelCache.cache.evictionPolicy;

public interface EvictionPolicy<K> {
    public void latestAccessedKey(K k);
    public void evictKey(K k);
}
