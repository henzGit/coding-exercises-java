package com.leet_code.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase
 * English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get
 * after performing the above operations.
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String str, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int left = 0;
        int maxLen = 0;
        int n = str.length();
        for (int right = 0; right < n; right++) {
            char c = str.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
            int currLen = right - left + 1;

            if (currLen - maxFreq > k) {
                c = str.charAt(left);
                freqMap.put(c, freqMap.get(c) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
