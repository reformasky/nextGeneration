package com.xuan.string_related;

/**
 * Created by xzhou2 on 8/2/16.
 */
public class KMP {
    /*public int search(String s, String p) {
        int[] table = buildTable(p);

        for(int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            } else {
                j = j > 0 ? table[j-1] : 0;
                while(j > 0 && s.charAt(i) != p.charAt(j)) {
                    j = table[j - 1];
                }
                if (s.charAt(i) == p.charAt(j)) {
                    j++;
                }
            }
            if (j == p.length()) {
                return i - j + 1;
            }
        }
        return  -1;
    }

    private int[] buildTable(String p) {
        int[] result = new int[p.length()];
        int index = 0;
        for(int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == p.charAt(index)) {
                result[i] = result[i - 1] + 1;
                index++;
            } else {
                index = result[i-1];
                while(index > 0 && p.charAt(i) != p.charAt(index)) {
                    index = result[index - 1];
                }
                if (p.charAt(i) == p.charAt(index)) {
                    index++;
                }
                result[i] = index;
            }
        }
        return result;
    }
*/
    public static int search(String s, String p) {
        int[] table = buildTable(p);
        for(int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            } else {
                while(j > 0 && s.charAt(i) != p.charAt(j)) {
                    j = table[j-1];
                }
                if (s.charAt(i) == p.charAt(j)) {
                    j++;
                }
            }
            if (j == p.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] buildTable(String p) {
        int[] table = new int[p.length()];
        for(int i = 1, index = 0; i < p.length(); i++) {
            if (p.charAt(i) == p.charAt(index)) {
                table[i] = ++index;
            } else {
                while(index > 0 && p.charAt(i) != p.charAt(index)) {
                    index = table[index-1];
                }
                if (p.charAt(i) == p.charAt(index)) {
                    index++;
                }
                table[i] = index;
            }
        }
        return table;
    }
}
