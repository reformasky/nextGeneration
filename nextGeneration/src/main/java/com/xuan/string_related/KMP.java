package com.xuan.string_related;

/**
 * Created by xzhou2 on 8/2/16.
 */
public class KMP {
    public static int search(String s, String p) {
        int[] table = buildTable(p);
        for(int i = 0, j = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != p.charAt(j)) {
                j = table[j-1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] buildTable(String s) {
        int[] kmp = new int[s.length()];
        for(int i = 1, index = 0; i < s.length(); i++) {
            while(index > 0 && s.charAt(i) != s.charAt(index)) {
                index = kmp[index - 1];
            }
            if (s.charAt(i) == s.charAt(index)) {
                index++;
            }
            kmp[i] = index;
        }
        return kmp;
    }
}
