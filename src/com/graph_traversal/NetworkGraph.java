package com.graph;

import java.util.*;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class NetworkGraph {

    /**
     * Find sub-clusters size for each network cluster
     * In a cluster, it is possible to have one or more subcluster
     * @param inputFilePath input file path containing the distribution of nodes
     *                      in a cluster.
     *                      For each cluster which is separated by a blank line
     *                      The first row contains the number of node(s) in the cluster
     *                      The second row contains the number of link(s) between nodes
     *                      The third row onwards contains each link between node
     *                      Ex: 5
     *                          3
     *                          1 2
     *                          3 4
     *                          3 5
     * @param outputFilePath output file path where the result is located
     * @return the output file path containing each sub-cluster size
     *          Output format:
     *          Case #1: 3 2 -> this means there are two sub-clusters with 3 and 2 nodes
     *                          respectively
     *          Case #2: 1 1 1 1 1 1 -> this means each node is their own sub-cluster
     */
    public static String findSubclustersSize(String inputFilePath, String outputFilePath) {
        // create test cases
        Map<Integer, TestCase> testCases = readDataFromInputFile(inputFilePath);

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(outputFilePath))) {
            for (int testCaseNum: testCases.keySet()) {
                TestCase testCase = testCases.get(testCaseNum);
                String currOutStr = getOutputStrFromTestCase(testCase);
                printWriter.println(currOutStr);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        return outputFilePath;
    }

    /**
     * Create graph from list of two nodes connections
     * @param nodesNum number of total nodes
     * @param conns list of two-nodes connections
     * @return graph with the format
     *          {
     *              1: (2,3)
     *              2: (4,5)
     *          }
     */
    public static Map<Integer, Set<Integer>> createGraphFromConnections(int nodesNum, List<int[]> conns) {
        Map<Integer, Set<Integer>> returnedGraph = new TreeMap<>(); // graph for each test case

        // create graph based on previous result
        for (int i = 0; i < conns.size() ; i++) {
            int[] currConn = conns.get(i);
            // check first node
            if (!returnedGraph.containsKey(currConn[0])) {
                returnedGraph.put(
                        currConn[0],
                        new TreeSet<>(Arrays.asList(currConn[1])));
            } else {
                Set<Integer> currList = returnedGraph.get(currConn[0]);
                currList.add(currConn[1]);
            }
            // check second node
            if (!returnedGraph.containsKey(currConn[1])) {
                returnedGraph.put(
                        currConn[1],
                        new TreeSet<>(Arrays.asList(currConn[0])));
            } else {
                Set<Integer> currList = returnedGraph.get(currConn[1]);
                currList.add(currConn[0]);
            }
        }
        // add nodes which do not have any connection into graph info
        for (int currNodeNum = 1; currNodeNum <= nodesNum; currNodeNum++) {
            if (!returnedGraph.containsKey(currNodeNum)) {
                returnedGraph.put(currNodeNum, new HashSet<>(Arrays.asList(currNodeNum)));
            }
        }

        return returnedGraph;
    }

    /**
     * Return output string for a given test case
     * @param testCase TestCase object given as an input
     * @return output string with the format
     *          Case #1: 3 2
     *          Case #2: 2 2 1
     *          Case #3: 1 1 1 1 1 1
     *          Case #4: 2 1
     */
    public static String getOutputStrFromTestCase(TestCase testCase) {
        List<Integer> clusterSizes;

        int testNum = testCase.getTestNum();
        int nodesNum = testCase.getNodesNum();
        List<int[]> conns = testCase.getConns();

        if (conns.size() > 0) {
            // create graph from list of connections
            Map<Integer, Set<Integer>> currGraph = createGraphFromConnections(nodesNum, conns);

            // find cluster sizes from graph
            clusterSizes = calculateClusterSizesFromGraph(currGraph);

        } else {
            // for no connection
            clusterSizes = new ArrayList<>(Collections.nCopies(nodesNum, 1));
        }
        // format string
        String clusterSizesStr = clusterSizes
                .toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        String outStr = String.format("Case #%d: %s", testNum, clusterSizesStr);

        return outStr;
    }

    /**
     * Calculate cluster sizes from input graph
     * @param inputGraph graph with the format
     *                  {
     *                    1: (2,3)
     *                    2: (4,5)
     *                  }
     * @return list of cluster size
     */
    private static List<Integer> calculateClusterSizesFromGraph(Map<Integer, Set<Integer>> inputGraph) {
        List<Integer> clusterSizes = new ArrayList<>();

        // connected components in clusters
        List<Set<Integer>> nodesClusters = new ArrayList<>();
        Set<Integer> visitedKeys = new HashSet<>();

        // Find cluster of nodes in graph using BFS
        for (int currKey: inputGraph.keySet()) {
            if (visitedKeys.contains(currKey)) continue;

            // init queue
            List<Integer> queue = new ArrayList<>(Arrays.asList(currKey));
            Set<Integer> clusteredNodes = new HashSet<>();

            // Do BFS using queue
            while(queue.size() > 0) {
                int currNode = queue.remove(0);
                if (!clusteredNodes.contains(currNode)) {
                    clusteredNodes.add(currNode); // add current node to the clustered nodes

                    // get the list of connected nodes with the current node
                    Set<Integer> connectedNodes = inputGraph.get(currNode);
                    // mark current node as already visited key
                    visitedKeys.add(currNode);
                    for (int connectedNode : connectedNodes) {
                        queue.add(connectedNode);
                    }

                }

            }
            nodesClusters.add(clusteredNodes);
        }

        // calculate cluster size from clustered nodes
        for (Set<Integer> nodesCluster :nodesClusters) {
            clusterSizes.add(nodesCluster.size());
        }
        // sort set
        Collections.sort(clusterSizes, Collections.reverseOrder());

        return clusterSizes;
    }

    /**
     * inner static class to store information about test case
     */
    public static class TestCase {
        private int testNum; // test number
        private int nodesNum; // number of nodes
        private int connsNum; // number of connections
        private List<int[]> conns; // list of connections

        public TestCase(int testNum, int nodesNum, int connsNum, List<int[]> conns) {
            this.testNum = testNum;
            this.nodesNum = nodesNum;
            this.connsNum = connsNum;
            this.conns = conns;
        }

        public int getTestNum() {
            return testNum;
        }


        public int getNodesNum() {
            return nodesNum;
        }

        public int getConnsNum() {
            return connsNum;
        }

        public List<int[]> getConns() {
            return conns;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                    "nodesNum=" + nodesNum +
                    ", connsNum=" + connsNum +
                    ", conns=" + conns +
                    '}';
        }
    }

    /**
     * Read data from input file path
     * @param inputFilePath input file path containing the distribution of nodes
     *                      in a cluster.
     * @return data in the form of linked hash map
     *          Output format:
     *          [1] -> {"nodesNum": 9, "connsNum": 5, "conns": [[1,2], [2,2]]}
     */
    public static Map<Integer, TestCase> readDataFromInputFile(String inputFilePath) {
        Map<Integer, TestCase> returnedData = new LinkedHashMap<>();

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath));

            // get number of test cases from first line
            String line = reader.readLine();
            int testNum = Integer.parseInt(line);

            int currTestNum = -1;
            int nodesNum = 0;
            int connsNum = 0;
            int internalCounter = 0; // line counter for each test case
            List<int[]> conns = new ArrayList<>(); // list of connections for each test case

            while( (line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    // increase test number
                    currTestNum++;

                    // assign values to new TestCase object
                    if (currTestNum >= 1 & nodesNum != 0) {
                        TestCase testCase = new TestCase(currTestNum, nodesNum, connsNum, conns);
                        returnedData.put(currTestNum, testCase);
                    }

                    // reset values
                    nodesNum = 0;
                    connsNum = 0;
                    internalCounter = 0;
                    conns = new ArrayList<>();
                    continue;
                }

                // parse information from line
                if (internalCounter == 0) {
                    nodesNum = Integer.parseInt(line);
                } else if (internalCounter == 1) {
                    connsNum = Integer.parseInt(line);
                } else if (internalCounter >= 2) {
                    int node1 = Integer.parseInt(line.split(" ")[0]);
                    int node2 = Integer.parseInt(line.split(" ")[1]);
                    conns.add(new int[]{node1, node2});
                }
                internalCounter++;
            }

            // add last test case
            currTestNum++;
            TestCase testCase = new TestCase(currTestNum, nodesNum, connsNum, conns);
            returnedData.put(currTestNum, testCase);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnedData;
    }

}


