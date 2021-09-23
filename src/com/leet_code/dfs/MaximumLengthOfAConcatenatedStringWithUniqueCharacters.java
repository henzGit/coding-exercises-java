package com.leet_code.dfs;
import java.util.*;

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
