package com.leet_code.dfs;
import java.util.*;

/**
 * You are given an array of strings arr. A string s is formed by the concatenation
 * of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no
 * elements without changing the order of the remaining elements.
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public int maxLength(List<String> arr) {
        return findMaxLen(arr, 0, "");
    }

    private int findMaxLen(List<String> arr, int idx, String curr) {
        boolean isUnique = isUnique(curr);
        if(!isUnique) return 0;
        if(arr.size() == idx && isUnique) return curr.length();
        int len1 = findMaxLen(arr, idx + 1, curr);
        int len2 = findMaxLen(arr, idx + 1, curr + arr.get(idx));
        return Math.max(len1, len2);
    }

    private boolean isUnique(String str) {
        int[] tab = new int[26];
        for(char c: str.toCharArray()) {
            if(++tab[c - 'a'] > 1) return false;
        }
        return true;
    }
}
