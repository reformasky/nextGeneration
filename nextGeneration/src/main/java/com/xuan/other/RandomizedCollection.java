package com.xuan.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by xzhou2 on 10/2/16.
 */
public class RandomizedCollection {
    private Map<Integer, Queue<Integer>> map;
    private List<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        Queue<Integer> curr;
        if (!map.containsKey(val)) {
            result = true;
            curr = new PriorityQueue<>((p, q) ->(q - p));
            map.put(val, curr);
        } else {
            curr = map.get(val);
        }
        int index = list.size();
        curr.offer(index);
        list.add(val);
        System.out.println(val + "(insert):" + curr.size() + "  " + list.size());
        return result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Queue<Integer> curr = map.get(val);
        int currIndex = curr.poll();
        int lastVal = list.get(list.size() - 1);
        if (lastVal != val) {
            Queue<Integer> lastQueue = map.get(lastVal);
            lastQueue.poll();
            lastQueue.offer(currIndex);
            list.set(currIndex, lastVal);
        }
        list.remove(list.size() - 1);
        if (curr.isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int size = list.size();
        return list.get(random.nextInt(size));
    }
}