package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class UniquePathII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 1;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] cache = new int[n];
        cache[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        if (cache[0] == 0) {
            return 0;
        }
        for(int i = 1; i < n; i++) {
            cache[i] = (cache[i-1] == 1 && obstacleGrid[0][i] == 0) ? 1 : 0;
        }
        for(int i = 1; i < m; i++) {
            cache[0] = (cache[0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0;
            for(int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cache[j] = 0;
                }
                else {
                    cache[j] = cache[j] + cache[j - 1];
                }
            }
        }
        return cache[n - 1];
    }
}
