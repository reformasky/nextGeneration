package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 8/8/16.
 */
public class MajorityElements_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int res1 = 0, res2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == res1) {
                count1++;
            } else if (nums[i] == res2) {
                count2++;
            } else {
                if (count1 == 0) {
                    res1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    res2 = nums[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for(int n : nums) {
            if (n == res1) {
                count1++;
            } else if (n == res2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(res1);
        }
        if (count2 > nums.length / 3) {
            result.add(res2);
        }
        return result;
    }
}
