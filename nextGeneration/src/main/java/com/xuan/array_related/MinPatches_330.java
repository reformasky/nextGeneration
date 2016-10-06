package com.xuan.array_related;

/**
 * Created by xzhou2 on 9/2/16.
 */
public class MinPatches_330 {
    public int minPatches(int[] nums, int n) {
        int count = 0, index = 0;
        long sum = 0;
        while(sum < n) {
            if (index >= nums.length || nums[index] > sum + 1) {
                sum *= 2;
                sum += 1;
                count++;
            } else {
                sum += nums[index++];
            }
        }
        return count;
    }
}
