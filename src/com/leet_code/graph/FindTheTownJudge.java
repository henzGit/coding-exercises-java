package com.leet_code.graph;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n];
        boolean[] out = new boolean[n];

        for(int[] t : trust) {
            in[t[1]-1]++;
            out[t[0]-1] = true;
        }

        for(int i = 0; i < n; i++) {
            if(!out[i] && in[i] == n-1) return i+1;
        }

        return -1;
    }
}
