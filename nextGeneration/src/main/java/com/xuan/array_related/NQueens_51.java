package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/2/16.
 */
public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(n, 0, new int[n], result);
        return result;
    }

    private void helper(int n, int index, int[] path, List<List<String>> result) {
        if (index >= n) {
            addResult(path, result);
            return;
        }
        for(int i = 0; i < n; i++) {
            path[index] = i;
            if (isValid(path, index)) {
                helper(n, index + 1, path, result);
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

    private void addResult(int[] path, List<List<String>> result) {
        int n = path.length;
        List<String> curr = new ArrayList<>(n);
        char[] sb = new char[n];
        for(int i = 0; i < n;i++) {
            for(int j = 0; j < n; j++) {
                sb[j] = path[i] == j ? 'Q' : '.';
            }
            curr.add(new String(sb));
        }
        result.add(curr);
    }
}
