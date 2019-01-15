package com.xuan.other;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 8/1/16.
 */


class Solution {
    public String rearrangeString(String s, int k) {
        int[][] counts = new int[26][2];
        for(int i = 0; i < 26; i++) {
            counts[i][0] = i;
        }
        for(char c : s.toCharArray()) {
            counts[c - 'a'][1]++;
        }
        int max = 0, count = 0;
        for(int[] c : counts) {
            if (c[1] > max) {
                max = c[1];
                count = 1;
            } else if (c[1] == max) {
                count++;
            }
        }
        int len = (max -1) * k  + count;
        if (len > s.length()) {
            return "";
        }
        Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });
        for(int[] c : counts) {
            if (c[1] != 0) {
                queue.offer(c);
            }
        }
        char[] arr = new char[s.length()];
        int[] idx = new int[26];
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            while(arr[idx[curr[0]]] != ' ') {
                idx[curr[0]]++;
            }
            arr[idx[curr[0]]] = (char)(arr[0] + 'a');
            idx[curr[0]] += k;
            if (--curr[1] > 0) {
                queue.offer(curr);
            }
        }
        return new String(arr);
    }
}