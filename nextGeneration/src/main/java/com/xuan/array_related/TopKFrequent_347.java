package com.xuan.array_related;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class TopKFrequent_347 {
    /*public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int[] counts = new int[map.size()];
        int index = 0;
        for(int key : map.keySet()) {
            counts[index++] = map.get(key);
        }

        int value = topK(counts, 0, counts.length - 1, k - 1);
        List<Integer> larger = new ArrayList<>(k),
                equal = new ArrayList<>();

        for(int key : map.keySet()) {
            int v = map.get(key);
            if (v > value) {larger.add(key);}
            else if (v == value) {equal.add(key);}
        }
        index = 0;
        while(larger.size() < k) {
            larger.add(equal.get(index++));
        }
        return larger;
    }*/


    public int topK(int[] counts, int low, int high, int k) {
        if (low == high) {return counts[low];}
        int l = low, h = high + 1;
        while(true) {
            while(l < high && counts[++l] >= counts[low]);
            while(h > low && counts[--h] <= counts[low]);
            if (l < h) {
                int tmp = counts[l];
                counts[l] = counts[h];
                counts[h] = tmp;
            } else {
                break;
            }
        }
        int tmp = counts[low];
        counts[low] = counts[h];
        counts[h] = tmp;
        if (h == k) { return counts[h];}
        else if (h > k) {return topK(counts, low, h - 1, k);}
        else { return topK(counts, h + 1, high, k);}
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Integer>[] buckets = (List<Integer>[])new List[nums.length + 1];
        for(int key : map.keySet()) {
            int value = map.get(key);
            if (buckets[value] == null) {buckets[value] = new ArrayList<>();}
            buckets[value].add(key);
        }
        List<Integer> result = new ArrayList<>(k);
        for(int i = nums.length; i > 0; i--) {
            List<Integer> curr = buckets[i];
            if (curr != null) {
                for(int j = 0; j < curr.size(); j++) {
                    if (result.size() < k) {
                        result.add(curr.get(j));
                    } else {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
