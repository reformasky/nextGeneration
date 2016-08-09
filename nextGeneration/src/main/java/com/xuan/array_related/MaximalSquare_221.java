package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/5/16.
 */
public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int result = 0, nRow = matrix.length, nCol = matrix[0].length;
        int[][] len = new int[nRow][nCol];

        for(int c = 0; c < nCol; c++) {
            if (matrix[0][c] == '1') {
                result = 1;
                len[0][c] = 1;
            }
        }

        for(int r = 1; r < nRow; r++) {
            if (matrix[r][0] == '1') {
                len[r][0] = 1;
                result = Math.max(result, 1);
            }
            for(int c = 1; c < nCol; c++) {
                if (matrix[r][c] == '1') {
                    len[r][c] = 1 + min(len[r-1][c], len[r][c - 1], len[r-1][c-1]);
                    result = Math.max(len[r][c] * len[r][c], result);
                }
            }
        }
        return result;
    }

    private int min(int a, int b, int c) {
        return a > b ? b > c ? c : b
                : a > c ? c : a;
    }
}
