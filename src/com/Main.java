package com;

import java.util.List;
import com.algorithm.SortAlgorithm;
import com.algorithm.SearchAlgorithm;
import com.data_structure.CustomHashMap;
import com.other.FindPathInMaze.Point;
import com.other.FindPathInMaze;

public class Main {

    public static void testSortAlgorithms() {
        // generate random numbers
        int n = 10;
        List<Integer> inputSort = Utils.generateRandomIntegers(n, n);
        System.out.println("inputSort: " + inputSort);

        // test Bubble Sort algorithm
        SortAlgorithm.bubbleSort(inputSort);
        System.out.println("inputSort: " + inputSort);

        // test Selection Sort algorithm
        SortAlgorithm.selectionSort(inputSort);
        System.out.println("inputSort: " + inputSort);

        // test Insertion Sort algorithm
        SortAlgorithm.insertionSort(inputSort);
        System.out.println("inputSort: " + inputSort);

        // test Merge Sort algorithm
        List<Integer> outputSort = SortAlgorithm.mergeSort(inputSort);
        System.out.println("outputSort: " + outputSort);

        // test Quick Sort algorithm
        SortAlgorithm.quickSort(inputSort);
        System.out.println("inputSort: " + inputSort);
    }

    public static void testSearchAlgorithms() {
        // generate random numbers
        int n = 10;
        List<Integer> inputSearch = Utils.generateRandomIntegers(n, n);

        int searchNumber = 5;

        // test Binary Search algorithm
        int indexInput = SearchAlgorithm.binarySearch(inputSearch, searchNumber);
        System.out.println("indexInput: " + indexInput);

    }

    public static void testDataStructures() {
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.put("test", 1);
        System.out.println("test get customHashMap: " + customHashMap.get("test"));
        System.out.println("test get customHashMap: " + customHashMap.get("test2"));
    }

    public static void testOther() {
        // create a two-dimensional boolean maze
        boolean[][] maze = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {false, false, true},
        };

        // test find path in maze problem
        List<Point> path = FindPathInMaze.getPathFromBooleanMaze(maze);
        System.out.println("path: " + path.toString());
    }

    public static void main(String[] args) {
        

    }
}
