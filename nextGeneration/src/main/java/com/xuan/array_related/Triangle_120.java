package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/17/16.
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }

        List<Integer> curr;
        List<Integer> pre= new ArrayList<>(triangle.get(0));

        for(int i = 1; i < triangle.size(); i++) {
            curr = new ArrayList<>(i + 1);
            List<Integer> tri = triangle.get(i);
            curr.add(pre.get(0) + tri.get(0));
            for(int j = 0; j < pre.size() - 1; j++) {
                curr.add(Math.min(pre.get(j),pre.get(j + 1)) + tri.get(j + 1));
            }
            curr.add(pre.get(pre.size() - 1) + tri.get(i));
            pre = curr;
        }
        int result = Integer.MAX_VALUE;
        for(int i : pre) {
            result = Math.min(result, i);
        }
        return result;

    }
}
