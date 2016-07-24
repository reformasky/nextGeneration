package com.xuan.array_related;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 7/20/16.
 */
public class LongestConsecutive_128 {

    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for(int n : nums) {
            set.add(n);
        }
        for(int n : nums) {
            if (set.contains(n -1)) {
                continue;
            }
            int m = n + 1;
            while(set.contains(m)) {
                m++;
            }
            result = Math.max(m - n, result);
        }
        return result;
    }

    List<String>[][] cache = (List<String>[][])(new List[1][1]);


    public int longestConsecutive_AON(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> region = new HashMap<>();
        for(int n : nums) {
            if (! region.containsKey(n)) {
                int left = n, right = n;
                if (region.containsKey(n-1)) {
                    left = n - region.get(n-1);
                }
                if (region.containsKey(n+1)) {
                    right = n +  region.get(n+1);
                }
                int curr = right - left + 1;
                region.put(left, curr);
                region.put(right, curr);
                region.put(n, curr);
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
