package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/27/16.
 */
public class MajorityElement_169 {
    public int majorityElement_O1Space(int[] nums) {
        int result = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                if (count == 0) {
                    count = 1;
                    result = nums[i];
                } else {
                    count--;
                }
            }
        }
        return result;
    }

    public int majorityElement_bit(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++)
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

    public int majorityElement(int[] nums) {
        int index = 0, size = nums.length;
        while(size > 1) {
            int max = size %2 == 0 ? size : (size - 1);
            index = 0;
            for(int i = 0; i < max; i += 2) {
                if (nums[i] == nums[i + 1]) {
                    nums[index++] = nums[i];
                }
            }
            if (size % 2 != 0) {
                nums[index++] = nums[size - 1];
            }
            size = index;
        }
        return nums[0];
    }
}
