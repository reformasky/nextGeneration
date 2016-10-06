package com.xuan.int_related;

/**
 * Created by xzhou2 on 9/1/16.
 */
public class CountBits_338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int mask = 1, count = 1;
        for(int i = 1; i <= num; i++) {
            result[i] = result[~mask & i] + 1;
            count++;
            if (count > mask) {mask <<= 1; count = 1;}
        }
        return result;
    }
}
