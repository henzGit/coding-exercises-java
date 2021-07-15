package com.leet_code;
import java.util.*;

/**
 * Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses
 * ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add
 * to make the resulting string valid.
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class MinimumAddToMakeParentheses {
    public int minAddToMakeValid(String s) {
        if (s == "") return 0;

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if ( c == '(' ) stack.push(c);
            else {
                if (stack.size() > 0 && stack.peek() == '(') stack.pop();
                else count++;
            }
        }
        count += stack.size();
        return count;
    }
}
