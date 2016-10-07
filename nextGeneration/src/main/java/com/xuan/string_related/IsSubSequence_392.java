package com.xuan.string_related;

/**
 * Created by xzhou2 on 10/6/16.
 */
public class IsSubSequence_392 {
    public boolean isSubsequence(String s, String t) {
        int indexS = 0, indexT = 0;
        for(;indexS < s.length() && indexT < t.length(); indexT++) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
        }
        return indexS == s.length();
    }
}
