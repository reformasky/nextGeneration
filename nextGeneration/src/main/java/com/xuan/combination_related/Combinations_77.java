package com.xuan.combination_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/7/16.
 */
public class Combinations_77 {

    public List<List<Integer>> combine_dfs(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }
        helper(0, new Integer[k], result, n);
        return result;
    }

    private void helper(int index, Integer[] path, List<List<Integer>> result, int n) {
        if (index >= path.length) {
            result.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        for (int i = index == 0 ? 0 : path[index - 1]; i < n; i++) {
            path[index] = i + 1;
            helper(index + 1, path, result, n);
        }
    }
}

