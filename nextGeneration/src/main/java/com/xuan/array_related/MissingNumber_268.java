package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/15/16.
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        long sum = 0;
        for(int n : nums) {
            sum += n;
        }
        return (int)(nums.length * (nums.length + 1) / 2 - sum);
    }
}
