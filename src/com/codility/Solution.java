package com.codility;

import java.util.*;

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

    /**
     * Function to calculate the binary period of an integer
     * @param n the input integer
     * @return the binary period of input integer
     *
     * A non-empty zero-indexed string S consisting of Q characters is given.
     * The period of this string is the smallest positive integer P such that:
     * P≤Q/2 and S[K]=S[K+P] for 0≤K<Q−P.
     * So for example, for the integers 955, 1651 and 102, convert the
     * numbers to binary and the function should return 4,5,-1 respectively.
     * The function returns -1 if there is no binary period for the given integer.
     * The int n can be any value between 1 to 99999999
     */
    public int findBinaryPeriodOfAnInt(int n) {
        String base2 = Integer.toString(n, 2);
        int len = base2.length();

        for (int j = 2; j <= len/2; j++) {
            String substr = base2.substring(0, j);
            int beginIndex2 = j;
            int endIndex2 = 2*j;
            if (endIndex2 < len) {
                String substr2 = base2.substring(beginIndex2, endIndex2);
                if (substr.equals(substr2)) return substr.length();
            }
        }
        return -1;
    }

    /**
     * Find a pair of indices (P, Q), such that A[P] <= A[Q]
     * and the distance between P and Q is maximal, that is
     * the value Q − P is maximal.
     * @param A input array
     * @return maximal distance Q - P
     */
    public int findMaxDistanceMonotonic(int[] A) {
        int maxDistance = -1;

        // find candidates for P
        LinkedList<List<Integer>> candidates = new LinkedList<>();

        for (int P = 0; P < A.length; P++) {
            if (P == 0 || A[P] < candidates.getLast().get(0)) {
                candidates.add(new ArrayList<>(Arrays.asList(A[P], P)));
            }
        }

        // try to find pair P-Q from last index of A in descending order
        for (int Q = A.length-1; Q >= 0; Q--) {
            int i = 0;
            while (candidates.size() > 0
                    && i <= candidates.size()-1
            ) {
                List<Integer> currCandidate = candidates.get(i);
                int currCandidateIndex = currCandidate.get(1);
                int currCandidateValue = currCandidate.get(0);
                // if Q - index of current candidate is less than max distance
                // abort calculation since max distance has already been found
                if ( (Q - currCandidateIndex) <= maxDistance) {
                    return maxDistance;
                }

                if (A[Q] >= currCandidateValue) {
                    // calculate max distance candidate given Q index
                    int maxDistCandidate = Q-currCandidateIndex;
                    if (maxDistCandidate > 0) {
                        maxDistance = Math.max(
                                maxDistance,
                                maxDistCandidate);
                        candidates.remove(i);
                    }
                }
                i++;
            }
        }

        return maxDistance;
    }

}
