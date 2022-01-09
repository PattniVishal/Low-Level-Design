package com.cache.evictionPolicy;

public interface EvictionPolicy<Key> {
    public void latestKeyAccessed(Key k);
    public Key evictKey(Key k);
}
