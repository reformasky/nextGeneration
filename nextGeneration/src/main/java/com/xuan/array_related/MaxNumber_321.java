package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 8/31/16.
 */
class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : points) {
            int y = p[1], x = p[0];
            Set<Integer> set = map.get(y);
            if (set == null) {
                set = new HashSet<>();
                map.put(y, set);
            }
            set.add(x);
        }
        Set<Integer> set = null;
        Integer x = null;
        for(Set<Integer> v : map.values()) {
            if (v.size() > 2) {
                set = v;
            } else if (x == null) {
                x = v.iterator().next();
            } else if (x != v.iterator().next()) {
                return false;
            }
        }
        if (x == null) {
            List<Integer> l = new ArrayList<>(set);
            Collections.sort(l);
            x = l.get(0) + l.get(l.size() - 1);
        } else {
            x *= 2;
        }
        for(Set<Integer> v : map.values()) {
            if (v.size() > 2) {
                List<Integer> l = new ArrayList<>(set);
                Collections.sort(l);
                for(int i = 0, j = l.size() - 1; i <= j; i++, j--) {
                    if (x != l.get(i) + l.get(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
