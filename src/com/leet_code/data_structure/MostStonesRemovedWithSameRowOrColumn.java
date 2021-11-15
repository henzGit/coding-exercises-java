package com.leet_code.data_structure;
import java.util.*;

public class MostStonesRemovedWithSameRowOrColumn {
    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null) {
            islands++;
        }
        if (x != f.get(x)) {
            int y = find(f.get(x));
            f.put(x, y);
        }
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }
}
