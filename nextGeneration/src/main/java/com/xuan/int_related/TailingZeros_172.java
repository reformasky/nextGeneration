package com.xuan.int_related;

/**
 * Created by xzhou2 on 7/27/16.
 */
public class TailingZeros_172 {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n > 0) {
            int t = n /= 5;
            result += t;
        }
        return result;
    }
}
