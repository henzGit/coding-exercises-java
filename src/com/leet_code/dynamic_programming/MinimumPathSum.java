package com.leet_code.dynamic_programming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if(i-1 < 0 && j-1 >= 0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else if(j-1 < 0 && i-1 >= 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];

                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
