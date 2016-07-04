package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/3/16.
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int curr = 1;
        for(int len = n; len > 1; len -= 2) {
            int start = (n - len) / 2, end = len + start - 1;
            for(int i = start; i < end; i++) {
                result[start][i] = curr++;
            }
            for(int i = start; i < end; i++) {
                result[i][end] = curr++;
            }
            for(int i = end; i > start; i--) {
                result[end][i] = curr++;
            }
            for(int i = end; i > start; i--) {
                result[i][start] = curr++;
            }
        }
        if (n % 2 != 0) {
            result[n/2][n/2] = curr++;
        }
        return result;
    }
}
