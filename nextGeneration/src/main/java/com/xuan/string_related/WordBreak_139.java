package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 7/23/16.
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] cache, visited;
        cache = new boolean[s.length() + 1];
        visited = new boolean[s.length() + 1];
        cache[0] = true;
        visited[0] = true;
        return helper(s, wordDict, visited, cache);
    }

    private boolean helper(String s, Set<String> wordDict, boolean[] visited, boolean[] cache) {
        int len = s.length();
        if (visited[len]) {
            return cache[len];
        }
        visited[len] = true;
        for(int i = len - 1; i >= 0; i--) {
            if (wordDict.contains(s.substring(i, len)) && helper(s.substring(0, i), wordDict, visited, cache)) {
                cache[len] = true;
                return true;
            }
        }
        return false;
    }
}
