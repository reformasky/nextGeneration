package com.xuan.array_related;

/**
 * Created by xzhou2 on 9/6/16.
 */
public class LongestIncreasePathInMatrix_329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int nRow = matrix.length, nCol = matrix[0].length;
        int[][]cache = new int[nRow][nCol];
        int result = 0;
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                result = Math.max(result, helper(matrix, i, j, cache));
            }
        }
        return result;

    }

    private int helper(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int result = 1;
        if (i > 0 && matrix[i-1][j] < matrix[i][j]) {
            result = Math.max(result, 1+ helper(matrix, i - 1, j, cache));
        }
        if (i < matrix.length - 1 && matrix[i+1][j] < matrix[i][j]) {
            result = Math.max(result, 1 + helper(matrix, i + 1, j, cache));
        }
        if (j > 0 && matrix[i][j-1] < matrix[i][j]) {
            result = Math.max(result, 1 + helper(matrix, i, j -1, cache));
        }
        if (j < matrix[0].length - 1 && matrix[i][j+1] < matrix[i][j]) {
            result = Math.max(result, 1 + helper(matrix, i, j + 1, cache));
        }
        cache[i][j] = result;
        return result;
    }
}
