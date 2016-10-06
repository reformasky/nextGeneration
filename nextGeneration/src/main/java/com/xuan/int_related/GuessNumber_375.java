package com.xuan.int_related;

/**
 * Created by xzhou2 on 9/27/16.
 */
public class GuessNumber_375 {
    public int getMoneyAmount(int n) {
        int[][] cache = new int[n+1][n+1];
        for(int i = 1; i < n; i++) {
            cache[i][i+1] = i;
        }
        for(int diff = 2; diff < n; diff++) {
            for(int i = 1; i <= n - diff; i++) {
                int j = i + diff;
                int min = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++) {
                    min = Math.min(min, k + Math.max(cache[i][k-1], cache[k+1][j]));
                }
                cache[i][j] = min;
            }
        }
        return cache[1][n];
    }
}
