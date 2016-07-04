package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/2/16.
 */
public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int nRow = matrix.length;
        if (nRow == 0) {
            return result;
        }
        int nCol = matrix[0].length;
        if (nCol == 0) {
            return result;
        }

        int min = Math.min(nRow, nCol);
        for(int index = 0; index < min /2; index++) {
            for(int i = index; i < nCol - index - 1; i++) {
                result.add(matrix[index][i]);
            }
            for(int i = index; i < nRow - index - 1; i++) {
                result.add(matrix[i][nCol - index - 1]);
            }
            for(int i = nCol - index - 1; i > index; i--) {
                result.add(matrix[nRow - index - 1][i]);
            }
            for(int i = nRow - index - 1; i > index; i--) {
                result.add(matrix[i][index]);
            }
        }
        if (min % 2 != 0) {
            if (nRow > nCol) {
                for(int i = nCol / 2; i < nRow - nCol/2; i++) {
                    result.add(matrix[i][nCol/2]);
                }
            }
            else {
                for(int i = nRow /2; i < nCol - nRow / 2; i++) {
                    result.add(matrix[nRow/2][i]);
                }
            }
        }

        return result;
    }
}
