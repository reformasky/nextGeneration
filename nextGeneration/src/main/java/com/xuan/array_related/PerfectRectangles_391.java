package com.xuan.array_related;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Created by xzhou2 on 10/10/16.
 */
public class PerfectRectangles_391 {
    //count corner and size.

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length < 2) {
            return true;
        }
        Arrays.sort(rectangles, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a1[0] == a2[0] ? (a1[1] - a2[1]) : (a1[0] - a2[0]);
            }
        });
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        int x = rectangles[0][0], index = 0, pre = rectangles[0][1];
        for(; index < rectangles.length; index++) {
            int[] curr = rectangles[index];
            if (curr[0] == x) {
                if (curr[1] == pre) {
                    if (!map.containsKey(curr[2])) {
                        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
                        rightMap.put(curr[1], curr[3]);
                        map.put(curr[2], rightMap);
                    } else {
                        if (!addRight(map.get(curr[2]), curr[1], curr[3])){
                            return false;
                        }
                    }
                    pre = curr[3];
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        for(;index < rectangles.length; index++) {
            int[] curr = rectangles[index];
            if (!map.containsKey(curr[0]) ) {
                return false;
            }
            TreeMap<Integer, Integer> leftMap = map.get(curr[0]);
            if (!leftMap.containsKey(curr[1]) || leftMap.get(curr[1]) < curr[3]) {
                return false;
            }
            int val = leftMap.remove(curr[1]);
            if (val != curr[3]) {
                leftMap.put(curr[3], val);
            } else if (leftMap.isEmpty()) {
                map.remove(curr[0]);
            }
            if (!map.containsKey(curr[2])) {
                TreeMap<Integer, Integer> rightMap = new TreeMap<>();
                rightMap.put(curr[1], curr[3]);
                map.put(curr[2], rightMap);
            } else if (!addRight(map.get(curr[2]), curr[1], curr[3])) {
                return false;
            }
        }

        return map.size() <= 1;
    }

    boolean addRight(TreeMap<Integer, Integer> map, Integer y1, Integer y2) {
        if (map.containsKey(y1)) {
            return false;
        }
        Integer key = y1, val = y2;
        Integer lowerKey = map.lowerKey(y1), higherKey = map.ceilingKey(y1);
        if (lowerKey != null) {
            if (map.get(lowerKey) > y1) {
                return false;
            }
            if (Objects.equals(map.get(lowerKey), y1)) {
                map.remove(lowerKey);
                key = lowerKey;
            }
        }
        if (higherKey != null) {
            if (higherKey < y2) {
                return false;
            }
            if (Objects.equals(higherKey, y2)) {
                val = map.remove(higherKey);
            }
        }
        map.put(key, val);
        return true;
    }
}
