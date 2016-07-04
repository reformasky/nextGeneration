package com.xuan.array_related;


import com.xuan.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/3/16.
 */
public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty() ){
            return result;
        }
        Interval[] arr = new Interval[intervals.size()];
        intervals.toArray(arr);
        Arrays.sort(arr, (p, q) -> (p.start - q.start));
        int start = arr[0].start, end = arr[0].end;
        for(int i = 0; i < arr.length;i++) {
            if (arr[i].start > end) {
                result.add(new Interval(start, end));
                start = arr[i].start;
                end = arr[i].end;
            }
            else {
                end = Math.max(end, arr[i].end);
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
