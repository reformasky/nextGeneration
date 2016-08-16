package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/15/16.
 */
public class UglyNumber_263 {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        int[] validDenominator = new int[]{2, 3, 5};
        for (int v : validDenominator) {
            while(num % v == 0) {
                num /= v;
            }
        }
        return num == 1;
    }
}
