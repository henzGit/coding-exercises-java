package com.leet_code.dynamic_programming;
import java.util.*;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> pre  = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) cur.add(1);
                else {
                    cur.add(pre.get(j) + pre.get(j-1));
                }

            }
            pre = cur;
            out.add(cur);
        }

        return out;
    }
}
