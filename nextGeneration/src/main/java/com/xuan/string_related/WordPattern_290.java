package com.xuan.string_related;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 8/22/16.
 */
public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        str = str.trim();
        String[] tokens = str.split(" ");
        if (pattern.length() != tokens.length) {
            return false;
        }
        String[] cache = new String[26];
        for(int i = 0; i < tokens.length; i++) {
            char c = pattern.charAt(i);
            if (cache[c - 'a'] == null) {
                cache[c - 'a'] = tokens[i];
            } else if (!cache[c - 'a'].equals(tokens[i])) {
                return false;
            }
        }
        Set<String> set = new HashSet<>(26);
        for(int i = 0; i < 26; i++) {
            if (cache[i] != null && !set.add(cache[i])) {
                return false;
            }
        }
        return true;
    }
}
