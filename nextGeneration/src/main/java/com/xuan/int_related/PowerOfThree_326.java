package com.xuan.int_related;

/**
 * Created by xzhou2 on 9/1/16.
 */
public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
