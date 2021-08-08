package com.leet_code.palindrome;

/**
 * Given a string s, return the longest palindromic substring in s.
 *　https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s == "") return "";

        int n = s.length();
        if (n == 1) return s;

        String palin = s.substring(0,1);
        char[] input = s.toCharArray();
        int mid, i, j  = 0;

        for (mid = 0; mid < n ;mid++) {
            // odd palindrome
            for (i = 1; mid-i >= 0 && mid+i < n ; i++) {
                if (input[mid-i] != input[mid+i]) {
                    break;
                }
                String oddPalin = s.substring(mid-i, mid+i+1);
                if (oddPalin.length() > palin.length()) palin = oddPalin;
            }

            // even palindrome
            for (j=1; mid-j >=0 && mid+j-1 < n ; j++) {
                if (input[mid-j] != input[mid+j-1]) {
                    break;
                }
                String evenPalin = s.substring(mid-j, mid+j);
                if (evenPalin.length() > palin.length()) palin = evenPalin;
            }
        }

        return palin;
    }
}
