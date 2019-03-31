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
    public static boolean isConstructableByDictRecursive(String input, List<String> dict) {
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

    /**
     * Check if input can be constructed using words in dictionary
     * @param input input to be constructed
     * @param dict dictionary of words
     * @return true if input string can be constructed from words in dictionary
     *          , otherwise false
     */
    public static boolean isConstructableByDictIterative(String input, List<String> dict) {
        int size = input.length();
        if (size == 0) return true;

        // Create the DP table to store results of subproblems. The value wb[i]
        // will be true if str[0..i-1] can be segmented into dictionary words,
        // otherwise false.
        // initial values are all false
        boolean[] wb = new boolean[size+1];

        for (int i = 1; i <= size; i++) {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            if (wb[i] == false && dict.contains(input.substring(0, i))) {
                wb[i] = true;
            }
            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true) {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i+1; j <= size; j++)
                {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionary.contains() is
                    // substring starting from index 'i' and length 'j-i'
                    if (wb[j] == false && dict.contains(input.substring(i, i+j-i)))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }
        return false;
    }

}
