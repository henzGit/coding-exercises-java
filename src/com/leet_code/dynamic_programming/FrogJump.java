package com.leet_code.dynamic_programming;
import java.util.*;

/**
 * A frog is crossing a river. The river is divided into some number of units,
 * and at each unit, there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog can cross the river by landing on the last stone.
 * Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, its next jump must be
 * either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 * https://leetcode.com/problems/frog-jump/
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        final int DESTINATION = stones[stones.length - 1];

        if (stones.length == 1) return true;
        if (stones[1] != 1) return false;

        for (int i = 1 ; i < stones.length; i++) {
            if (stones[i] - stones[i-1] > i)
                return false;
        }

        // key: position of a stone,
        // value: a set of steps(len) reached to this stone
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (Integer position : stones) {
            map.put(position, new HashSet<Integer>());
        }

        return dfs(1, 1, map, DESTINATION);
    }

    private boolean dfs(final int position,
                        final int step,
                        final Map<Integer, Set<Integer>> map,
                        final int DESTINATION) {

        if (position > DESTINATION ||
                step <= 0 ||
                !map.containsKey(position) ||
                map.get(position).contains(step)) {
            return false;
        }

        if (position == DESTINATION) {
            return true;
        }

        map.get(position).add(step);
        return dfs(position + step + 1, step + 1, map, DESTINATION) ||
                dfs(position + step, step, map, DESTINATION) ||
                dfs(position + step - 1, step - 1, map, DESTINATION);
    }
}
