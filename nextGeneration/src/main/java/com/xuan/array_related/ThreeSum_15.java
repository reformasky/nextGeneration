package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 6/22/16.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum_binarySearch(int[] nums) {
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
    public List<List<Integer>> threeSum_map(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int curr;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }


        for(int i = 0; i < nums.length - 2;) {
            for(int j = i + 1; j < nums.length - 1;) {
                int third = -nums[i]-nums[j];
                Integer count = map.get(third);
                if (count != null) {
                    if (third == nums[i]) {
                        if (count >= 3) {
                            result.add(Arrays.asList(third, third, third));
                        }
                    }
                    else if (third == nums[j]) {
                        if (count >= 2) {
                            result.add(Arrays.asList(nums[i], third, third));
                        }
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], third));
                    }
                }
                curr = nums[j];
                while(j < nums.length - 1 && nums[++j] == curr);
            }
            curr = nums[i];
            while(i < nums.length - 2 && nums[++i]== curr);
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i-1])) {
                int low = i + 1, high = nums.length - 1;
                int target = -nums[i];
                while(low < high) {
                    if (nums[low] + nums[high] == target) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low + 1] == nums[low])low++;
                        while(high > low && nums[high - 1] == nums[high]) high--;
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] > target) {
                        high--;
                    }
                    else {
                        low++;
                    }
                }
            }
        }
        return result;
    }

}
