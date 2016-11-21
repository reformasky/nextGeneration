package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xzhou2 on 10/17/16.
 */
public class ReconstructQueue_406 {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int [] b) {
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });
        List<int[]> list = new ArrayList<>(len);
        for(int[] p : people) {
            list.add(p[1], p);
        }
        int[][] res = new int[len][2];
        int index = 0;
        for(int[] p : list) {
            res[index++] = p;
        }
        return res;
    }

    public int[][] reconstructQueue_n2(int[][] people) {
        int len = people.length;
        int[][] res = new int[len][2];
        int[] curr = new int[len];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return people[a][0] - people[b][0];
            }

        });
        for(int i = 0; i < len; i++) {
            curr[i] = people[i][1];
            if (people[i][1] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while(index < len) {
            int idx = queue.poll();
            int[] p = people[idx];
            res[index++] = p;
            for(int i = idx + 1; i < len; i++) {
                if (people[i][0] <= p[0]) {
                    curr[i]--;
                    if (curr[i] == 0) {
                        queue.offer(i);
                    }
                }

            }
        }
        return res;
    }
}
