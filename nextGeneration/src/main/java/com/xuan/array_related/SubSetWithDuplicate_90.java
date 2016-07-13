package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/10/16.
 */
public class SubSetWithDuplicate_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        int lastStart = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = 0;
            if (i > 0 && nums[i] == nums[i -1]) {
                j = lastStart;
            }
            int size = result.size();
            for(; j < size; j++) {
                List<Integer> curr = new ArrayList<>(result.get(j));
                curr.add(nums[i]);
                result.add(curr);
            }
            lastStart = size;
        }
        return result;
    }
}
