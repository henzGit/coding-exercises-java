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

}
