package com.cache.evictionPolicy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private Deque<Key> deque;
    private Set<Key> hashSet;

    public LRUCacheEvictionPolicy(Deque<Key> deque, HashSet<Key> hashSet) {
        this.deque = new LinkedList<>();
        this.hashSet = new HashSet<>();
    }

    @Override
    public void latestKeyAccessed(Key k) {
        if(hashSet.contains(k)){
            deque.remove(k);
        }
        deque.addFirst(k);
    }

    @Override
    public Key evictKey(Key k) {
        return deque.removeLast();
    }
}
