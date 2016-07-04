package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/2/16.
 */
public class NQueensII_52 {
    int result = 0;
    public int totalNQueens(int n) {
        helper(n, 0, new int[n]);
        return result;
    }

    private void helper(int n, int index, int[] path) {
        if (index >= n) {
            result++;
            return;
        }
        for(int i = 0; i < n; i++) {
            path[index] = i;
            if (isValid(path, index)) {
                helper(n, index + 1, path);
            }
        }
    }

    private boolean isValid(int[] path, int index) {
        for(int i = 0; i < index; i++) {
            if (path[i] == path[index] || (index - i) == (path[i] - path[index]) || (index - i) == (path[index] - path[i])) {
                return false;
            }
        }
        return true;
    }
}
