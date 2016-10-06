package com.xuan.array_related;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 9/12/16.
 */
public class IntersectionOfTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums1) {
            if (!counts.containsKey(num)) { counts.put(num, 1);}
            else { counts.put(num, counts.get(num) + 1);}
        }
        List<Integer> result = new ArrayList<>();
        for(int num : nums2) {
            if (counts.containsKey(num)) {
                result.add(num);
                int count = counts.get(num);
                if (count <= 1) {
                    counts.remove(num);
                } else {
                    counts.put(num, count - 1);
                }
            }
        }
        int[] res = new int[result.size()];
        int index = 0;
        for(int i : result) {
            res[index++] = i;
        }
        return res;
    }
}
