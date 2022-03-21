package com.leet_code.string;

/**
 * Given a string s, return true if the s can be palindrome after deleting
 * at most one character from it.
 * https://leetcode.com/problems/valid-palindrome-ii/submissions/
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return isPalin(s);
    }

    private boolean isPalin(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();
        boolean alreadyDelete = false;
        while(i < j) {
            if(chars[i] != chars[j]) {
                if(alreadyDelete) {
                    return false;
                }
                if(chars[i] == chars[j-1] && chars[i+1] != chars[j]) {
                    alreadyDelete = true;
                    j--;
                } else if (chars[i+1] == chars[j] && chars[i] != chars[j-1]) {
                    alreadyDelete = true;
                    i++;
                } else if ( chars[i+1] != chars[j] && chars[i] != chars[j-1]) {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;

    }
}
