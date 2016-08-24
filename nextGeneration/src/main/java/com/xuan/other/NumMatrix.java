package com.xuan.other;

/**
 * Created by xzhou2 on 8/23/16.
 */
public class NumMatrix {
    int[][] sums = null;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int nRow = matrix.length, nCol = matrix[0].length;

        sums = new int[nRow][nCol];
        sums[0][0] = matrix[0][0];
        for(int i = 1; i < nRow; i++) {
            sums[i][0] = sums[i - 1][0] + matrix[i][0];
        }
        for(int i = 1; i < nCol; i++) {
            sums[0][i] = sums[0][i - 1] + matrix[0][i];
        }
        for(int i = 1; i < nRow; i++) {
            for(int j = 1; j < nCol; j++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums == null ? 0 :  sums[row2][col2] - get(row2, col1 - 1) - get(row1 - 1, col2) + get(row1 - 1, col1 - 1);
    }

    private int get(int i, int j) {
        if (i >= 0 && j >= 0) {
            return sums[i][j];
        } else {
            return 0;
        }
    }
}
