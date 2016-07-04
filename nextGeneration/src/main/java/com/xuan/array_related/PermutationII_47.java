package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/1/16.
 */
public class PermutationII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new boolean[nums.length],new Integer[nums.length], result);
        return result;
    }

    private void helper(int[] nums, int index, boolean[] visited, Integer[] path, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(Arrays.asList(path)));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path[index] = nums[i];
                visited[i] = true;
                helper(nums, index+1, visited, path, result);
                visited[i] = false;
                int tmp = nums[i];
                while(i < nums.length - 1 && nums[i+1] == tmp) {
                    i++;
                }
            }
        }
    }
}
