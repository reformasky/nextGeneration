package com.xuan.int_related;

/**
 * Created by xzhou2 on 7/29/16.
 */
public class ReverseBits_190 {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            result |= (((n & (1 << i)) >>> i) << (31 - i) );
        }
        return result;
    }
}
