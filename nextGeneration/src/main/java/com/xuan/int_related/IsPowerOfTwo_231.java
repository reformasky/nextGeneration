package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/8/16.
 */
public class IsPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while(n > 0) {
            if ((n & 1) == 1) {
                return n == 1;
            }
            n >>= 1;
        }
        return true;
    }
}
