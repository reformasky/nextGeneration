package com.xuan.array_related;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 10/11/16.
 */
public class FrogJump_403 {
    /*public boolean canCross(int[] stones) {
        if (stones.length <= 1) {
            return true;
        }
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        for(int i : stones) {
            nexts.put(i, new HashSet<>());
        }
        nexts.get(0).add(1);
        for(int stone : stones) {
            for(int step : nexts.get(stone)) {
                int next = step + stone;
                if (nexts.containsKey(next)) {
                    if (next == stones[stones.length - 1]) {
                        return true;
                    }
                    Set<Integer> currSteps = nexts.get(next);
                    if (step > 1) {
                        currSteps.add(step - 1);
                    }
                    currSteps.add(step);
                    currSteps.add(step +1);
                }
            }
        }
        return false;
    }*/
    Map<Integer, Set<Integer>> nexts;
    public boolean canCross(int[] stones) {
        if (stones.length <= 1) {
            return true;
        }
        nexts = new HashMap<>();
        for(int i : stones) {
            nexts.put(i, new HashSet<>());
        }
        return dfs(0, 1, stones[stones.length - 1]);
    }

    private boolean dfs(int currPos, int step, int target) {
        int next = currPos + step;
        if (nexts.containsKey(next)) {
            if (next == target) {
                return true;
            }
            Set<Integer> curr = nexts.get(next);
            if (step > 1 && curr.add(step - 1) && dfs(next, step - 1, target)) {
                return true;
            }
            if (curr.add(step) && dfs(next, step, target)) {
                return true;
            }
            if (curr.add(step + 1) && dfs(next, step + 1, target)) {
                return true;
            }
        }
        return false;
    }
}
