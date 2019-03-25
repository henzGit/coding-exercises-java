package com.dynamic_programming;

import java.util.*;

public class FindCombination {

    /**
     * Find all anagrams in a dictionary
     * @param wordList list of words in a dictionary
     * @return list of anagrams
     */
    public static List<String> findAnagramInDict(List<String> wordList) {
        Map<Integer, Set<String>> dict = new TreeMap<>();
        Set<String> anagrams = new TreeSet<>();

        for (String word: wordList) {
            // convert to char array since sort method of Arrays only
            // work on char array
            char[] tempArr = word.toCharArray();

            // sort char array
            Arrays.sort(tempArr);

            // create a new string with sorted char array
            String sortedStr = new String(tempArr);

            // calculate hashcode of sorted string
            int sortedStrHashCode = sortedStr.hashCode();

            // if hashcode does not yet exist in dict
            // initialize set and add first word
            // otherwise, get the set and add word into it
            if (!dict.containsKey(sortedStrHashCode)) {
                Set<String> tmpSet = new TreeSet<>();
                tmpSet.add(word);
                dict.put(sortedStrHashCode, tmpSet);
            } else {
                Set<String> tmpSet = dict.get(sortedStrHashCode);
                tmpSet.add(word);
            }
        }

        // iterate over the dict key to find anagrams
        for (Set<String> dictValues: dict.values()) {
            // anagrams are only for dictValues with
            if (dictValues.size() > 1) {
                anagrams.addAll(dictValues);
            }
        }
        return new ArrayList<>(anagrams);
    }
}
