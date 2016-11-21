package com.xuan.combination_related;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 10/12/16.
 */
public class BinaryWatch_401 {
    Map<Integer, List<Integer>> hMap = new HashMap<>(),
            mMap = new HashMap<>();
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for(int i = Math.max(0, num - 5); i <= Math.min(3, num); i++) {
            int j = num - i;
            List<Integer> hours = getRes(i, true),
                    minutes = getRes(j, false);
            for(Integer hour : hours) {
                for(Integer minute : minutes) {
                    if (hour > 11 || minute > 59) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(5);
                    sb.append(hour);
                    sb.append(":");
                    if (minute < 10) {
                        sb.append("0");
                    }
                    sb.append(minute);
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    private List<Integer> getRes(int n, boolean hour) {
        if (hour && hMap.containsKey(n)) {
            return hMap.get(n);
        }
        if (!hour && mMap.containsKey(n)) {
            return mMap.get(n);
        }
        int max = hour ? 4 : 6;
        List<Integer> res = new ArrayList<>();
        getRes(n, 0, 0, max, res);
        if (hour) {
            hMap.put(n, res);
        } else {
            mMap.put(n, res);
        }
        return res;
    }

    private void getRes(int n, int curr, int index,int max, List<Integer> res) {
        if (n == 0) {
            res.add(curr);
            return;
        }
        if (index > (max - n)) {
            return;
        }
        getRes(n - 1, curr + (1<< index), index + 1, max, res);
        getRes(n, curr, index + 1, max, res);
    }
}
