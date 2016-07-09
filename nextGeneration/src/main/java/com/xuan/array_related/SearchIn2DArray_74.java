package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class SearchIn2DArray_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = matrix.length - 1, c = 0;

        while(r >= 0 && c < matrix[0].length) {
            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] > target) {
                r--;
            }
            else {
                c++;
            }
        }
        return false;
    }
}
