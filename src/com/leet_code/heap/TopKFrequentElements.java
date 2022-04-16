package com.leet_code.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a,b) -> map.get(a) - map.get(b)
        );

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        for(Integer e: map.keySet()) {
            minHeap.add(e);
            if(minHeap.size()>k) minHeap.remove();
        }

        int[] res = new int[minHeap.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = minHeap.remove();
        }
        return res;
    }
}
