package com.leet_code.dfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';

        if(i+1 < m) dfs(grid, i+1, j);
        if(j+1 <n) dfs(grid, i, j+1);
        if(i-1 >= 0) dfs(grid, i-1, j);
        if(j-1 >= 0) dfs(grid, i, j-1);
    }
}
