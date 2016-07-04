package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class UniquePath_62 {
    public int uniquePaths(int m, int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, 1);
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                cache[j] = cache[j] + cache[j-1];
            }
        }
        return cache[n - 1];
    }
}
