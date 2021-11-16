package com.leet_code.data_structure;
import java.util.*;

public class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int last = list.get(list.size() - 1);
        int valIndex = map.get(val);

        list.set(valIndex, last);
        list.remove(list.size() - 1);
        map.put(last, valIndex);
        map.remove(val);

        return true;

    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
