package com.leet_code.graph;
import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where
 * prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want
 * to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return true;

        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }

        for(int[] pre: prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        int[] visited = new int[numCourses];

        for(int j = 0; j < numCourses; j++) {
            if(!dfs(graph, visited, j)) return false;
        }
        return true;
    }

    private boolean dfs(List<Set<Integer>> graph, int[] visited, int index) {
        if(visited[index] == -1) return false;
        if(visited[index] == 1) return true;

        visited[index] = -1;
        for(int pre: graph.get(index)) {
            if(!dfs(graph, visited, pre)) return false;
        }

        visited[index] = 1;
        return true;
    }
}
