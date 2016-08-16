package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/11/16.
 */
public class ProductOfArrayExceptForSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i-1];
        }
        int acc = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = acc * res[i];
            acc *= nums[i];
        }
        return res;
    }
}
