package com;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

import com.algorithm.SortAlgorithm;
import com.algorithm.SearchAlgorithm;
import com.codility.Solution;
import com.data_structure.CustomHashMap;
import com.data_structure.LRUCache;
import com.data_structure.SinglyLinkedList;
import com.dynamic_programming.*;
import com.dynamic_programming.FindMaxValue.*;
import com.graph_traversal.NetworkGraph;
import com.graph_traversal.FindShortestPath;
import com.graph_traversal.FindShortestPath.*;
import com.math_related.MathRelated;
import com.data_structure.BinaryTree;
import com.tree_traversal.TreeTraversal;

public class Main {

    /**
     * Selection of test case for sort algorithm related
     * @param selection number of selected test case
     */
    public static void testSortAlgorithms(int selection) {
        // generate random numbers
        int n = 10;
        List<Integer> inputSort = Utils.generateRandomIntegers(n, n);
        System.out.println("inputSort: " + inputSort);

        switch (selection) {
            case 0:
                // test Bubble Sort algorithm
                SortAlgorithm.bubbleSort(inputSort);
                System.out.println("inputSort: " + inputSort);
            case 1:
                // test Selection Sort algorithm
                SortAlgorithm.selectionSort(inputSort);
                System.out.println("inputSort: " + inputSort);
            case 2:
                // test Insertion Sort algorithm
                SortAlgorithm.insertionSort(inputSort);
                System.out.println("inputSort: " + inputSort);
            case 3:
                // test Merge Sort algorithm
                List<Integer> outputSort = SortAlgorithm.mergeSort(inputSort);
                System.out.println("outputSort: " + outputSort);
            case 4:
                // test Quick Sort algorithm
                SortAlgorithm.quickSort(inputSort);
                System.out.println("inputSort: " + inputSort);
        }
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

    /**
     * Selection of test case for data structure related
     * @param selection number of selected test case
     */
    public static void testDataStructures(int selection) {
        switch (selection) {
            case 0:
                CustomHashMap customHashMap = new CustomHashMap();
                customHashMap.put("test", 1);
                System.out.println("test get customHashMap: " + customHashMap.get("test"));
                System.out.println("test get customHashMap: " + customHashMap.get("test2"));
            case 1:
                SinglyLinkedList list = new SinglyLinkedList();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(4);
                list.printList();
                list.reverseList();
                list.printList();
            case 2:
                LRUCache cache = new LRUCache(4);
                for (int i = 1; i <= 10; i++) {
                    cache.put(i, i);
                }
                cache.printContent();
                cache.get(7);
                cache.printContent();
                cache.put(10,2);
                cache.printContent();
                cache.remove(7);
                cache.printContent();
                cache.evict();
                cache.printContent();
        }
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
        List<FindPath.Point> path = FindPath.getPathFromBooleanMaze(maze);
        System.out.println("path: " + path.toString());
    }

    /**
     * Selection of test case for finding max value related
     * @param selection number of selected test case
     */
    public static void testFindMaxValue(int selection) {
        switch (selection) {
            case 0:
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
            case 1:
                ///////////////////// Test find max profit with two transactions //////////////////////
                int prices[] = {2, 30, 15, 10, 8, 25, 80};
                float profit = FindMaxValue.maxProfitWithMaxTwoTransactions(prices);
                System.out.println("Maximum Profit = "+ profit);
            case 2:
                ///////////////////// Test find max product of three integers //////////////////////
                int[] inputInts = new int[] {-100, 100, 200, 9, 2};
                int maxProducts = FindMaxValue.findMaxProductsThreeInts(inputInts);
                System.out.println("maxProducts: " + maxProducts);
            case 3:
                int sellProfit;
                // Find max profit by selling flower bouquets
                sellProfit = FindMaxValue.findMaxProfitSellingBouquets(2, 3, "0001000");
                System.out.println("profit: " + sellProfit);
                sellProfit = FindMaxValue.findMaxProfitSellingBouquets(2, 3, "01");
                System.out.println("profit: " + sellProfit);

                sellProfit = FindMaxValue.findMaxProfitSellingBouquets(10, 7, "0");
                System.out.println("profit: " + sellProfit);

                sellProfit = FindMaxValue.findMaxProfitSellingBouquets(10, 7, "0011001100");
                System.out.println("profit: " + sellProfit);
        }


    }

    /**
     * Selection of test case for String construct related
     * @param selection number of selected test case
     */
    public static void testStringConstruct(int selection) {
        String[] substrings = {
                "B", "T", "A", "C", "MA", "N", "M", "I", "ATMA", "D"
        };
        String stringToBeConstructed = "BATMANC";
        switch (selection) {
            case 0:
                boolean canStringBeConstructed =
                    StringConstruct.isStringConstructableFromSubstrings(
                        stringToBeConstructed, Arrays.asList(substrings)
                    );
                System.out.println("canStringBeConstructed: " + canStringBeConstructed);
            case 1:
                boolean isConstructableRecursive = StringConstructDp.isConstructableByDictRecursive(
                        stringToBeConstructed, new ArrayList<>(Arrays.asList(substrings)));
                System.out.println("isConstructable: " + isConstructableRecursive);
            case 2:
                boolean isConstructableIterative = StringConstructDp.isConstructableByDictIterative(
                        stringToBeConstructed, new ArrayList<>(Arrays.asList(substrings)));
                System.out.println("isConstructable: " + isConstructableIterative);
        }

    }

    public static void testFindCombination() {
        // test find anagrams in dict
        String[] words = {"cat", "bac", "test", "act", "demon", "tset", "act", "tac"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        List<String> anagrams = FindCombination.findAnagramInDict(wordList);
        System.out.println("anagrams: " + anagrams);
    }

    /**
     * Selection of test case for Graph related
     * @param selection number of selected test case
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
                // find shortest path using dijkstra
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

                Path shortestPath = FindShortestPath.dijkstra(adjacencyMatrix, src, dest);
                System.out.println("shortestPath: " + shortestPath.getPath());
                System.out.println("shortestPath distance: " + shortestPath.getDistance());
            case 2:
                // find minimum distance in a 2D maze from start point to end point
                // using BFS
                int[][] mat  = {
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
                };
                Point srcPoint = new Point(0,0);
                Point destPoint = new Point(8, 9);
                int minDistance = FindShortestPath.bfs(mat, srcPoint, destPoint);
                System.out.println("minDistance: " + minDistance);
        }

    }

    public static void testOther() {
    }

    /**
     * Selection of test case for Tree related
     * @param selection number of selected test case
     */
    public static void testTree(int selection) {
        switch (selection) {
            case 0:
                BinaryTree<Integer> tree = new BinaryTree<>();
                tree.setRoot(1);
                tree.getRoot().setLeft(2);
                tree.getRoot().setRight(3);
                tree.getRoot().getLeft().setLeft(4);
                tree.getRoot().getLeft().setRight(1);
                tree.getRoot().getLeft().getLeft().setLeft(8);
                tree.getRoot().getLeft().getLeft().setRight(7);
                tree.getRoot().getLeft().getRight().setLeft(10);
                tree.getRoot().getLeft().getRight().setRight(12);

                System.out.println("Preorder traversal of binary tree is ");
                tree.printPreorder();

                System.out.println("\nInorder traversal of binary tree is ");
                tree.printInorder();

                System.out.println("\nPostorder traversal of binary tree is ");
                tree.printPostorder();

                Integer maxElement = (Integer) TreeTraversal
                            .getMaxElementInLevel(tree.getRoot(), 3);
                System.out.println("maxElement: " + maxElement);
        }
    }

    /**
     * Selection of test case for Math related
     * @param selection number of selected test case
     */
    public static void testMathRelated(int selection) {
        switch (selection) {
            case 0:
                // check if prime number
                for (int i = 1; i <= 1000; i++) {
                    if (MathRelated.isPrimeNumber(i))
                        System.out.println("Prime number: " + i);
                }
                break;
            case 1:
                // print Fibonacci series
                MathRelated.printFibonacciSeries(100);
                break;
        }
    }

    /**
     * Selection of test case for Codility problems
     * @param selection number of selected test case
     */
    public static void testCodility(int selection) {
        switch (selection) {
            case 0:
                Solution solution = new Solution();
                int[] A = {1, 3, 6, 4, 1, 2};
//                int[] A = {-1, -3};
//                int[] A = {1, 2, 3};
                solution.smallestPositiveIntegerNotOccurInArray(A);
        }
    }


    public static void main(String[] args) {
        testCodility(0);
    }

}
