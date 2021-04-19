package com.data_structure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * LFU cache to hold only a certain number of elements
 * Delete the least frequently used element when a element is added to the cache
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache<K,V> {
    /**
     * Cache size, fixed upon creation
     */
    private int cacheSize;

    /**
     * Internal map used to store key-value pairs
     * as the core of the cache
     */
    private Map<K,V> internalMap;

    /**
     * Frequency map used to store key-value pairs
     * value is the frequency of the key
     */
    private Map<K,Integer> frequencyMap;

    /**
     * Internal queue used to check key freshness
     * based on least frequented key
     */
    private LinkedList<K> internalQueue;

    /**
     * Create LFUCache with fixed size
     * @param cacheSize maximum elements in LRU cache
     */
    public LFUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.internalMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.internalQueue = new LinkedList<>();
    }

    private void updateFrequencyMapAndInternalQueueForExistingKey(K currentKey) {
        int currentKeyFreq = this.frequencyMap.get(currentKey);
        int currentKeyIndex = this.internalQueue.indexOf(currentKey);
        int nextKeyIndex = currentKeyIndex+1;
        // if there is next Node from currentKeyIndex
        if (nextKeyIndex < this.internalQueue.size()) {
            K nextKey = this.internalQueue.get(nextKeyIndex);
            int nextKeyFreq = this.frequencyMap.get(nextKey);
            // swap currentKey and nextKey in internalQueue if currentKeyFreq+1 > nextKeyFreq
            if (currentKeyFreq+1 >= nextKeyFreq) {
                this.internalQueue.set(currentKeyIndex, nextKey);
                this.internalQueue.set(nextKeyIndex, currentKey);
            }
        }
        this.frequencyMap.put(currentKey, currentKeyFreq+1);
    }

    private void updateFrequencyMapAndInternalQueueForNewKey(K newKey) {
        this.frequencyMap.put(newKey, 1);
        // insert newKey into internalQueue

    }

    /**
     * Get value from given key
     * @param key used to retrieve value
     * @return value corresponding with given key, else null
     */
    public V get(K key) {
        if (!this.internalMap.containsKey(key)) return null;

        this.updateFrequencyMapAndInternalQueueForExistingKey(key);

        // update frequency
        return this.internalMap.get(key);
    }

    /**
     * Put key-value pair into LFU cache
     * @param key key of key-value pair
     * @param value value of key-value pair
     */
    public void put(K key, V value) {
        // check if key already exists
        if (this.frequencyMap.containsKey(key)) {
            this.updateFrequencyMapAndInternalQueueForExistingKey(key);
        } else {
            this.updateFrequencyMapAndInternalQueueForNewKey(key);
        }

        this.internalMap.put(key, value);

        // Remove least frequently used element from cache when overflow
        if (internalQueue.size() > this.cacheSize) {
            K removedKey = this.internalQueue.remove();
            this.internalMap.remove(removedKey);
            this.frequencyMap.remove(removedKey);
        }
    }

    /**
     * Remove key-value pair from LFU cache by given key
     * @param key key of key-value pair to be removed
     * @exception NoSuchElementException throws this if internal map
     *            does not contain such key
     */
    public void remove(K key) {
        if (!this.internalMap.containsKey(key)) throw new NoSuchElementException();
        this.internalQueue.remove(key);
        this.internalMap.remove(key);
        this.frequencyMap.remove(key);
    }

    /**
     * Print content of LRU cache
     */
    public void printContent() {
        System.out.println("internalQueue: "+ this.internalQueue.toString());
        System.out.println("internalMap: " + this.internalMap.toString());
        System.out.println("frequencyMap: " + this.frequencyMap.toString());
    }

}
