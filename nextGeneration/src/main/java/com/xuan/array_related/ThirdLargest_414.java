package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by xzhou2 on 10/19/16.
 */
public class ThirdLargest_414 {

    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for (int num : nums)
            if (set.add(num) && set.size() > 3)
                set.pollFirst();
        return set.size() > 2 ? set.pollFirst() : set.pollLast();
    }


    public int thirdMax_List(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> cache = new ArrayList<>();
        cache.add(nums[0]);
        for(int n = 1; n < nums.length; n++) {
            int i = 0;
            for(; i < cache.size(); i++) {
                if (cache.get(i) < nums[n]) {
                    cache.add(i, nums[n]);
                    if (cache.size() > 3) {
                        cache.remove(3);
                    }
                    break;
                } else if (cache.get(i) == nums[n]) {
                    break;
                }
            }
            if (cache.size() < 3 && i == cache.size()) {
                cache.add(nums[n]);
            }
        }
        return cache.size() == 3 ? cache.get(2) : cache.get(0);
    }
}
