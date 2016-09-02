package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/29/16.
 */
public class BurstBallons_312 {
    int[][] dp;
    int[] copy;
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        copy = new int[nums.length + 2];
        int index = 0;
        copy[index++] = 1;
        while(index < nums.length + 1) {
            copy[index] = nums[index++ - 1];
        }
        copy[index] = 1;
        dp = new int[copy.length][copy.length];

        return helper(1, copy.length - 2);
    }

    private int helper(int low, int high) {
        if (low > high) {
            return 0;
        }
        if (dp[low][high] > 0) {
            return dp[low][high];
        }
        int result = 0;
        for(int i = low; i <= high; i++) {
            int left = helper(low, i - 1),
                    right = helper(i + 1, high);
            result = Math.max(result, left + copy[low - 1] * copy[i] * copy[high + 1] + right);
        }
        dp[low][high] = result;
        return result;
    }
}
