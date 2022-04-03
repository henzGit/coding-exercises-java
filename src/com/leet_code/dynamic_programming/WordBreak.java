package com.leet_code.dynamic_programming;

import java.util.HashMap;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if
 * s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> mem = new HashMap<>();
        mem.put(0, checker(s, wordDict, 0, mem));
        return mem.get(0);
    }
    public boolean checker(String s, List<String> wordDict, int start, HashMap<Integer, Boolean> mem){
        int n = s.length();
        if(start == n){
            mem.put(start, true);
            return true;
        }
        if(mem.containsKey(start)){
            return mem.get(start);
        }
        for(int i=start; i<n; i++){
            if(wordDict.contains(s.substring(start, i+1)) && checker(s, wordDict, i+1, mem)){
                mem.put(start, true);
                return true;
            }
        }
        mem.put(start, false);
        return false;
    }
}
