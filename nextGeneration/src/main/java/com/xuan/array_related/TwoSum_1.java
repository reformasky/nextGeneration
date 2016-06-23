package com.xuan.array_related;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 6/16/16.
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                if (i != index) {
                    return new int[]{i, index};
                }
            }
        }
        return null;
    }
}
