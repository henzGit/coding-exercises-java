package com.leet_code.array;
import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids) {
            if(stack.isEmpty()) stack.push(asteroid);
            else {
                if(stack.peek() < 0 && asteroid < 0) stack.push(asteroid);
                else if(stack.peek() < 0 && asteroid > 0) stack.push(asteroid);
                else if (stack.peek() > 0 && asteroid > 0) stack.push(asteroid);
                else if(stack.peek() > 0 && asteroid < 0) {
                    if(stack.peek() == Math.abs(asteroid)) stack.pop();
                    else if(stack.peek() > Math.abs(asteroid)) continue;
                    else {
                        while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                            stack.pop();
                        }
                        if(stack.isEmpty()) stack.push(asteroid);
                        else if(stack.peek() < 0) stack.push(asteroid);
                        else if(stack.peek() > 0) {
                            if(stack.peek() == Math.abs(asteroid)) stack.pop();
                        }
                    }
                }
            }
        }

        int[] out = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--) {
            out[i] = stack.pop();
        }

        return out;

    }
}
}
