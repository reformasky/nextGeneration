package com.xuan.array_related;

/**
 * Created by xzhou2 on 1/6/17.
 */
public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int num = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = num * nums[i];
            num = result[i];
        }
        num = 1;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = num * nums[i];
            num = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            result[i] = get(result, i + 1) * get(nums, i - 1);
        }
        return result;
    }

    private int get(int[] nums, int index) {
        return (index >= 0 && index < nums.length) ? nums[index] : 1;
    }
}
