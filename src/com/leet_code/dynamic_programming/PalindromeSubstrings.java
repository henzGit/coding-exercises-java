package com.leet_code.dynamic_programming;

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromeSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (y > x) continue;
                if (y == x) {
                    dp[y][x] = true;
                } else if (Math.abs(y - x) == 1) {
                    dp[y][x] = s.charAt(y) == s.charAt(x);
                } else {
                    int newX = x - 1;
                    int newY = y + 1;
                    if (newY < n && newY >= 0
                            && newX < n && newX >= 0) {
                        dp[y][x] = dp[newY][newX] && s.charAt(y) == s.charAt(x);
                    }
                }
                if (dp[y][x]) count++;
            }
        }
        return count;
    }
}
}
