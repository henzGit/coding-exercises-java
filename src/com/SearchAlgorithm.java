package com;

import java.util.List;

/**
 * Public class containing various searching algorithms
 */
public class SearchAlgorithm {

    /**
     * Search a number inside an array using binary search
     * Big O Complexity is n*log(n)
     * @param inputArray array where the number can be found
     * @param searchedNumber number to be searched
     * @return -1 if not found, otherwise return 0
     */
    public static int binarySearch(List<Integer> inputArray, int searchedNumber){
        // for inputArray containing only one element
        if (inputArray.size() == 1) {
            if (inputArray.get(0) == searchedNumber) {
                return 0;
            }
        }

        // for inputArray containing more than one element
        if (inputArray.size() > 1) {
            int middleIndex = inputArray.size()/2;

            if (searchedNumber == inputArray.get(middleIndex)) {
                return middleIndex;
            }
            List<Integer> leftPart = inputArray.subList(0, middleIndex);
            // search left part
            if (leftPart.size() > 0) {
                int leftIndex = binarySearch(leftPart, searchedNumber);
                if (leftIndex > -1) {
                    return leftIndex;
                }
            }

            List<Integer> rightPart = inputArray.subList(middleIndex + 1, inputArray.size());
            // search right part
            if (rightPart.size() > 0) {
                int rightIndex = binarySearch(rightPart, searchedNumber);
                if (rightIndex > -1) {
                    // return full index by taking into account the middle index
                    return rightIndex + middleIndex + 1;
                }
            }
        }
        return -1;
    }

}

