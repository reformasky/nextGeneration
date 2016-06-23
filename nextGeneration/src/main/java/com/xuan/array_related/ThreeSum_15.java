package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 6/22/16.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int curr;
        for(int i = 0; i < nums.length - 2;) {
            for(int j = i + 1; j < nums.length - 1;) {
                int index = Arrays.binarySearch(nums, j + 1, nums.length, -nums[i] - nums[j]);
                if (index > j) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[index])));
                }
                curr = nums[j];
                while(j < nums.length - 1 && nums[++j] == curr);
            }
            curr = nums[i];
            while(i < nums.length - 2 && nums[++i]== curr);
        }
        return result;
    }
}
