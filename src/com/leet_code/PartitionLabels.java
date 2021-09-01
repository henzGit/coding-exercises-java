package com.leet_code;
import java.util.*;

/**
 * You are given a string s. We want to partition the string into
 * as many parts as possible so that each letter appears in at most one part.
 *
 * Return a list of integers representing the size of these parts.
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> out = new ArrayList<>();

        int[] lasts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lasts[s.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while(i < s.length()) {
            int end = lasts[s.charAt(i) - 'a'];
            int j = i;
            while(j < end) {
                end = Math.max(end, lasts[s.charAt(j++) - 'a']);
            }
            out.add(j - i + 1);
            i = j + 1;
        }

        return out;
    }
}
