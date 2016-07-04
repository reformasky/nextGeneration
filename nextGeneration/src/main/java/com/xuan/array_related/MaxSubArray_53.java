package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/1/16.
 */
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int curr = 0, max = Integer.MIN_VALUE;
        for(int i : nums) {
            if (curr < 0) {
                curr = 0;
            }
            curr += i;
            if (max < 0 || i >= 0 )
                max = Math.max(max, curr);
        }
        return max;
    }
}
