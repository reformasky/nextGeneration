package com.xuan.string_related;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 8/24/16.
 */
public class RemoveParentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left <= 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        dfs(s, 0, left, right, 0, new StringBuilder(), set);
        return new ArrayList<>(set);
    }

    private void dfs(String s, int index, int left, int right, int open, StringBuilder path, Set<String> set) {
        if (left < 0 || right < 0 || open < 0) {
            return;
        }
        if (index == s.length()) {
            if (left == 0 && right == 0) {
                set.add(path.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            dfs(s, index + 1, left - 1, right, open, path, set);
            path.append(c);
            dfs(s, index + 1, left, right, open + 1, path, set);
        } else if (c == ')') {
            dfs(s, index + 1, left, right - 1, open, path, set);
            path.append(c);
            dfs(s, index + 1, left, right, open - 1, path, set);
        } else {
            path.append(c);
            dfs(s, index + 1, left, right, open, path, set);
        }
        path.deleteCharAt(path.length() - 1);
    }
}
