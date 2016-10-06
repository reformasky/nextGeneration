package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 9/21/16.
 */
public class KPairsWithSmallSum_373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if (nums1==null || nums2==null || nums1.length ==0 || nums2.length ==0) return ret;
        int len1 = nums1.length, len2=nums2.length;
        int[] indexes = new int[len1];
        //idx for nums1, sum for nums1[ele[0]] + nums2[indexes[ele[0]]]
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 0; i < len1; i++) {
            queue.offer(new int[]{i, nums1[i] + nums2[indexes[i]]});
        }
        while(ret.size() < Math.min(len1 * len2, k)) {
            int[] element = queue.poll();
            ret.add(new int[]{nums1[element[0]], nums2[indexes[element[0]]++]});
            if(indexes[element[0]] < len2) {
                queue.offer(new int[]{element[0], nums1[element[0]] + nums2[indexes[element[0]]]});
            }
        }

        return ret;
    }

}
