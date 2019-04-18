package com.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Class of Codility Solution
 */
public class Solution {

    /**
     * Find the smallest positive integer not occurring in input array
     * @param A input array
     * @return smallest integer
     * Examples:
     *  A = [1, 3, 6, 4, 1, 2] -> returns 5
     *  A = [1, 2, 3] -> returns 4
     *  A = [−1, −3] -> returns 1
     */
    public int smallestPositiveIntegerNotOccurInArray(int[] A) {
        Set<Integer> set = new HashSet<>();
        int maxNumber = Integer.MIN_VALUE;
        for (int a: A) {
            if (a > maxNumber) {
                maxNumber = a;
            }
            set.add(a);
        }
        int smallestNum = 1;

        boolean containsAllFlag = true;
        for (int i = 1; i <= maxNumber; i++) {
            if (!set.contains(i)) {
                smallestNum = i;
                containsAllFlag = false;
                break;
            }
        }
        if (containsAllFlag && maxNumber > 0) smallestNum = maxNumber+1;

        return smallestNum;
    }
}
