package com;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Public utility class
 */
public class Utils {

    /**
     * Generate random integers for a given amount and upper limit
     * @param amountOfRandomNumber amount of random integer to be generated
     * @param upperLimit upper limit as the max value of the random integer
     * @return list of random integers
     */
    public static List<Integer> generateRandomIntegers(int amountOfRandomNumber, int upperLimit){
        List randomNumbers = new ArrayList();
        Random rand = new Random();

        for(int j=0; j<amountOfRandomNumber; j++){
            int randomNumber = rand.nextInt(upperLimit);
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

}

