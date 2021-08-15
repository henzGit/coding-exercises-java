package com.leet_code;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead be stored in the
 * input character array chars. Note that group lengths that are 10 or longer will be split
 * into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;

        char c = chars[0];
        int count = 1;
        int j = 1;

        for(int i = 1; i < chars.length; i ++) {
            if(chars[i] == c) {
                count++;
            } else {
                if(count > 1) {
                    for(char digit: String.valueOf(count).toCharArray())                     {
                        chars[j++] = digit;
                    }
                }
                chars[j++] = chars[i];
                count = 1;
                c = chars[i];

            }
        }
        if(count > 1) {
            for(char digit: String.valueOf(count).toCharArray()) {
                chars[j++] = digit;
            }
        }


        return j;
    }
}
