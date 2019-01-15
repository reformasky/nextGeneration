package com.xuan.combination_related;

import com.xuan.util.TreeNode;
import com.xuan.util.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PermutationII {
    class Solution {
        public String minWindow(String s, String t) {
            int begin = 0, end = Integer.MAX_VALUE;
            int[] counts = new int[128];
            int count = t.length();
            for(char c : t.toCharArray()) {
                counts[c]++;
            }
            for(int low = 0, high = 0; high < s.length(); high++) {
                char c = s.charAt(high);
                if (counts[c] > 0) {
                    count--;
                }
                counts[c]--;
                if (count <= 0) {
                    while(counts[s.charAt(low)] < 0) {
                        counts[s.charAt(low++)]++;
                    }
                    if (end - begin > high - low) {
                        end = high;
                        begin = low;
                    }
                }

            }
            return s.substring(begin, end + 1);
        }
    }
}
