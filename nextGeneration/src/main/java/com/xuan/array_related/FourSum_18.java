package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 6/24/16.
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int max = nums[nums.length -1];
        for(int i = 0; i < nums.length - 3; i++) {
            if (4 * nums[i] > target) {
                break;
            }
            if (nums[i]  + 3 * max < target) {
                continue;
            }
            if (i == 0 || nums[i] != nums[i-1]) {
                for(int j = i+1; j < nums.length -2; j++) {
                    if (nums[i] + 3 * nums[j] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + 2 * max < target) {
                        continue;
                    }
                    if (j == i+1 || nums[j] != nums[j-1]) {
                        int low = j + 1, high = nums.length -1;
                        while(low < high) {
                            int curr = nums[i] + nums[j] + nums[low] + nums[high];
                            if (curr == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while(low < high && nums[low] == nums[++low]);
                                while(high > low && nums[high] == nums[--high]);
                            }
                            else if (curr > target) {
                                high--;
                            }
                            else {
                                low++;
                            }

                        }
                    }

                }
            }
        }

        return result;
    }
}
