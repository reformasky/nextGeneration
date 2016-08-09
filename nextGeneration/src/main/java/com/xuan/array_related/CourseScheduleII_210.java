package com.xuan.array_related;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 8/1/16.
 */
public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] counts = new int[numCourses];
        List<Integer>[] pres = (List<Integer>[])new List[numCourses];
        for(int i = 0; i < numCourses; i++) {
            pres[i] = new ArrayList<>();
        }
        int finished = 0;
        for(int[] p : prerequisites) {
            pres[p[1]].add(p[0]);
            counts[p[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if (counts[i] == 0) {
                queue.offer(i);
                result[finished++] = i;
            }
        }
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int i : pres[curr]) {
                if (--counts[i] == 0) {
                    queue.offer(i);
                    result[finished++] = i;
                }
            }
        }
        return finished == numCourses ? result : new int[0];
    }
}
