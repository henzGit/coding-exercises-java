package com.leet_code.graph;
import java.util.*;

/**
 * We want to split a group of n people (labeled from 1 to n) into two groups
 * of any size. Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi]
 * indicates that the person labeled ai does not like the person labeled bi,
 * return true if it is possible to split everyone into two groups in this way.
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<Set<Integer>> g = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
            g.add(new HashSet<>());
        }
            for(int[] dis: dislikes) {
            g.get(dis[0]).add(dis[1]);
            g.get(dis[1]).add(dis[0]);
        }

        int[] visited = new int[n+1];
            for(int i = 1; i <= n; i++) {
            if(visited[i] == 0 && !dfs(g, visited, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(List<Set<Integer>> g, int[] visited, int index, int color) {
        visited[index] = color;
        for(int j : g.get(index)) {
            if(visited[j] == color) return false;
            if(visited[j] == 0 && !dfs(g, visited, j, -color)) return false;
        }

        return true;
    }
}
