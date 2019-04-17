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
    private LinkedList<K> internalList;

    /**
     * Create LRUCache with fixed size
     * @param cacheSize maximum elements in LRU cache
     */
    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.internalMap = new HashMap<>();
        this.internalList = new LinkedList<>();
    }

    /**
     * Get value from given key
     * @param key used to retrieve value
     * @return value corresponding with given key
     */
    public V get(K key) {
        if (!this.internalMap.containsKey(key)) return null;
        this.internalList.remove(key);
        this.internalList.addFirst(key);
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
            this.internalList.remove(key);
        }
        this.internalList.addFirst(key);
        this.internalMap.put(key, value);

        if (internalList.size() > this.cacheSize) {
            K removedKey = this.internalList.removeLast();
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
        this.internalList.remove(key);
        this.internalMap.remove(key);
    }

    /**
     * Remove least recently used element from internal list and internal map
     */
    public void evict() {
        if (this.internalList.size() > 0 ) {
            K removedKey = this.internalList.removeLast();
            this.internalMap.remove(removedKey);
        }
    }

    /**
     * Print content of LRU cache
     */
    public void printContent() {
        System.out.println("internalList: "+ this.internalList.toString());
        System.out.println("internalMap: " + this.internalMap.toString());
    }
}
