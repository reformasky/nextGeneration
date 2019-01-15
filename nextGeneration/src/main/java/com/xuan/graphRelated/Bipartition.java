package com.xuan.graphRelated;

import java.util.HashSet;
import java.util.Set;

public class Bipartition {
    class Solution {

        public boolean isBipartite(int[][] graph) {
            Set<Integer> setA = new HashSet<>(), setB = new HashSet<>();
            Set<Integer> unvisited = new HashSet<>(graph.length);
            for(int i = 0; i < graph.length; i++) {
                unvisited.add(i);
            }
            while (!unvisited.isEmpty()) {
                int src = unvisited.iterator().next();
                unvisited.remove(src);
                setA.add(src);
                if (!helper(graph, src, unvisited, setA, setB, true)) {
                    return false;
                }
            }
            return true;
        }

        private boolean helper(int[][] graph,int src, Set<Integer> unvisited, Set<Integer> setA, Set<Integer> setB, boolean second) {

            for(int des : graph[src]) {
                if (second) {
                    if (setA.contains(des)) {
                        return false;
                    }
                    setB.add(des);
                } else {
                    if (setB.contains(des)) {
                        return false;
                    }
                    setA.add(des);
                }
                if (unvisited.remove(des) && !helper(graph, des, unvisited, setA, setB, !second)) {
                    return false;
                }
            }
            return true;
        }

    }
}
