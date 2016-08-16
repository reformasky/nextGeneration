package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/15/16.
 */
public class UglyNumberII_264 {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int index = 1;
        while(index < n) {
            int val2 = nums[index2] * 2,
                    val3 = nums[index3] * 3,
                    val5 = nums[index5] * 5;
            int val = min(val2, val3, val5);
            if (val == val2) {
                index2++;
            }
            if (val == val3) {
                index3++;
            }
            if (val == val5) {
                index5++;
            }
            nums[index++] = val;
        }
        return nums[n - 1];
    }

    private int min(int a, int b, int c) {
        return a < b ? a < c ? a : c
                : b < c ? b : c;
    }
}
