package com.leet_code.data_structure;
import java.util.*;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key
 * if not already present. When the cache reaches its capacity, it should invalidate and
 * remove the least frequently used key before inserting a new item. For this problem,
 * when there is a tie (i.e., two or more keys with the same frequency), the least recently
 * used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache.
 * The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 * https://leetcode.com/problems/lfu-cache/
 */
class LFUCache {

    HashMap<Integer, Integer> vals;//cache K and V
    HashMap<Integer, Integer> counts;//K and counters
    HashMap<Integer, LinkedHashSet<Integer>> lists;//Counter and item list
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        updateCount(key);
        return vals.get(key);
    }

    private void updateCount(int key) {
        // Get the count from counts map
        int count = counts.get(key);
        // increase the counter
        counts.put(key, count + 1);
        // remove the element from the counter to linkedhashset
        lists.get(count).remove(key);

        // when current min does not have any data, next one would be the min
        if (count == min && lists.get(count).size() == 0) min++;
        if (!lists.containsKey(count + 1)) lists.put(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) return;
        // If key does exist, we are returning from here
        if (vals.containsKey(key)) {
            updateCount(key);
            vals.put(key, value);
            return;
        }
        if (vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
            counts.remove(evit);
        }
        // If the key is new, insert the value and current min should be 1 of course
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }

}
