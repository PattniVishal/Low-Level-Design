package com.cache.cache;

import com.cache.evictionPolicy.EvictionPolicy;
import com.cache.exception.storage.KeyNotFoundException;
import com.cache.exception.storage.StorageFullException;
import com.cache.storage.Storage;

public class Cache<Key, Value> {
    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key k, Value v) {
        try{
            storage.put(k, v);
            evictionPolicy.latestKeyAccessed(k);
        }
        catch(StorageFullException e){
            System.out.println("EXCEPTION : " + e.getMessage());
            Key evictedKey = evictionPolicy.evictKey(k);
            this.storage.remove(evictedKey);
            put(k, v);
        }
    }

    public Value get(Key k){
        try{
            Value value = storage.get(k);
            evictionPolicy.latestKeyAccessed(k);
            return value;
        }
        catch(KeyNotFoundException e){
            System.out.println("EXCEPTION : " + e.getMessage());
            return null;
        }
    }
}
