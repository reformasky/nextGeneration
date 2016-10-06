package com.xuan.array_related;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xzhou2 on 9/7/16.
 */
public class ReconstructItinerary_332 {
    private static final int len = 3;
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {

            if (!map.containsKey(ticket[0])) {map.put(ticket[0], new PriorityQueue<>());}
            map.get(ticket[0]).offer(ticket[1]);
        }
        Stack<String> path = new Stack<>();
        dfs(map, "JFK", path);
        List<String> res = new ArrayList<>(tickets.length + 1);
        for(String i : path) {
            res.add(i);
        }
        return res;
    }

    private void dfs(Map<String , Queue<String >> map, String ori, Stack<String> path) {
        Stack<String> removed = new Stack<>();
        path.push(ori);
        Queue<String> queue = map.get(ori);
        while(queue != null && !queue.isEmpty()) {
            String des = queue.poll();
            dfs(map, des, path);
            if (!queue.isEmpty() && path.peek() != ori) {
                while(path.peek() != ori) {
                    removed.push(path.pop());
                }
            }
        }
        while(!removed.isEmpty()) {
            path.push(removed.pop());
        }
    }


    private static int strToInt(String str) {
        int result = 0;
        for(int i = 0; i < len; i++) {
            result = result * 26 + str.charAt(i) - 'A';
        }
        return result;
    }

    private static String intToStr(int val) {
        char[] result = new char[len];
        for(int i = len - 1; i >= 0; i--) {
            result[i] = (char) ('A' + val % 26);
            val /= 26;
        }
        return new String(result);
    }
}
