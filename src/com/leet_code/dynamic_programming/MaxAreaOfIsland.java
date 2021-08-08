package com.leet_code.dynamic_programming;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, getArea(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + getArea(grid, i-1, j)
                + getArea(grid, i, j-1)
                + getArea(grid, i+1, j)
                + getArea(grid, i, j+1);

    }
}
