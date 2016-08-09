package com.xuan.string_related;

/**
 * Created by xzhou2 on 8/2/16.
 */
public class ShortestPalindrome_214 {
    public String shortestPalindrome(String s) {
        String p = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = buildTable(p);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    private int[] buildTable(String p) {
        int[] result = new int[p.length()];
        int index = 0;
        for(int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == p.charAt(index)) {
                result[i] = result[i - 1] + 1;
                index++;
            } else {
                index = result[i - 1];
                while(index > 0 && p.charAt(index) != p.charAt(i)) {
                    index = result[index - 1];
                }
                if (p.charAt(index) == p.charAt(i)) {
                    index++;
                }
                result[i] = index;
            }
        }
        return result;
    }
}
