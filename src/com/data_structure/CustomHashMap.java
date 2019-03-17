package com.data_structure;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple implementation of Hash Map
 * @param <K> Generic type for key
 * @param <V> Generic type for value
 */
public class CustomHashMap<K,V> {

    /**
     * Internal static class which represents a pair of key and value
     * @param <K> Generic Type for key
     * @param <V> Generic Type for value
     */
    public static class CustomEntry<K,V> {
        private K key;
        private V value;

        public CustomEntry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {return this.key;}

        public V getValue() {return this.value;}

        @Override
        public String toString() {
            return String.format("Key is %s, value is %s", key, value);
        }
    }

    // initial capacity of the bucket
    private int initialCapacity = 16;
    // array threshold beyond which we need to resize the bucket
    private float loadFactor = 0.75f;
    // bucket where we store the information
    private List<CustomEntry<K,V>>[] bucket;

    /**
     * Normal constructor where we create a map with default initial capacity
     */
    public CustomHashMap(){
        this.bucket = new LinkedList[this.initialCapacity];
    }

    /**
     * Get the value from a given key
     * @param key key whose value needs to be retrieved
     * @return value paired up with the key
     */
    public V get(K key){
        int indexBucket = this.getBucketIndex(key);

        if (bucket[indexBucket] != null) {
            for (CustomEntry<K,V> customEntry: bucket[indexBucket]) {
                if(customEntry.getKey().equals(key)) {
                    return customEntry.getValue();
                }
            }

        }
        return null;
    }

    /**
     * Put a value to the map
     * @param key key to find the value
     * @param value value which we want to store
     */
    public void put(K key, V value){
        // get bucket index
        int bucketIndex = this.getBucketIndex(key);

        // target linked list does not exist yet
        if (bucket[bucketIndex] == null) {
            bucket[bucketIndex] = new LinkedList<>();
        }

        // add the entry into the bucket
        bucket[bucketIndex].add(new CustomEntry<>(key,value));
    }

    /**
     * Get bucket index from key
     * @param key key whose hashcode determines the bucket index
     * @return bucket index which corresponds to the key
     */
    private int getBucketIndex(K key) {
        return key.hashCode() % this.bucket.length;
    }

}
