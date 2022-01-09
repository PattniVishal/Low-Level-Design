package com.multilevelCache.cache.evictionPolicy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{
    private Deque<K> deque;
    private Set<K> set;

    public LRUEvictionPolicy() {
        this.deque = new LinkedList<>();
        this.set = new HashSet<>();
    }

    @Override
    public void latestAccessedKey(K k) {
        if(set.contains(k)){
            deque.remove(k);
        }
        deque.addFirst(k);
    }

    @Override
    public void evictKey(K k) {
        deque.removeLast();
    }
}
