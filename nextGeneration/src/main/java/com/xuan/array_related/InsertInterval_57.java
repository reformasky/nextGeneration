package com.xuan.array_related;

import com.xuan.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty()){
            return Arrays.asList(newInterval);
        }
        Interval[] arr = new Interval[intervals.size()];
        intervals.toArray(arr);
        int start = Arrays.binarySearch(arr, newInterval, (p, q) -> (p.start - q.start));
        int end = Arrays.binarySearch(arr, newInterval, (p, q) -> (p.end - q.end));
        if (start < 0) {
            start = -1 - start;
            if (start > 0 && newInterval.start <= arr[start - 1].end) {
                start--;
            }
        }
        if (end < 0) {
            System.out.println(end);
            end = -1 - end;
            if (end  < arr.length  && newInterval.end < arr[end].start) {
                end--;
            }
        }
        List<Interval> result = new ArrayList<>();
        for(int i = 0; i < start; i++) {
            result.add(arr[i]);
        }

        Interval toBeAdded = new Interval(start< 0 ? newInterval.start:Math.min(arr[start].start, newInterval.start), (end >= arr.length|| end < 0) ? newInterval.end :Math.max(arr[end].end, newInterval.end));
        result.add(toBeAdded);
        for(int i = end + 1; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
