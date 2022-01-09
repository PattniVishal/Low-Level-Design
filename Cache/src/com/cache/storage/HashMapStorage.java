package com.cache.storage;

import com.cache.exception.storage.KeyNotFoundException;
import com.cache.exception.storage.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value>{
    private Map<Key, Value> map;
    private int capacity;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    @Override
    public void put(Key k, Value v) throws StorageFullException {
        if(isStorageFull()){
            throw new StorageFullException("Storage is Full");
        }
        map.put(k, v);
    }

    @Override
    public Value get(Key k) throws KeyNotFoundException {
        if(!map.containsKey(k)){
            throw new KeyNotFoundException("Key " + k + " Not Found");
        }
        return map.get(k);
    }

    @Override
    public void remove(Key k) throws KeyNotFoundException {
        if(!map.containsKey(k)){
            throw new KeyNotFoundException("Key " + k + " Not Found");
        }
        map.remove(k);
    }

    private boolean isStorageFull(){
        return map.size() == capacity;
    }
}
