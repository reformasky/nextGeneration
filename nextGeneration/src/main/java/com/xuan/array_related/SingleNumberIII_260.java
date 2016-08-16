package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/15/16.
 */
public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for(int n : nums) {
            mask ^= n;
        }
        mask = (mask & ~(mask - 1));
        int num1 = 0, num2 = 0;
        for(int n : nums) {
            if ((n & mask) != 0) {
                num1 ^= n;
            } else {
                num2 ^= n;
            }
        }
        return new int[] {num1, num2};
    }
}
