package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/1/16.
 */
public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = len; i > 1; i -= 2) {
            int row = (len - i) / 2;
            for(int j = 0; j < i - 1; j++) {
                int col = j + row;
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[len - col - 1][row];
                matrix[len - col -1][row] = matrix[len - row - 1][len - col - 1];
                matrix[len - row - 1][len - col - 1] = matrix[col][len - row-1];
                matrix[col][len - row -1] = tmp;
            }
        }
    }
}
