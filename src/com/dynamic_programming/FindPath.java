package com.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Public class used to find path in a maze
 */
public class FindPath {

    public static class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("(row: %1d, column: %1d)", row, col);
        }
    }

    /**
     * Find a path starting from most right bottom until (0,0) in a two-dimensional maze
     * @param maze two-dimensional array
     * @return path if there is any, otherwise null
     */
    public static List<Point> getPathFromBooleanMaze(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if (
                getPathFromBooleanMaze(
                    maze,
                    maze.length-1,
                    maze[0].length-1,
                    path,
                    failedPoints
                )
        ) {
            return path;
        }
        return null;
    }

    /**
     * Check if there is a path
     * @param maze two dimensional array
     * @param row current row
     * @param col current column
     * @param path current path
     * @param failedPoints current failed points
     * @return true if there is a path, otherwise false
     */
    private static boolean getPathFromBooleanMaze(
            boolean[][] maze,
            int row,
            int col,
            List<Point> path,
            Set<Point> failedPoints) {
        if (col < 0 || row < 0 || !maze[row][col] ) {
            return false;
        }
        Point p = new Point(row, col);

        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (
                isAtOrigin ||
                getPathFromBooleanMaze(maze, row, col-1, path, failedPoints) ||
                getPathFromBooleanMaze(maze, row-1, col, path, failedPoints)
        ) {
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }


}
