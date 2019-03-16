package com;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Public utility class
 */
public class Utils {

    /**
     * Generate random numbers for a given amount and upper limit
     * @param amountOfRandomNumber amount of random number to be generated
     * @param upperLimit upper limit as the max value of the random number
     * @return list of random random numbers
     */
    public static List<Integer> generateRandomNumbers(int amountOfRandomNumber, int upperLimit){
        List randomNumbers = new ArrayList();
        Random rand = new Random();

        for(int j=0; j<amountOfRandomNumber; j++){
            int randomNumber = rand.nextInt(upperLimit);
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

}

