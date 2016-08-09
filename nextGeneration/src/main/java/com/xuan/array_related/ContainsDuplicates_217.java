package com.xuan.array_related;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 8/3/16.
 */
public class ContainsDuplicates_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
