package com.xuan.string_related;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xzhou2 on 7/6/16.
 */
public class MinimalWindowSubstring_76 {
    public String minWindow_moreEfficient(String s, String t) {
        if (t.length() > s.length() || t.length() == 0) {
            return "";
        }
        int[] count = new int[128];
        int total  = t.length();
        for(char c : t.toCharArray()) {
            count[c]++;
        }
        int start = 0, end = s.length(), last = 0;
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (count[index]-- > 0) {
                total--;
            }
            while (total == 0) {
                if (end - start > i - last) {
                    end = i;
                    start = last;
                }
                if (count[s.charAt(last)]++ == 0) {
                    total++;
                }
                last++;
            }
        }
        return end != s.length() ? s.substring(start, end + 1) : "";
    }


    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.length() == 0) {
            return "";
        }
        int[] count = new int[128];
        boolean[] has = new boolean[128];
        boolean[] finish = new boolean[128];
        int total  = 0;
        for(char c : t.toCharArray()) {
            count[c]++;
            if (!has[c]) {
                total++;
            }
            has[c] = true;
        }
        int start = 0, end = s.length();
        int last = 0;
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (has[index]) {
                count[index]--;
                if (count[index] == 0 && !finish[index]) {
                    total--;
                    finish[index] = true;
                }
                while(last < i && (count[s.charAt(last)] < 0 || !has[s.charAt(last)])) {
                    if (has[s.charAt(last)]) {
                        count[s.charAt(last)]++;
                    }
                    last++;
                }
                if (total == 0 && end - start > i - last) {
                    end = i;
                    start = last;
                }
            }
        }
        return total == 0 ? s.substring(start, end + 1) : "";
    }
}
