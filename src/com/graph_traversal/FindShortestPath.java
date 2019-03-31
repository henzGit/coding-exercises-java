package com.graph_traversal;

import java.util.*;

public class FindShortestPath {

    /**
     * Class Path representing total weight for each connection
     * and also path from each node
     */
    public static class Path {
        private int distance;

        private Set<Integer> path;

        public Path () {
            this.distance = 0;
            this.path  = new HashSet<>();
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Set<Integer> getPath() {
            return path;
        }

        public void setPath(Set<Integer> path) {
            this.path = path;
        }

    }

    /**
     * A utility function to find the vertex with minimum distance value,
     * from the set of vertices not yet included in shortest path tree
     * @param distances list of minimum distance for each vertex from source
     * @param sptSet list containing which nodes have been visited or not
     * @return vertex with minimum distance value
     */
    private static int minDistanceVertex(int[] distances, boolean[] sptSet) {
        int minDistanceVertex = -1 ;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < distances.length; i ++) {
            if (!sptSet[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minDistanceVertex = i;
            }
        }

        return minDistanceVertex;
    }

    /**
     * Find shortest path using dijkstra Algorithm
     * @param adjMatrix weight of edges between nodes
     * @param src beginning point
     * @param dest destination point
     * @return shortest path calculated using dijkstra algorithm
     */
    public static Path dijkstra(int[][] adjMatrix, int src, int dest) {
        Path shortestPath = new Path();

        int nodeNum = adjMatrix[0].length;

        // sptSet[i] will be true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        boolean[] sptSet = new boolean[nodeNum];

        // The output array. dist[i] will hold
        // the shortest distance from src to i
        int[] dist = new int[nodeNum];

        // list of paths from src to dest
        Set<Integer>[] paths = new Set[nodeNum];

        // Initialize all distances as INFINITE and sptSet[] as false
        for (int i = 0; i < nodeNum; i++) {
            sptSet[i] = false;
            dist[i] = Integer.MAX_VALUE;
            paths[i] = new LinkedHashSet<>();
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Initialize paths for source
        paths[src].add(src);

        // Find shortest path for all vertices
        for (int i = 0; i < nodeNum; i++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistanceVertex(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < nodeNum; v++) {
                if (
                        !sptSet[v]
                        && adjMatrix[u][v] != 0
                        && dist[u] + adjMatrix[u][v] < dist[v]
                ) {
                    dist[v] = dist[u] + adjMatrix[u][v];

                    // create path from current vertex
                    paths[v] = new LinkedHashSet<>(paths[u]);
                    // add adjacent vertex
                    paths[v].add(v);
                }
            }
        }
        shortestPath.setDistance(dist[dest]);
        shortestPath.setPath(paths[dest]);

        return shortestPath;
    }

    /**
     * Public cla
     */
    public static class Point {
        private int row;
        private int col;
        private int distance;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
            this.distance = 0;
        }

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return String.format("(row: %1d, column: %1d)", row, col);
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getDistance() {
            return distance;
        }
    }

    /**
     * Check if row and column is within maze boundary
     * @param row row to be checked
     * @param col column to be checked
     * @param maxRow maximum row
     * @param maxCol maximum colum
     * @return true if valid, otherwise false
     */
    private static boolean isValidRowCol(int row, int col, int maxRow, int maxCol) {
        if (
                row > -1 && col > -1 && row <= maxRow && col <= maxCol
        ) {
            return true;
        }

        return false;
    }

    /**
     * Find minimum distance from source to destination in a maze using BFS
     * @param maze 2D maze containing 0 and 1. 0 indicates the node is blocked
     *             while 1 indicates that the nodes can be passed through
     * @param src start point
     * @param dest end point
     * @return minimum distance from start point to end point
     */
    public static int bfs(int[][] maze, Point src, Point dest) {
        int mazeLen = maze.length;
        int mazeWidth = maze[0].length;

        boolean[][] visitedPoints = new boolean[mazeLen][mazeWidth];

        List<Point> queue = new ArrayList<>();
        queue.add(src);

        int[] rowNum = { 0, 1, -1,  0};
        int[] colNum = { 1, 0,  0, -1};

        while (!queue.isEmpty()) {
            Point currPoint = queue.remove(0);
            int currDistance = currPoint.getDistance();

            if (
                    currPoint.getRow() == dest.getRow()
                    && currPoint.getRow() == dest.getRow()
                ) {
                return currDistance;
            }

            // list 4 candidate points from current point
            for (int i = 0 ; i < 4; i++) {
                int nextRow = currPoint.getRow() + rowNum[i];
                int nextCol = currPoint.getCol() + colNum[i];
                if (
                        isValidRowCol(nextRow, nextCol, mazeLen-1, mazeWidth-1)
                        && !visitedPoints[nextRow][nextCol]
                        && maze[nextRow][nextCol] == 1
                ) {
                    visitedPoints[nextRow][nextCol] = true;
                    queue.add(new Point(nextRow, nextCol, currDistance+1));
                }
            }
        }

        return -1;
    }
}
