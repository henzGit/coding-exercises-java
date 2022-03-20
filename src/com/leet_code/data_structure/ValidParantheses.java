package com.leet_code.data_structure;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * https://leetcode.com/problems/valid-parentheses/
 *
 */
public class ValidParantheses {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(st.isEmpty()) st.add(c);
            else if(c == '(' || c == '{' || c == '[') {
                st.add(c);
            }

            else {
                char c2 = st.pop();
                if(c2 == ')' || c2 == '}' || c2 == ']') return false;

                if(c2 == '(' && c != ')') return false;
                else if(c2 == '[' && c != ']') return false;
                else if(c2 == '{' && c != '}') return false;
            }
        }
        return st.size() == 0 ? true : false;
    }
}
