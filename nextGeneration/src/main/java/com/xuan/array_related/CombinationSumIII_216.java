package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 8/3/16.
 */
public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Integer[] path = new Integer[k];
        List<List<Integer>> result = new ArrayList<>();
        for(int i = min(k, n); i <= max(k, n); i++) {
            path[0] = i;
            dfs(path, 1, n - i, result);
        }
        return result;
    }


    private void dfs(Integer[] path, int index, int val, List<List<Integer>> result) {
        if (index == path.length ) {
            if (val == 0) {
                result.add(new ArrayList<>(Arrays.asList(path)));
            }
            return;
        }
        for(int i = path[index-1] + 1; i <= max(path.length - index, val); i++) {
            path[index] = i;
            dfs(path, index + 1, val - i, result);
        }
    }

    private int min(int k, int n) {
        return Math.max(1, n - (9 + 9 - k + 2)* (k - 1) / 2);
    }

    private int max(int k, int n) {
        return Math.min((2 * n / k + 1 - k) / 2 + 1, 9);
    }
}
