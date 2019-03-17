package com.algorithm;

import java.util.List;
import java.util.ArrayList;

/**
 * Public class containing various sorting algorithms
 */
public class SortAlgorithm {

    /**
     * Sorting list of integers using Bubble Sort Algorithm
     * Complexity is O(n*n)
     * @param inputArray array to be sorted
     */
    public static void bubbleSort(List<Integer> inputArray) {
        for (int i = 0; i < inputArray.size() ; i++) {
            for (int j = 1; j < inputArray.size()-i  ; j++) {
                int upperNumber = inputArray.get(j);
                int lowerNumber = inputArray.get(j-1);

                // compare two elements in an iteration
                if (upperNumber < lowerNumber) {
                    inputArray.set(j, lowerNumber);
                    inputArray.set(j-1, upperNumber);
                }
            }
        }
    }

    /**
     * Sorting input array using Selection Sort Algorithm
     * Big O Complexity is n*n
     * @param inputArray array to be sorted
     */
    public static void selectionSort(List<Integer> inputArray) {

        for (int i = 0; i < inputArray.size(); i++) {
            int minValue = 1000000000;
            int minValueIndex = -1;
            for (int j = i; j < inputArray.size(); j++) {
                int currentElement = inputArray.get(j);

                // compare with current minimum point
                if (currentElement < minValue) {
                    minValue = currentElement;
                    minValueIndex = j;
                }
            }
            // swap min value with beginning
            int beginValue = inputArray.get(i);
            inputArray.set(i, minValue);
            inputArray.set(minValueIndex, beginValue);
        }
    }

    /**
     * Sorting input array using Insertion Sort Algorithm
     * Big O Complexity is n*n
     * @param inputArray array to be sorted
     */
    public static void insertionSort(List<Integer> inputArray){

        for (int i = 0 ; i < inputArray.size(); i++) {
            int minValue = 1000000000;
            int minValueIndex = -1;
            for (int j = i; j < inputArray.size() ; j++){
                int currentValue = inputArray.get(j);
                if (currentValue < minValue) {
                    minValue = currentValue;
                    minValueIndex = j;
                }
            }

            // shift array
            for (int k = minValueIndex; k > i ; k-- ){
                inputArray.set(k, inputArray.get(k-1));
            }
            inputArray.set(i, minValue);
        }
    }

    /**
     * Sorting input array using Merge Sort Algorithm
     * Big O Complexity is n*log(n)
     * @param inputArray array to be sorted
     * @return sorted array
     */
    public static List<Integer> mergeSort(List<Integer> inputArray){
        if (inputArray.size() > 1) {
            int middlePoint = (inputArray.size() / 2);

            // sort first half
            List<Integer> firstHalf = new ArrayList<>(
                    inputArray.subList(0, middlePoint)
            ) ;
            firstHalf = mergeSort(firstHalf);

            // sort second half
            List<Integer> secondHalf = new ArrayList<>(
                    inputArray.subList(middlePoint, inputArray.size())
            ) ;
            secondHalf = mergeSort(secondHalf);

            // merge
            return merge(firstHalf, secondHalf);
        }
        return inputArray;
    }

    /**
     * Merge two input arrays (part of Merge Sort Algorithm)
     * Big O Complexity is n*log(n)
     * @param array1 array1 to be merged
     * @param array2 array1 to be merged
     * @return a merged array
     */
    private static List<Integer> merge(List<Integer> array1, List<Integer> array2){
        List<Integer> outputArray = new ArrayList<>();

        int pointerArray1 = 0;
        int pointerArray2 = 0;
        int maxPointer1 = array1.size();
        int maxPointer2 = array2.size();

        while (pointerArray1 < maxPointer1 && pointerArray2 < maxPointer2) {
            int valueArray1 = array1.get(pointerArray1);
            int valueArray2 = array2.get(pointerArray2);
            if ( valueArray1 <= valueArray2 ) {
                outputArray.add(valueArray1);
                pointerArray1 += 1;
            } else {
                outputArray.add(valueArray2);
                pointerArray2 += 1;
            }
        }

        // if there is any remaining array 1
        while (pointerArray1 < maxPointer1) {
            int valueArray1 = array1.get(pointerArray1);
            outputArray.add(valueArray1);
            pointerArray1 += 1;
        }

        // if there is any remaining array 2
        while (pointerArray2 < maxPointer2) {
            int valueArray2 = array2.get(pointerArray2);
            outputArray.add(valueArray2);
            pointerArray2 += 1;
        }

        return outputArray;

    }

    /**
     * Sorting input array using Quick Sort Algorithm
     * Big O Complexity is n*log(n)
     * @param inputArray array to be sorted
     */
    public static void quickSort(List<Integer> inputArray){

        if (inputArray.size() > 1) {
            // partition input Array according to pivot
            int indexPartition = partition(inputArray);

            List<Integer> leftPartition = inputArray.subList(0, indexPartition);
            if (leftPartition.size() > 1) {
                quickSort(leftPartition);
            }

            if (indexPartition+1 < inputArray.size()-1) {
                List<Integer> rightPartition = inputArray.subList(
                        indexPartition+1, inputArray.size()
                );
                if (rightPartition.size() > 1) {
                    quickSort(rightPartition);
                }
            }
        }

    }

    /**
     * Partition input array for Quick Sort Algorithm
     * @param inputArray input array to be partitioned
     * @return partition index
     */
    private static int partition(List<Integer> inputArray){
        // make right most element the pivot
        int pivotIndex = inputArray.size()-1;
        int pivotValue = inputArray.get(pivotIndex);
        int i = -1;

        for (int j = 0; j < pivotIndex; j++) {
            int currValue = inputArray.get(j);
            if (currValue <= pivotValue) {
                i++;
                // swap element i and j
                int valueI = inputArray.get(i);
                int valueJ = inputArray.get(j);
                inputArray.set(i, valueJ);
                inputArray.set(j, valueI);
            }
        }

        // swap pivot with element(i+1)
        int tempValueI = inputArray.get(i+1);
        inputArray.set(i+1, pivotValue);
        inputArray.set(pivotIndex , tempValueI);

        return i+1;
    }

}

