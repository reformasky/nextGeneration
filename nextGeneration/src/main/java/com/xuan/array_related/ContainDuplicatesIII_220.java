package com.xuan.array_related;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xzhou2 on 8/4/16.
 */
public class ContainDuplicatesIII_220 {
    public boolean containsNearbyAlmostDuplicate_bucket(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            long buk =((long) nums[i] - Integer.MIN_VALUE) / (t + 1L);
            if (map.containsKey(buk) ||
                    (map.containsKey(buk - 1) && nums[i] - map.get(buk - 1) <= t) ||
                    (map.containsKey(buk + 1) && map.get(buk + 1) - nums[i] <= t)
                    ) {
                return true;
            }
            if (map.size() >= k) {
                long del = ((long)nums[i - k ] - Integer.MIN_VALUE)/(t + 1L);
                map.remove(del);
            }
            map.put(buk, (long)nums[i]);
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            Integer lower = set.lower(nums[i]);
            if (lower != null && lower >= nums[i] - t) {
                return true;
            }
            Integer higher = set.higher(nums[i]);
            if (higher != null && higher <= nums[i] + t) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
