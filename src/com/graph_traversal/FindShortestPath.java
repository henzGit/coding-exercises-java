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
     * Find shortest path using Dijkstra Algorithm
     * @param adjMatrix weight of edges between nodes
     * @param src beginning point
     * @param dest destination point
     * @return shortest path calculated using Dijkstra algorithm
     */
    public static Path Dijkstra(int[][] adjMatrix, int src, int dest) {
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
                        && dist[u] != Integer.MAX_VALUE
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
}
