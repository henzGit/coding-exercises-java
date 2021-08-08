package com.leet_code.data_structure;
import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            String hash = getSortedStr(str);
            if(!map.containsKey(hash)) {
                map.put(hash, new LinkedList<>());
            }
            map.get(hash).add(str);
        }
        return new ArrayList<>(map.values());
    }


    private String getSortedStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
