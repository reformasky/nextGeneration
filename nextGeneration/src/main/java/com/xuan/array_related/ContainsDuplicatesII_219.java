package com.xuan.array_related;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 8/4/16.
 */
public class ContainsDuplicatesII_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        for(int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


    public boolean containsNearbyDuplicate_map(int[] nums, int k) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numToIndex.containsKey(num)) {
                if (numToIndex.get(num) >= i - k) {
                    return true;
                }
            }
            numToIndex.put(num, i);
        }
        return false;
    }
}
