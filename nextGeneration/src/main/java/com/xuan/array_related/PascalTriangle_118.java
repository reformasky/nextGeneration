package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/15/16.
 */
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) {
            return result;
        }

        Integer[] pre = new Integer[]{1}, curr;
        result.add(Arrays.asList(pre));
        for(int i = 1; i < numRows; i++) {
            curr = new Integer[i + 1];
            curr[0] = 1;
            for(int j = 1; j < i; j++) {
                curr[j] = pre[j-1] + pre[j];
            }
            curr[i] = 1;
            result.add(Arrays.asList(curr));
            pre = curr;
        }
        return result;
    }
}
