package com;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

import com.algorithm.SortAlgorithm;
import com.algorithm.SearchAlgorithm;
import com.data_structure.CustomHashMap;
import com.dynamic_programming.FindCombination;
import com.dynamic_programming.FindMaxValue;
import com.dynamic_programming.FindPath.Point;
import com.dynamic_programming.FindPath;
import com.dynamic_programming.FindMaxValue.*;
import com.dynamic_programming.StringConstruct;
import com.graph_traversal.NetworkGraph;
import com.graph_traversal.FindShortestPath;
import com.graph_traversal.FindShortestPath.Path;

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

    public static void testFindPath() {
        //////////////////////// Test find path in a maze //////////////////////
        // create a two-dimensional boolean maze
        boolean[][] maze = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {false, false, true},
        };

        // test find path in maze problem
        List<Point> path = FindPath.getPathFromBooleanMaze(maze);
        System.out.println("path: " + path.toString());
    }

    public static void testFindMaxValue() {
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
        float maxProfit = FindMaxValue.maxProfitStockOptions(stockOptions);

        ///////////////////// Test find max profit with two transactions //////////////////////
        int prices[] = {2, 30, 15, 10, 8, 25, 80};
        float profit = FindMaxValue.maxProfitWithMaxTwoTransactions(prices);
        System.out.println("Maximum Profit = "+ profit);

        ///////////////////// Test find max product of three integers //////////////////////
        int[] inputInts = new int[] {-100, 100, 200, 9, 2};
        int maxProducts = FindMaxValue.findMaxProductsThreeInts(inputInts);
        System.out.println("maxProducts: " + maxProducts);
    }

    public static void testStringConstruct() {
        String[] substrings = {
                "B", "T", "A", "C", "MA", "N", "M", "XXXX", "ATMA"
        };
        String stringToBeConstructed = "BATMANXXCX";
        boolean canStringBeConstructed =
                StringConstruct.isStringConstructableFromSubstrings(
                    stringToBeConstructed, Arrays.asList(substrings)
        );
        System.out.println("canStringBeConstructed: " + canStringBeConstructed);
    }

    public static void testFindCombination() {
        // test find anagrams in dict
        String[] words = {"cat", "bac", "test", "act", "demon", "tset", "act", "tac"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        List<String> anagrams = FindCombination.findAnagramInDict(wordList);
        System.out.println("anagrams: " + anagrams);
    }

    /**
     * Selection of the test case
     * @param selection number of test case
     */
    public static void testGraph(int selection) {
        switch(selection) {
            case 0:
                // find network cluster sizes
                String fileName = "task2-test-input.txt";
                String inputPath = Paths.get(".", "src", "com", "graph_traversal", fileName)
                        .toString();
                NetworkGraph.findSubclustersSize(inputPath, "output.txt");
                break;
            case 1:
                // find shortest path using Dijkstra
                /**
                 * 2d array which holds the weight of the edges
                 */
                /* Let us create the example graph discussed above */
                int adjacencyMatrix[][] = new int[][]{
                        {0, 4,  0, 0,  0,  0,  0, 8,  0},
                        {4, 0,  8, 0,  0,  0,  0, 11, 0},
                        {0, 8,  0, 7,  0,  4,  0, 0,  2},
                        {0, 0,  7, 0,  9,  14, 0, 0,  0},
                        {0, 0,  0, 9,  0,  10, 0, 0,  0},
                        {0, 0,  4, 14, 10, 0,  2, 0,  0},
                        {0, 0,  0, 0,  0,  2,  0, 1,  6},
                        {8, 11, 0, 0,  0,  0,  1, 0,  7},
                        {0, 0,  2, 0,  0,  0,  6, 7,  0}
                };

                /**
                 * source and destination vertices
                 */
                int src = 8;
                int dest = 4;

                Path shortestPath = FindShortestPath.Dijkstra(adjacencyMatrix, src, dest);
                System.out.println("shortestPath: " + shortestPath.getPath());
                System.out.println("shortestPath distance: " + shortestPath.getDistance());
        }

    }

    public static void testOther() {
    }

    public static void main(String[] args) {
        testGraph(1);
    }

}
