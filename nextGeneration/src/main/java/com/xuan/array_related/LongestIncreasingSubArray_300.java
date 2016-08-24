package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 8/23/16.
 */
public class LongestIncreasingSubArray_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] cache = new int[nums.length];
        Arrays.fill(cache, Integer.MAX_VALUE);
        int res = 0;
        for(int n : nums) {
            int index = Arrays.binarySearch(cache, n);
            if (index < 0) {
                int insert = -(index + 1);
                cache[insert] = n;
                res = Math.max(res, insert + 1);
            }
        }
        return res;
    }
}
