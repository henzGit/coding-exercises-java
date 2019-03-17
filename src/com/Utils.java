package com;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Public utility class
 */
public class Utils {

    /**
     * Generate random integers for a given amount and upper limit
     * @param amountOfRandomInteger amount of random integer to be generated
     * @param upperLimit upper limit as the max value of the random integer
     * @return list of random integers
     */
    public static List<Integer> generateRandomIntegers(int amountOfRandomInteger, int upperLimit){
        List<Integer> randomIntegers = new ArrayList<>();
        Random rand = new Random();

        for(int j = 0; j < amountOfRandomInteger; j++){
            int randomInteger = rand.nextInt(upperLimit);
            randomIntegers.add(randomInteger);
        }

        return randomIntegers;
    }

    /**
     * Generate random floats for a given amount
     * @param amountOfRandomFloats amount of random float to be generated
     * @param multiplier multiplier for the generated float value
     * @return list of random floats
     */
    public static List<Float> generateRandomFloats(int amountOfRandomFloats, int multiplier){
        List<Float> randomFloats = new ArrayList<>();
        Random rand = new Random();

        for(int j = 0; j < amountOfRandomFloats; j++){
            float randomFloat = multiplier * rand.nextFloat();
            randomFloats.add(randomFloat);
        }

        return randomFloats;
    }

    /**
     * Generate a series of LocalDateTime in ascending order in hours
     * @param numberPoints number of points in the list
     * @return list containing LocalDateTime object
     */
    public static List<LocalDateTime> generateDateTimes(int numberPoints) {
        LocalDateTime now = LocalDateTime.now();
        List<LocalDateTime> times = new LinkedList<>();
        int i = 0;
        while (i < numberPoints) {
            times.add(now.plusHours(i));
            i++;
        }
        return times;
    }

}

