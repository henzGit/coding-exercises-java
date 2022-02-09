package com.leet_code.string;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will
 * be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as
 * mathematical expressions, such as eval().
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        Character op = null;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int tmpVal = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    tmpVal = tmpVal * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }

                int val = 0;
                if (op == null || op == '+') {
                    val = tmpVal;
                } else if (op == '-') {
                    val = -tmpVal;
                } else if (op == '*') {
                    val = stack.pop() * tmpVal;
                } else if (op == '/') {
                    val = stack.pop() / tmpVal;
                }
                stack.push(val);
            } else {
                if (c != ' ') {
                    op = c;
                }
                i++;
            }
        }


        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}
