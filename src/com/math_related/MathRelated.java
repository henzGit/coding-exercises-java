package com.math_related;

/**
 * Public class about various math-related algorithms and problems
 */
public class MathRelated {

    /**
     * Check if a number is a prime nubmer
     * @param num number to be checked
     * @return true if num is prime number, else false
     */
    public static boolean isPrimeNumber(int num) {
        // base of prime number
        if ( num == 1 || num == 2) return true;

        for (int i = 2; i < num ; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * Function to print Fibonacci series
     * @param n input of fibonacci series
     */
    public static void printFibonacciSeries(int n) {

        long n1 = 1, n2 = 1, n3;
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                System.out.println("f(" + i + "): " + 1);
                continue;
            }

            n3 = n1 + n2;
            System.out.println("f(" + i + "): " + n3);
            n1 = n2;
            n2 = n3;
        }
    }

}
