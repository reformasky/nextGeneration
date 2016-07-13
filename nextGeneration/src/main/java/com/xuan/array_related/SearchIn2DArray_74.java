package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class SearchIn2DArray_74 {
    public boolean searchMatrix_m_plus_n(int[][] matrix, int target) {
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
    public boolean searchMatrix_mlogn(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int low = 0, high = matrix.length - 1;
        int len = matrix[0].length;
        while(low < high) {
            if (matrix[low][len-1] == target || matrix[high][0] == target) {
                return true;
            }
            if (matrix[low][len-1] < target) {
                low++;
            }
            if (matrix[high][0] > target) {
                high--;
            }
            if (low >= matrix.length || high < 0) {
                return false;
            }
        }
        return Arrays.binarySearch(matrix[low], target) >= 0;
    }
}
