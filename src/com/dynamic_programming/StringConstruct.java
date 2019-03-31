package com.dynamic_programming;

import java.util.*;

public class StringConstruct {

    /**
     * Check if string can be constructed from subtrings
     * @param targetString string to be constructed
     * @param substrings components to construct the string
     * @return true if string is constructable from substrings, otherwise false
     */
    public static boolean isStringConstructableFromSubstrings(
            String targetString, List<String> substrings
    ) {
        // map usage of input substrings
        Map<Integer, Map<String, Integer>> inSubstrMap =
                mapUsageStrings(substrings);

        List<Integer> inSubstrMapKeys = new ArrayList<>(inSubstrMap.keySet());

        // find possible indices combination based on length of
        // input substrings
        List<List<Integer>> indicesList = findCombinationIndices(
                targetString.length(), inSubstrMapKeys
        );

        // check possible substrings from indices list
        for (List<Integer> indices: indicesList) {
            int beginIndex, endIndex = 0;
            List<String> indicesSubstrList = new ArrayList<>();
            // create list of substrings
            for(int i = 0; i < indices.size(); i++) {
                String substrFromIndices = "";
                // for first index
                if (i == 0) {
                    beginIndex = 0;
                    endIndex = indices.get(i);
                } else {
                    // move pointer of begin index of last iteration
                    beginIndex = endIndex;
                    endIndex = beginIndex + indices.get(i);
                }
                // get substring from begin index and end index
                substrFromIndices = targetString.substring(beginIndex, endIndex);
                // add to list of substrings
                indicesSubstrList.add(substrFromIndices);
            }
            Map<Integer, Map<String, Integer>> tmpSubstrMap
                    = mapUsageStrings(indicesSubstrList);

            // check if tmpSubstrMap is a subset of inSubstrMap
            if (isSubsetOf(tmpSubstrMap, inSubstrMap)) { return true; }
        }

        return false;
    }

    /**
     * Function to check if component map is a subset of container map
     * @param componentMap component map which can be included into container map
     * @param containerMap container map which include component map
     * @return true if component map is a subset, otherwise false
     */
    private static boolean isSubsetOf(
            Map<Integer, Map<String, Integer>> componentMap,
            Map<Integer, Map<String, Integer>> containerMap
    ) {
        Set<Integer> componentMapKeys = componentMap.keySet();
        Set<Integer> containerMapKeys = containerMap.keySet();

        // keys of component map have to be in container map
        if (!containerMapKeys.containsAll(componentMapKeys)) {
            System.out.println("containerMapKeys does not contain componentMapKeys");
            return false;
        }

        for (int componentMapKey: componentMapKeys) {
            Map<String, Integer> componentMapContent = componentMap.get(componentMapKey);
            // we can use component map key for container map since
            // at this point it is confirmed that component map key set is a subset of
            // container map key set
            Map<String, Integer> containerMapContent = containerMap.get(componentMapKey);

            // two conditions that can make component entry set is not a subset of
            // container entry set
            // 1) if one of the keys in component is not present in container
            // 2) value of the key in component > value of the key in container
            for (String keyComponent: componentMapContent.keySet()) {
                // 1st condition, check if key in component exists in container
                if (!containerMapContent.containsKey(keyComponent)) {
                    return false;
                }
                // 2nd condition, check if value of key in component is smaller
                // than key in container
                if (componentMapContent.get(keyComponent)
                                > containerMapContent.get(keyComponent)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * initialize map to store all combinations of substrings
     * in the form of
     * map[1] = {"a": 1, "b": 2}
     * map[2] = {"ab": 1, "bc": 3,}
     * map[4] = {"abcd": 3, "rwee": 5}
     * @param inStrings list of input substrings
     * @return map with given structure
     */
    private static Map<Integer, Map<String, Integer>> mapUsageStrings(
            List<String> inStrings
    ) {
        Map<Integer, Map<String, Integer>> outerMap =
                new TreeMap<>(Collections.reverseOrder());

        for (String subString: inStrings) {
            int outerMapKey = subString.length();
            if (!outerMap.containsKey(outerMapKey)) {
                Map<String, Integer> internalMap = new TreeMap<>();
                internalMap.put(subString, 1);
                outerMap.put(outerMapKey, internalMap);
            } else {
                Map<String, Integer> internalMap = outerMap.get(outerMapKey);
                if (!internalMap.containsKey(subString)) {
                    internalMap.put(subString, 1);
                } else {
                    int subStrCount = internalMap.get(subString);
                    internalMap.put(subString, subStrCount+1);
                }
            }
        }
        return outerMap;
    }

    /**
     * Get combination of indices using Tree BFS
     * Example:
     * targetLength = 10,
     * possibleLengths = [1, 2, 5]
     * outputList = [[5, 5], [1, 2, 2, 5]]
     * @param targetLength target length to be achieved
     * @param possibleLengths possible length from which target length
     *                        needs to be constructed.
     *                        This value has to be < targetLength
     * @return list containing possible indices combination
     */
    private static List<List<Integer>> findCombinationIndices(
            int targetLength, List<Integer> possibleLengths
    ) {
        List<List<Integer>> returnList = new ArrayList<>();

        LinkedList<List<Integer>> queue = new LinkedList<>();
        // initialize queue with empty list
        queue.add(new ArrayList<>());

        while(!queue.isEmpty()) {
            List<Integer> currIndices = queue.pop();
            int sumCurrIndices = currIndices.stream()
                                        .mapToInt(Integer::intValue)
                                        .sum();
            for (Integer length: possibleLengths) {
                int nextSum = sumCurrIndices + length;
                // initialize next indices with a new list object
                List<Integer> nextIndices = new ArrayList<>(currIndices);

                // add to return list if next sum of indices is equal to target length
                if (nextSum == targetLength) {
                    nextIndices.add(length);
                    returnList.add(nextIndices);
                    continue;
                }
                // add to queue if next sum of indices is lower than target length
                if (nextSum < targetLength) {
                    nextIndices.add(length);
                    queue.add(nextIndices);
               }
            }
        }
        return returnList;
    }

    /**
     * Check if input can be constructed using words in dictionary
     * @param input input to be constructed
     * @param dict dictionary of words
     * @return true if input string can be constructed from words in dictionary
     *          , otherwise false
     */
    public static boolean isConstructableByDict(String input, List<String> dict) {
        int size = input.length();
        // base case
        if ( size == 0) return true;
        for (int i = 0; i < size; i++) {
            if (
                    dict.contains(input.substring(0, i)) &&
                            isStringConstructableFromSubstrings(input.substring(i, size), dict)

            ) {
                return true;
            }
        }
        return false;

    }

}
