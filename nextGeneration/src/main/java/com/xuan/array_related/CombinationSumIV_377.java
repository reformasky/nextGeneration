package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 9/29/16.
 */
public class CombinationSumIV_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        cache[0] = 1;
        Arrays.sort(nums);
        for(int i = 1; i <= target; i++) {
            int curr = 0;
            for(int n : nums) {
                if (n <= i) {
                    curr += cache[i - n];
                } else {
                    break;
                }
            }
            cache[i] = curr;
        }
        return cache[target];
    }
}
