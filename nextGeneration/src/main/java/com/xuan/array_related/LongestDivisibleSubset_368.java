package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by xzhou2 on 9/20/16.
 */
public class LongestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] pre = new int[nums.length];
        int[] size = new int[nums.length];
        Arrays.fill(size, 1);
        int max = 0, end = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (size[j] >= size[i] && nums[i] % nums[j] == 0) {
                    size[i] = size[j] + 1;
                    pre[i] = j;
                }
            }
            if (size[i] > max) {
                max = size[i];
                end = i;
            }
        }

        Integer[] res = new Integer[max];
        for(int i = max - 1; i >= 0; i--) {
            res[i] = nums[end];
            end = pre[end];
        }

        return Arrays.asList(res);
    }
}
