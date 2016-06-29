package com.xuan.string_related;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class FindAllSubString_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            for(int i = 0; i < s.length(); i++) {
                result.add(i);
            }
            return result;
        }
        int len = words[0].length();
        Map<String, Integer> counts = new HashMap<>(words.length);
        for (String w : words) {
            if (!counts.containsKey(w)) {
                counts.put(w, 0);
            }
            counts.put(w, counts.get(w) + 1);
        }
        Map<String, Integer> currCount = new HashMap<>();
        for(String w : words) {
            currCount.put(w, 0);
        }
        for (int i = 0; i < len; i++) {
            refresh(currCount);
            int left = i;
            boolean invalid = false;
            for (int j = i; j <= s.length() - len; j+= len) {
                String sub = s.substring(j, j + len);
                if (counts.containsKey(sub)) {
                    if (invalid) {
                        refresh(currCount);
                        left = j;
                        invalid = false;
                    }
                    if (currCount.get(sub) < counts.get(sub)) {
                        currCount.put(sub, currCount.get(sub)+1);
                    }
                    else {
                        while(currCount.get(sub) >= counts.get(sub)) {
                            String key = s.substring(left, left + len);
                            currCount.put(key, currCount.get(key) -1);
                            left += len;
                        }
                        currCount.put(sub, currCount.get(sub)+1);
                    }
                    if (j - left == (words.length - 1) * len) {
                        result.add(left);
                    }
                }
                else {
                    invalid = true;
                }
            }
        }
        return result;
    }

    private void refresh(Map<String, Integer> map) {
        for(String w : map.keySet()) {
            map.put(w, 0);
        }
    }

}
