package com.leet_code.greedy;
import java.util.*;

public class LargestValuesFromLabels {
    class Pair {
        int value;
        int label;

        Pair(int v, int l) {
            value = v;
            label = l;
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> b.value - a.value
        );
        
        for(int i = 0; i < n; i ++) {
            maxHeap.add(new Pair(values[i], labels[i]));
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        while(!maxHeap.isEmpty() && numWanted > 0) {
            Pair cur = maxHeap.remove();
            map.put(cur.label, 1+ map.getOrDefault(cur.label, 0));
            if(map.get(cur.label) <= useLimit) {
                res += cur.value;
                numWanted--;
            }
        }

        return res;
    }
}
