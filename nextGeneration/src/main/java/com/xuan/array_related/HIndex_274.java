package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 8/16/16.
 */
public class HIndex_274 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int len = citations.length;
        int low = 0, high = len - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] == len - mid) {
                return citations[mid];
            } else if (citations[mid] > len - mid) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return len - low;
    }
}
