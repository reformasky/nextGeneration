package com.xuan.string_related;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 7/24/16.
 */
public class WordBreak_140 {
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return helper(s, 0, wordDict);
    }

    private List<String> helper(String s, int index, Set<String> wordDict) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        List<String> curr = new ArrayList<>();
        for(int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (wordDict.contains(word)) {
                if (i == s.length()) {
                    curr.add(word);
                } else {
                    List<String> pre = helper(s, i, wordDict);
                    for (String p : pre) {
                        String tmp = word + " ";
                        curr.add(tmp + p);
                    }
                }
            }
        }
        map.put(index, curr);
        return curr;
    }
}
