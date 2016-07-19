package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/18/16.
 */
public class DistinctSubSequences_115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int[] pre = new int[t.length() + 1],
                curr;
        pre[0] = 1;
        for(int i = 1; i <= s.length(); i++) {
            curr = new int[t.length() + 1];
            curr[0] = 1;
            for(int j = 1; j <= t.length(); j++) {
                curr[j] = pre[j];
                if(s.charAt(i -1) == t.charAt(j-1)) {
                    curr[j] += pre[j-1];
                }
            }
            pre = curr;
        }
        return pre[t.length()];
    }
}
