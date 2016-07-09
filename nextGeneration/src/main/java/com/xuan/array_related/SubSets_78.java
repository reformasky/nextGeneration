package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/7/16.
 */
public class SubSets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int preSize = result.size();
            for(int j = 0; j < preSize; j++) {
                List<Integer> curr = new ArrayList<>(result.get(j));
                curr.add(nums[i]);
                result.add(curr);
            }
        }
        return result;
    }

    public List<List<Integer>> subsets_dfs(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int s = 1; s <= nums.length; s++) {
            dfs(result, 0, new Integer[s], 0, nums);
        }
        return result;
    }

    private void dfs(List<List<Integer>> result, int index, Integer[] path, int nIndex, int[] nums) {
        if (index >= path.length) {
            result.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        for(int i = nIndex; i < nums.length - (path.length - index -1); i++) {
            path[index] = nums[i];
            dfs(result, index + 1, path, i + 1, nums);
        }
    }
}
