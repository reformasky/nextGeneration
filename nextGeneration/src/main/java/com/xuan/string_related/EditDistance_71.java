package com.xuan.string_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class EditDistance_71 {
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[1 + word1.length()][1 + word2.length()];
        return dfs(cache, word1, word2, word1.length(), word2.length());
    }

    private int dfs(int[][] cache, String w1, String w2, int index1, int index2) {
        if (index1 == 0) {
            cache[index1][index2] = index2;
            return index2;
        }
        if (index2 == 0) {
            cache[index1][index2] = index1;
            return index1;
        }
        if (cache[index1][index2] != 0) {
            return cache[index1][index2];
        }
        int m1 = dfs(cache, w1,w2, index1 - 1, index2 -1);
        if (w1.charAt(index1 - 1) == w2.charAt(index2 - 1)) {
            return cache[index1][index2] = cache[index1 - 1][index2 - 1];
        }
        else {
            int m2 = dfs(cache, w1, w2, index1, index2 - 1);
            int m3 = dfs(cache, w1, w2, index1 - 1, index2);
            return cache[index1][index2] = (Math.min(Math.min(m1, m2), m3) + 1);
        }
    }


    public int minDistance_DP(String word1, String word2) {
        int[][] cache = new int[word1.length() + 1][word2.length() + 1];
        cache[0][0] = 0;
        for(int i = 1; i <= word2.length(); i++) {
            cache[0][i] = i;
        }
        for(int i = 1; i <= word1.length(); i++) {
            cache[i][0] = i;
        }
        for(int i = 0; i < word1.length(); i++) {
            for(int j = 0; j < word2.length(); j++) {
                cache[i+1][j+1] = Math.min(cache[i][j+1], cache[i+1][j]) + 1;
                cache[i+1][j+1] = Math.min(cache[i+1][j+1], cache[i][j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1));
            }
        }
        return cache[word1.length()][word2.length()];
    }
}
