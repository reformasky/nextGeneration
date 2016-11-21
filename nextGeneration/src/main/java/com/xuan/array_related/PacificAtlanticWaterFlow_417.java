package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 10/13/16.
 */
public class PacificAtlanticWaterFlow_417 {
    int[][] diffs = new int[][]{new int[]{0,1}, new int[]{0, -1}, new int[]{1,0}, new int[]{-1, 0}};
    int m, n;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        for(int j = 0; j < n; j++) {
            dfs(0, j, 1, cache, matrix);
        }
        for(int i = 0; i < m; i++) {
            dfs(i, 0, 1, cache, matrix);
        }

        for(int j = 0; j < n; j++) {
            dfs(m - 1, j, 2, cache, matrix);
        }
        for(int i = 0; i < m; i++) {
            dfs(i, n - 1, 2, cache, matrix);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (cache[i][j] == 3) {
                    res.add(new int[]{i,j});
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, int mask, int[][] cache, int[][] matrix) {
        if ((cache[r][c] & mask) == 0) {
            cache[r][c] |= mask;
            for(int[] diff : diffs) {
                int nextR = r + diff[0], nextC =  c + diff[1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n
                        && matrix[nextR][nextC] >= matrix[r][c]) {
                    dfs(nextR, nextC, mask, cache, matrix);
                }
            }
        }
    }
}
