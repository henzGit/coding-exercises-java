package com.leet_code.dynamic_programming;

/**
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 * https://leetcode.com/problems/unique-paths/submissions/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;

        int[][] tab = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( i == 0 || j == 0) {
                    tab[i][j] = 1;
                } else {
                    tab[i][j] = tab[i-1][j] + tab[i][j-1];
                }
            }
        }
        return tab[m-1][n-1];
    }
}
