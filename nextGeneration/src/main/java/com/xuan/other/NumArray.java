package com.xuan.other;

/**
 * Created by xzhou2 on 8/23/16.
 */
public class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
