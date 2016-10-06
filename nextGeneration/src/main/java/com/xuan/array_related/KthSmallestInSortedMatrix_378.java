package com.xuan.array_related;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 9/28/16.
 */
public class KthSmallestInSortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        boolean[][] added = new boolean[n][n];
        PriorityQueue<int[]> queue;
        int[][] diff;
        if (k <= n * n /2) {
            queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2) {
                    return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
                }
            });
            queue.offer(new int[]{0, 0});
            added[0][0] = true;
            diff = new int[][] {new int[]{1, 0}, new int[]{0,1}};
        } else {
            queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return matrix[o2[0]][o2[1]] - matrix[o1[0]][o1[1]];
                }
            });
            queue.offer(new int[]{n-1, n-1});
            k = n * n - k + 1;
            diff = new int[][]{new int[]{-1, 0}, new int[]{0, -1}};
            added[n-1][n-1] = true;
        }

        int count = 0;
        while(true) {
            int[] curr = queue.poll();
            if (++count == k) {
                return matrix[curr[0]][curr[1]];
            }
            for(int[] d : diff) {
                int[] next = new int[]{curr[0] + d[0], curr[1] + d[1]};
                if (next[0]>=0 && next[0] < n && next[1] >= 0 && next[1] < n && !added[next[0]][next[1]]) {
                    added[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }

        }
    }

}
