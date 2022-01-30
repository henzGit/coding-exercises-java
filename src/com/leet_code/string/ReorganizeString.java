package com.leet_code.string;
import java.util.*;
/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 * https://leetcode.com/problems/reorganize-string/
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char last = s.charAt(0);
        sb.append(last);

        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == last) {
                stack.add(c);
            } else {
                sb.append(c);
                last = c;
                if(!stack.empty()) {
                    char c2 = stack.pop();
                    sb.append(c2);
                    last = c2;
                }
            }
        }

        if(!stack.empty() && stack.peek() != last) sb.append(stack.pop());
        if(!stack.empty() && stack.peek() != sb.charAt(0)) sb.insert(0, stack.pop());
        if(!stack.empty()) {
            for(int i = 2; i < sb.length(); i++) {
                char c = stack.peek();
                if(sb.charAt(i-1) != c && sb.charAt(i) != c) {
                    sb.insert(i, stack.pop());
                    if(stack.empty()) break;
                }
            }
        }

        if(stack.size() > 0) return "";
        return sb.toString();
    }
}
