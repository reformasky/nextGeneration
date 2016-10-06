package com.xuan.other;

import com.xuan.util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by xzhou2 on 9/13/16.
 */
public class SummaryRanges {
    TreeSet<Integer> set;
    Map<Integer, Interval> map;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new TreeSet<>();
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (set.contains(val)) {
            return;
        }
        Integer lowerKey = set.lower(val), higherKey = set.higher(val);
        Interval lowerVal = lowerKey == null ? null : map.get(lowerKey),
                higherVal = higherKey == null? null : map.get(higherKey);
        Interval newVal = new Interval(val, val);
        Integer key = val;
        if (lowerVal != null) {
            if (lowerVal.end == val - 1) {
                newVal = lowerVal;
                key = lowerKey;
                newVal.end = val;
            }
            if (lowerVal.end >= val) {
                newVal = lowerVal;
                key = lowerKey;
            }
        }
        if (higherVal != null) {
            if (higherVal.start == val + 1) {
                newVal.end = higherVal.end;
                set.remove(higherKey);
                map.remove(higherKey);
            }
        }
        if (set.add(key)) {
            map.put(key, newVal);
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
