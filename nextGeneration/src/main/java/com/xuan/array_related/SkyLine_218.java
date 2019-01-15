package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 8/3/16.
 */
public class SkyLine_218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return result;
        }
        PriorityQueue<int[]> enque = new PriorityQueue<>(buildings.length, (p, q) -> (p[1] != q[1] ? (p[1] - q[1]) : (p[2] - q[2])));
        for(int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            enque.offer(new int[]{0, b[0], b[2]});
            enque.offer(new int[]{1, b[1], b[2], b[0]});
        }

        int h = 0, index;
        while(! enque.isEmpty()) {
           int[] point = enque.poll();
           index = point[1];
           while(!enque.isEmpty() && enque.peek()[1] == index) {
               point = enque.poll();
           }
           if (point[0] == 0) {
               if (point[2] > h) {
                   h = point[2];
                   result.add(new int[]{point[1], h});
               }
           } else {
               if (point[2] == h) {
                   int next = 0;
                   for(int[] p : enque) {
                       if (p[0] == 1 && p[3]<= point[1]) {
                           if (p[2] >= point[2]) {
                               next = h;
                               break;
                           }
                           next = Math.max(next, p[2]);
                       }
                   }
                   if (next < h) {
                       h = next;
                       result.add(new int[]{point[1], h});
                   }
               }
           }
        }
        return result;
    }
}
