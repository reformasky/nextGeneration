package com.xuan.int_related;

/**
 * Created by xzhou2 on 7/31/16.
 */
public class NumOfOneBits_191 {
    public int hammingWeight(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>= 1;
        }
        return result;
    }
}
