package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 8/8/16.
 */
public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int begin = nums[0], pre = begin;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != pre + 1) {
                if (pre == begin) {
                    result.add(begin +"");
                } else {
                    result.add(begin + "->" + pre);
                }
                begin = pre = nums[i];
            } else {
                pre = nums[i];
            }
        }
        if (pre == begin) {
            result.add(begin +"");
        } else {
            result.add(begin + "->" + pre);
        }
        return result;
    }
}
