package com.leet_code.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Your country has an infinite number of lakes.
 * Initially, all the lakes are empty, but when it rains over the nth lake,
 * the nth lake becomes full of water.
 * If it rains over a lake which is full of water, there will be a flood.
 * Your goal is to avoid the flood in any lake.
 *
 * Given an integer array rains where:
 *
 * rains[i] > 0 means there will be rains over the rains[i] lake.
 * rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
 * Return an array ans where:
 *
 * ans.length == rains.length
 * ans[i] == -1 if rains[i] > 0.
 * ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
 * If there are multiple valid answers return any of them.
 * If it is impossible to avoid flood return an empty array.
 *
 * Notice that if you chose to dry a full lake,
 * it becomes empty, but if you chose to dry an empty lake, nothing changes. (see example 4)
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 */
public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeroIndices = new TreeSet<>();

        for(int i = 0; i < n; i++) {
            int rain = rains[i];
            if(rain == 0) {
                zeroIndices.add(i);
                ans[i] = 1;
            } else {
                if(map.containsKey(rain)) {
                    int prevIndex = map.get(rain);
                    Integer IndexZero = zeroIndices.higher(prevIndex);
                    if(IndexZero == null) return new int[]{};
                    ans[IndexZero] = rain;
                    zeroIndices.remove(IndexZero);
                }
                ans[i] = -1;
                map.put(rain, i);
            }
        }
        return ans;

    }
}
