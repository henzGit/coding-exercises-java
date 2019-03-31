package com.dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringConstructDp {
    // set used for memoization to optimize performance
    private static Map<String, Boolean> memo = new HashMap<>();

    /**
     * Check if input can be constructed using words in dictionary
     * @param input input to be constructed
     * @param dict dictionary of words
     * @return true if input string can be constructed from words in dictionary
     *          , otherwise false
     */
    public static boolean isConstructableByDictWrapper(String input, List<String> dict) {
        return isConstructableByDict(input, dict);
    }

    /**
     * Internal method to find if input is constructible from dict
     * @param input input to be constructed
     * @param dict dictionary of words
     * @return true if input string can be constructed from words in dictionary
     *          , otherwise false
     */
    private static boolean isConstructableByDict(String input, List<String> dict) {
        int size = input.length();

        // base case
        if ( size == 0 ) return true;

        // if in memo
        if (memo.containsKey(input)) {
            return memo.get(input);
        }

        for (int i = 1; i <= size; i++) {
            if (
                    dict.contains(input.substring(0, i)) &&
                            isConstructableByDict(input.substring(i, size), dict)
            ) {
                memo.put(input, true);
                return true;
            }
        }
        memo.put(input, false);
        return false;
    }


}
