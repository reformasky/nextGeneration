package com.xuan.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by xzhou2 on 9/29/16.
 */
public class RandomizedSet {
    private Node[] nodeArr;
    private Map<Integer, Node> nodeMap;
    private int size, len, index;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nodeArr = new Node[16];
        nodeMap = new HashMap<>();
        size = 0;
        len = 16;
        index = 0;
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (nodeMap.containsKey(val)) {
            return false;
        }
        if (index >= len) {
            rebalance(len * 2);
        }
        Node curr = new Node(val);
        nodeArr[index++] = curr;
        nodeMap.put(val, curr);
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!nodeMap.containsKey(val)) {
            return false;
        }
        Node n = nodeMap.get(val);
        nodeMap.remove(val);
        n.valid = false;
        size--;
        if (size < len / 4) {
            rebalance(len/4);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (size < 1) {
            throw new IllegalStateException();
        }
        while(true) {
            int i = random.nextInt(index);
            if (nodeArr[i].valid) {
                return nodeArr[i].val;
            }
        }
    }

    private void rebalance(int len) {
        this.len = len;
        Node[] tmp = new Node[len];
        index = 0;
        for(Node n : nodeArr) {
            if (n != null && n.valid) {
                tmp[index++] = n;
            }
        }
        nodeArr = tmp;
    }

    class Node {
        int val;
        boolean valid;
        public Node(int val) {
            this.val = val;
            valid = true;
        }
    }
}


//
/**
  public class RandomizedSet {
 //val : indexOfList
 private Map<Integer, Integer> map;
 private List<Integer> list;
 private Random random;

 public RandomizedSet() {
 map = new HashMap<>();
 list = new ArrayList<>(64);
 random = new Random();
 }

 public boolean insert(int val) {
 if (map.containsKey(val)) {
 return false;
 }
 int index = list.size();
 map.put(val, index);
 list.add(val);
 return true;
 }

 public boolean remove(int val) {
 if (!map.containsKey(val)) {
 return false;
 }

 int index = map.get(val), lastVal = list.get(list.size() - 1);
 if (index != list.size() - 1) {
 list.set(index, lastVal);
 map.put(lastVal, index);
 }
 list.remove(list.size() - 1);
 map.remove(val);
 return true;
 }

 public int getRandom() {
 int size = list.size();
 return list.get(random.nextInt(size));
 }
 }
 *
 *
 *
 *
 * */