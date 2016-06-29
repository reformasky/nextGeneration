package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 6/28/16.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        if (candidates[index] <= target) {
            path.add(candidates[index]);
            helper(candidates, index, target - candidates[index], result, path);
            path.remove(path.size() - 1);
        }
        helper(candidates, index + 1, target, result, path);
    }
}
