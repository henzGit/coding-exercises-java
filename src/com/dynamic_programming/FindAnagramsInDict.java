package com.dynamic_programming;

import java.util.*;

public class FindAnagramsInDict {

    /**
     * Find all anagrams in a dictionary
     * @param wordList list of words in a dictionary
     * @return list of anagrams
     */
    public static List<String> find(List<String> wordList) {
        Set<String> seenWords = new TreeSet<>();
        Set<String> anagrams = new TreeSet<>();

        for (String word: wordList) {
            // convert to char array since sort method of Arrays only
            // work on char array
            char[] tempArr = word.toCharArray();

            // sort char array
            Arrays.sort(tempArr);

            // create a new string with sorted char array
            String sortedStr = new String(tempArr);

            if (!seenWords.contains(sortedStr)) {
                seenWords.add(sortedStr);
            } else {
                if (!anagrams.contains(sortedStr)) {
                    anagrams.add(sortedStr);
                }
            }
        }

        return new ArrayList<>(anagrams);
    }

}
