package com.hacker_rank;

public class HRSolution {

    /**
     * Function to get sum of all digits in an integer
     * @param I input integer
     * @return sum of all digits from input integer
     */
    public static int sumAllDigitsInteger(int I) {
        int sum = 0;
        for (char ch: Integer.toString(I).toCharArray()) {
            sum += Character.getNumericValue(ch);
        }
        return sum;
    }
}
