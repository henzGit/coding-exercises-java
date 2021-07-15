package com.leet_code;
import java.util.*;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] out = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<temperatures.length; i++) {
            while(stack.size() >0) {
                int oldIndex = stack.peek();
                if(temperatures[i] > temperatures[oldIndex]) {
                    out[oldIndex] = i-oldIndex;
                    stack.pop();
                } else break;
            }
            stack.push(i);
        }
        return out;
    }
}
