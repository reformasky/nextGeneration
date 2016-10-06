package com.xuan.int_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 9/14/16.
 */
public class RussianDoll_354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (p, q) -> (p[0] == q[0] ? (q[1] - p[1]) : (p[0] - q[0])) );
        int[] heights = new int[envelopes.length];
        int index = 0;
        for(int[] envelope : envelopes) {
            int key = envelope[1];
            int r = Arrays.binarySearch(heights, 0, index, key);
            if (r < 0) {
                int insertPoint = - (r + 1);
                if (index == insertPoint) {
                    index++;
                }
                heights[insertPoint] = key;
            }
        }
        return index;
    }
}
