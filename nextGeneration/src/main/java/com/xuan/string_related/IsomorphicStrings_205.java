package com.xuan.string_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 8/1/16.
 */
public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] from = new int[128],
                to = new int[128];
        Arrays.fill(from, -1);
        Arrays.fill(to, -1);
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i),
                    c2 = t.charAt(i);
            if ((from[c1] == -1 && to[c2] != -1 ) || (from[c1] != -1 && to[c2] == -1)) {
                return false;
            } else if (from[c1] == -1){
                from[c1] = c2;
                to[c2] = c1;
            } else {
                if (c2 != from[c1] || c1 != to[c2]) {
                    return false;
                }
            }
        }
        return true;
    }
}
