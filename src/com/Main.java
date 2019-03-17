package com;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import com.algorithm.SortAlgorithm;
import com.algorithm.SearchAlgorithm;
import com.data_structure.CustomHashMap;
import com.other.FindMaxProfitStockOption;
import com.other.FindPathInMaze.Point;
import com.other.FindPathInMaze;
import com.other.FindMaxProfitStockOption.StockOption;

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
        //////////////////////// Test find path in a maze //////////////////////
        // create a two-dimensional boolean maze
        boolean[][] maze = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {false, false, true},
        };

        // test find path in maze problem
        List<Point> path = FindPathInMaze.getPathFromBooleanMaze(maze);
        System.out.println("path: " + path.toString());

        ///////////////////// Test find max profit stock option //////////////////////
        // test find max profit stock option
        int numberPoints = 10;
        // generate random floats
        List<Float> floats = Utils.generateRandomFloats(numberPoints, 100);

        // generate list of DateTimes
        List<LocalDateTime> times = Utils.generateDateTimes(numberPoints);

        // generate list of stock option prices
        List<StockOption> stockOptions = new LinkedList<>();
        for (int i = 0; i < numberPoints; i++) {
            StockOption stockOption = new StockOption(floats.get(i), times.get(i));
            stockOptions.add(stockOption);
        }
        float maxProfit = FindMaxProfitStockOption.findMaxProfitFromStockOptions(stockOptions);

        ///////////////////// Test find max profit with two transactions //////////////////////
        int prices[] = {2, 30, 15, 10, 8, 25, 80};
        float profit = FindMaxProfitStockOption.maxProfitTwoTransactions(prices);
        System.out.println("Maximum Profit = "+ profit);

    }

    public static void main(String[] args) {
    }
}
