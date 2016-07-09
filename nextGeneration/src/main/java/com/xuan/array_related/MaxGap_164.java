package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class MaxGap_164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num : nums) {
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        int bucketSize = (max - min) / nums.length + 1;
        int[] mins = new int[nums.length],
                maxs = new int[nums.length];
        boolean[] valid = new boolean[nums.length];
        Arrays.fill(mins, max);
        Arrays.fill(maxs, min);
        for(int num : nums) {
            int index = (num - min) / bucketSize;
            mins[index] = Math.min(mins[index], num);
            maxs[index] = Math.max(maxs[index], num);
            valid[index] = true;
        }
        int result = maxs[0] - mins[0], last = 0;
        for(int i = 1; i < nums.length; i++) {
            if (valid[i]) {
                result = Math.max(result, maxs[i] - mins[i]);
                result = Math.max(result, mins[i] - maxs[last]);
                last = i;
            }
        }
        return result;
    }
}
