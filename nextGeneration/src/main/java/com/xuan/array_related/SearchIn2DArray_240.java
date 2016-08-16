package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/11/16.
 */
public class SearchIn2DArray_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int nRow = matrix.length, nCol = matrix[0].length;
        int r = nRow - 1, c = 0;
        while( r >= 0 && c < nCol) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                c++;
            } else {
                r--;
            }
        }
        return false;
    }
}
