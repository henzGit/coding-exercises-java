package com.leet_code.string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * You are given a string s that consists of lower case English letters and brackets.
 *
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 *
 * Your result should not contain any brackets.
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            int c = charArr[i];
            if(c == '(') {
                stack.push(i);
            } else if (c == ')') {
                reverseString(stack.pop(), i, charArr);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: charArr) {
            if(c != '(' && c != ')') {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    private void reverseString(int a, int b, char[] charInput) {
        int l = a;
        int h = b;
        while(l <= h) {
            char c = charInput[l];
            charInput[l] = charInput[h];
            charInput[h] = c;
            l++;
            h--;
        }

    }
}
