package com.leet_code;
import java.util.*;

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
