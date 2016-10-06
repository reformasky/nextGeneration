package com.xuan.int_related;

/**
 * Created by xzhou2 on 9/12/16.
 */
public class NumOfUniqueDigits_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            n = 10;
        }
        int res = 0, acc = 1, curr = 9, step = 0;
        while(step <= n) {
            res += acc;
            if (step++ > 1) {
                curr--;
            }
            acc *= curr;
        }
        return res;
    }
}
