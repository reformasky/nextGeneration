package com.xuan.int_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 8/17/16.
 */
public class NumOfSquares_279 {
    public int numSquares(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        int index1, index2;
        for(int i = 1; (index1= i * i ) <= n; i++){
            cache[index1] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; (index2 = i + j * j) <=n; j++) {
                cache[index2] = Math.min(cache[index2], cache[i] + 1);
            }
        }
        return cache[n];
    }
}
