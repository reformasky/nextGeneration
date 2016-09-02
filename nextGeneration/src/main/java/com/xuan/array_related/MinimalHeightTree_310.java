package com.xuan.array_related;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 8/26/16.
 */
public class MinimalHeightTree_310 {

    int last = 0;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 3) {
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        List<Integer>[] graph = (List<Integer>[])new List[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        path(graph, last);
        int start = last;
        int[] pre = path(graph, start);
        List<Integer> reverse = new ArrayList<>();
        while(last != start) {
            reverse.add(last);
            last = pre[last];
        }
        reverse.add(start);
        int size = reverse.size();
        return size % 2 == 0 ? Arrays.asList(reverse.get(size / 2 - 1), reverse.get(size /2)) : Arrays.asList(reverse.get(size/ 2));

    }

    private int[] path(List<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        int[] pre = new int[graph.length];
        Arrays.fill(pre, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            for(int i : graph[curr]) {
                if (!visited[i]) {
                    queue.offer(i);
                    pre[i] = curr;
                    last = i;
                }
            }
        }
        return pre;
    }

    /*public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] neighbors = (Set<Integer>[]) new Set[n];
        for(int i = 0; i < n; i++) {
            neighbors[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (neighbors[i].size() <= 1) {
                leaves.add(i);
            }
        }
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                for(int j : neighbors[i]) {
                    neighbors[j].remove(i);
                    if (neighbors[j].size() == 1) {
                        newLeaves.add(j);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }*/
}
