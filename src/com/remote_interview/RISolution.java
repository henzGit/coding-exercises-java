package com.remote_interview;

import java.util.HashSet;
import java.util.Set;

public class RISolution {

    /**
     * Print number of similar words
     * @param W target word
     * @param L list of words
     */
    public static void printCountSimilarWords(String W, String L) {
        String[] list = L.split(" ");
        int count = 0;
        Set<Character> chars = new HashSet<>();
        Set<String> uniqueWords = new HashSet<>();
        for (char ch: W.toCharArray()) {
            chars.add(ch);
        }

        for (String word: list) {
            if (uniqueWords.contains(word)) {
                continue;
            }
            uniqueWords.add(word);
            Set<Character> chars2 = new HashSet<>();
            for (char ch: word.toCharArray()) {
                chars2.add(ch);
            }
            if(chars.equals(chars2) ){
                count +=1;
            }
        }
        System.out.println(count);
    }

}
