package com.xuan.combination_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 6/29/16.
 */
public class CombinationSum_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        path.add(candidates[index]);
        helper(candidates, index+1, target - candidates[index], path, result);
        path.remove(path.size() - 1);
        int nextIndex = index + 1;
        while(nextIndex < candidates.length && candidates[nextIndex] == candidates[index]) {
            nextIndex++;
        }
        helper(candidates, nextIndex, target, path, result);
    }
}
