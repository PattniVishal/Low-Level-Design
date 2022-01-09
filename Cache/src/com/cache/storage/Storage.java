package com.cache.storage;

import com.cache.exception.storage.KeyNotFoundException;
import com.cache.exception.storage.StorageFullException;

public interface Storage<Key, Value> {
    public void put(Key k, Value v) throws StorageFullException;
    public Value get(Key k) throws KeyNotFoundException;
    public void remove(Key k) throws KeyNotFoundException;
}
