package com.leet_code.dynamic_programming;

import java.util.HashMap;

public class CanIWin {
    private int getKey(boolean[] arr) {
        int key = 0;
        for(boolean b: arr) {
            key = key<<1;
            if(b) {
                key |= 1;
            }
        }
        return key;
    }
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger +1)/2;
        if(sum < desiredTotal) return false;
        if(maxChoosableInteger >= desiredTotal) return true;
        boolean[] state = new boolean[maxChoosableInteger+1];
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return canIWinRec(desiredTotal, state, memo);
    }

    private boolean canIWinRec(int desiredTotal, boolean[] state, HashMap<Integer,Boolean> memo) {
        if(desiredTotal <= 0) return false;
        int key = getKey(state);
        if(!memo.containsKey(key)) {
            for(int i = 1; i<state.length; i++) {
                if(!state[i]) {
                    state[i] = true;
                    if(!canIWinRec(desiredTotal - i, state, memo)) {
                        state[i] = false;
                        memo.put(key, true);
                        return true;
                    }
                    state[i] = false;
                }
            }
            memo.put(key, false);
        }
        return memo.get(key);
    }
}
