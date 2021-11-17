package com.leet_code.array;
import java.util.*;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents
 * its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 * https://leetcode.com/problems/asteroid-collision/
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            if (stack.isEmpty()) stack.push(asteroid);
            else {
                if (stack.peek() < 0 && asteroid < 0) stack.push(asteroid);
                else if (stack.peek() < 0 && asteroid > 0) stack.push(asteroid);
                else if (stack.peek() > 0 && asteroid > 0) stack.push(asteroid);
                else if (stack.peek() > 0 && asteroid < 0) {
                    if (stack.peek() == Math.abs(asteroid)) stack.pop();
                    else if (stack.peek() > Math.abs(asteroid)) continue;
                    else {
                        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                            stack.pop();
                        }
                        if (stack.isEmpty()) stack.push(asteroid);
                        else if (stack.peek() < 0) stack.push(asteroid);
                        else if (stack.peek() > 0) {
                            if (stack.peek() == Math.abs(asteroid)) stack.pop();
                        }
                    }
                }
            }
        }

        int[] out = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            out[i] = stack.pop();
        }
        return out;
    }
}
