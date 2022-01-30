package com.leet_code.string;
import java.util.*;

/**
 * Given a string s, sort it in decreasing order based on the frequency
 * of characters, and return the sorted string.
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        StringBuilder str = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            String tmp = "" + c;
            tmp = tmp.repeat(map.get(c));
            str.append(tmp);
        }

        return str.toString();
    }
}
