package com.data_structure;

import java.util.*;

/**
 * LRU cache to hold only a certain number of elements
 * Delete the least recently used element when a element is added to the cache
 */
public class LRUCache<K,V> {

    /**
     * Cache size, fixed upon creation
     */
    private int cacheSize;

    /**
     * Internal map used to store key-value pairs
     */
    private Map<K,V> internalMap;

    /**
     * Internal list used to check key freshness
     */
    private LinkedList<K> internalQueue;

    /**
     * Create LRUCache with fixed size
     * @param cacheSize maximum elements in LRU cache
     */
    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.internalMap = new HashMap<>();
        this.internalQueue = new LinkedList<>();
    }

    /**
     * Get value from given key
     * @param key used to retrieve value
     * @return value corresponding with given key
     */
    public V get(K key) {
        if (!this.internalMap.containsKey(key)) return null;
        this.internalQueue.remove(key);
        this.internalQueue.add(key);
        return this.internalMap.get(key);
    }

    /**
     * Put key-value pair into LRU cache
     * @param key key of key-value pair
     * @param value value of key-value pair
     */
    public void put(K key, V value) {
        // check if key already exists
        if (this.internalMap.containsKey(key)) {
            this.internalQueue.remove(key);
        }
        this.internalQueue.add(key);
        this.internalMap.put(key, value);

        if (internalQueue.size() > this.cacheSize) {
            K removedKey = this.internalQueue.remove();
            this.internalMap.remove(removedKey);
        }
    }

    /**
     * Remove key-value pair from LRU cache by given key
     * @param key key of key-value pair to be removed
     * @exception NoSuchElementException throws this if internal map
     *            does not contain such key
     */
    public void remove(K key) {
        if (!this.internalMap.containsKey(key)) throw new NoSuchElementException();
        this.internalQueue.remove(key);
        this.internalMap.remove(key);
    }

    /**
     * Remove least recently used element from internal list and internal map
     */
    public void evict() {
        if (this.internalQueue.size() > 0 ) {
            K removedKey = this.internalQueue.remove();
            this.internalMap.remove(removedKey);
        }
    }

    /**
     * Print content of LRU cache
     */
    public void printContent() {
        System.out.println("internalList: "+ this.internalQueue.toString());
        System.out.println("internalMap: " + this.internalMap.toString());
    }
}
