package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 6/23/16.
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = nums[0] + nums[1] + nums[2] - target;
        boolean larger = diff >= 0;
        diff = larger ? diff : -diff;
        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int low = i + 1, high = nums.length -1;
                while(low < high) {
                    int curr = nums[low] + nums[high] + nums[i] - target;
                    if (curr == 0) {
                        return curr + target;
                    }
                    else if (curr > 0) {
                        if (curr < diff) {
                            diff = curr;
                            larger = true;
                        }
                        high--;
                    }
                    else {
                        if (-curr < diff) {
                            diff = -curr;
                            larger = false;
                        }
                        low++;
                    }
                }
            }
        }
        return larger ? target + diff : target - diff;
    }
}
