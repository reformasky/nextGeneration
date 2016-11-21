package com.xuan.array_related;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 10/16/16.
 */
public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int m) {
        long max = -1, sum = 0;
        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        return binarySearch(nums, max, sum, m);
    }

    private int binarySearch(int[] nums, long low, long high, int m) {
        while(low < high) {
            long mid = (low + high) / 2;
            if (isValid(nums, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }

    private boolean isValid(int[] nums, long target, int m) {
        long sum = 0;
        int count = 1;
        for(int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public int splitArray_dp(int[] nums, int m) {
        int[] dp = new int[nums.length];

        for(int i = nums.length-1; i>=0; i--)
            dp[i] = i== nums.length -1 ? nums[i] : dp[i+1] + nums[i];
        for(int im = 2; im <= m; im ++) {
            int maxPart = nums.length + 1 - im;
            for(int i=0; i<maxPart; i++) {
                dp[i] = Integer.MAX_VALUE;
                int leftSum = 0;
                for(int p=i; p<maxPart; p++) {
                    leftSum += nums[p];
                    if(leftSum > dp[i])
                        break;  // There's no more better soluiton, stop the search.
                    int val = Math.max(leftSum, dp[p+1]);
                    if(val < dp[i])
                        dp[i] = val;
                }
                if(im == m)  // The last round, get first one is enough
                    break;
            }
        }
        return dp[0];
    }
}
