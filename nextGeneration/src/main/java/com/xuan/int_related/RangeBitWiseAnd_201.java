package com.xuan.int_related;

/**
 * Created by xzhou2 on 7/31/16.
 */
public class RangeBitWiseAnd_201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int result = 0;
        for(int high = 31; high >= 0; high--) {
            if ((m & (1 << high)) == (n & (1 << high))) {
                result |= (m & (1 << high));
            } else {
                break;
            }
        }
        return result;
    }
}
