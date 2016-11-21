package com.xuan.array_related;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 10/13/16.
 */
public class PartitionEqualSumSubsets_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0, max = 0, maxIndex = -1;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        if (sum % 2 != 0 || sum / 2 < max) {
            return false;
        }
        int tmp = nums[nums.length - 1];
        nums[nums.length - 1] = max;
        nums[maxIndex] = tmp;
        int target = sum / 2 - max;

        @SuppressWarnings({"unchecked"})
        Map<Integer, Boolean>[] maps = (Map<Integer, Boolean>[])new Map[target + 1];
        return helper(nums, nums.length - 2, target, maps);
    }

    private boolean helper(int[] nums, int index, int target, Map<Integer, Boolean>[] maps) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index < 0) {
            return false;
        }

        if (maps[target] == null) {
            maps[target] = new HashMap<Integer, Boolean>();
        }
        if (maps[target].containsKey(index)) {
            return maps[target].get(index);
        }
        boolean res = helper(nums, index - 1, target - nums[index], maps) ||
                helper(nums, index - 1, target, maps);
        maps[target].put(index, res);
        return res;
    }
}
