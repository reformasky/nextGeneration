package com.xuan.string_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/21/16.
 */
public class MinCutPalindrome_132 {
    public int minCut_DP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] mins = new int[s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int i = 1; i < s.length(); i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    min = j== 0 ? 0 : Math.min(min, mins[j - 1] + 1);
                }
            }
            mins[i] = min;
        }

        return mins[s.length() - 1];
    }







    boolean[][] isPalindrome;
    int[][] cache;
    public int minCut_InEfficient(String s) {
        isPalindrome = new boolean[s.length()][s.length()];
        int length = s.length();
        for(int len = 1; len <= s.length(); len++) {
            for(int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len -1;
                if (len == 1) {
                    isPalindrome[i][j] = true;
                } else if (len == 2) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
            }
        }
        cache = new int[length][length];
        for(int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return helper(0, length - 1);
    }

    private int helper(int low,int high) {
        if (cache[low][high] >= 0) {
            return cache[low][high];
        }
        if (isPalindrome[low][high]) {
            cache[low][high] = 0;
            return 0;
        }
        int curr = Integer.MAX_VALUE;
        for(int i = low; i < high; i++) {
            if (isPalindrome[low][i]) {
                if (isPalindrome[i+1][high]) {
                    cache[low][high] = 1;
                    return cache[low][high];
                }
                else {
                    curr = Math.min(curr, 1 + helper(i + 1, high));
                }
            }
        }
        cache[low][high] = curr;
        return curr;
    }
}
