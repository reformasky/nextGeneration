package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/22/16.
 */
public class SingleNumberI_136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result ^= num;
        }
        return result;
    }
}
