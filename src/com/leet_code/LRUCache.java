package com.leet_code;
import java.util.*;

/**
 * https://leetcode.com/problems/lru-cache/
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
class LRUCache {
    private int cacheSize;
    private Map<Integer, Integer> internalMap;
    private LinkedHashSet<Integer> internalQueue;

    public LRUCache(int capacity) {
        this.cacheSize = capacity;
        this.internalMap = new HashMap<>();
        this.internalQueue = new LinkedHashSet<>();
    }

    public int get(int key) {
        if (!this.internalMap.containsKey(key)) return -1;
        this.internalQueue.remove(key);
        this.internalQueue.add(key);
        return this.internalMap.get(key);
    }

    public void put(int key, int value) {
        if (this.internalQueue.contains(key)) {
            this.internalQueue.remove(key);
        }
        this.internalQueue.add(key);
        this.internalMap.put(key, value);

        if (internalQueue.size() > this.cacheSize) {
            int removedKey = this.internalQueue.iterator().next();
            this.internalQueue.remove(removedKey);
            this.internalMap.remove(removedKey);
        }
    }
}