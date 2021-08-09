package com.leet_code.greedy;
import java.util.*;
/**
 * You have an initial power of power, an initial score of 0, and a bag of tokens
 * where tokens[i] is the value of the ith token (0-indexed).
 *
 * Your goal is to maximize your total score by potentially playing each token in one of two ways:
 *
 * If your current power is at least tokens[i], you may play the ith token face up,
 * losing tokens[i] power and gaining 1 score.
 * If your current score is at least 1, you may play the ith token face down, gaining
 * tokens[i] power and losing 1 score.
 * Each token may be played at most once and in any order. You do not have to play all the tokens.
 *
 * Return the largest possible score you can achieve after playing any number of tokens.
 * https://leetcode.com/problems/bag-of-tokens/
 */
public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        if(tokens.length == 0) return 0;
        Arrays.sort(tokens);
        if (power < tokens[0]) return 0;

        power -= tokens[0];
        score++;

        int j = tokens.length-1;
        int i = 1;
        while(i < j) {
            if(power >= tokens[i]) {
                score++;
                power -= tokens[i];
                i++;
            } else {
                if( score >= 1) {
                    power += tokens[j];
                    score--;
                    j--;
                }
            }
        }
        if(i == j && power >= tokens[i]) score++;

        return score;
    }
}
