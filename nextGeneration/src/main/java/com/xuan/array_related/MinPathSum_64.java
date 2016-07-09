package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] cache = new int[n];
        cache[0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            cache[i] = cache[i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            cache[0] = cache[0] + grid[i][0];
            for(int j = 1; j < n; j++) {
                cache[j] = Math.min(cache[j], cache[j-1]) + grid[i][j];
            }
        }
        return cache[n - 1];
    }
}
