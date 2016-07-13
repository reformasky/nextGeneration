package com.xuan.TreeRelated;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/10/16.
 */
public class UniqueBSTs_96 {
    int[][] cache;
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        cache = new int[n][n];
        for(int i = 0; i < n; i++) {
            cache[i][i] = 1;
        }
        for(int diff = 1; diff < n; diff++) {
            for(int i = 0; i < n - diff; i++) {
                int j = i + diff;
                int temp = 0;
                temp += cache[i+1][j];
                temp += cache[i][j-1];
                for(int k = i + 1; k < j; k++) {
                    int left = cache[i][k-1];
                    int right = cache[k + 1][j];
                    temp += left * right;
                }
                cache[i][j] = temp;
            }
        }
        return cache[0][n-1];
    }

    public int numTrees_recursive(int n) {
        if (n < 1) {
            return 0;
        }
        cache = new int[n][n];
        for(int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return numTrees(1, n);
    }

    private int numTrees(int low, int high) {
        if (low > high) {
            return 0;
        }
        if (low == high) {
            return 1;
        }
        if (cache[low-1][high-1] >= 0) {
            return cache[low-1][high-1];
        }
        int result = 0;
        for(int i = low; i <= high; i++) {
            int left = numTrees(low, i - 1);
            int right = numTrees(i + 1, high);
            if (left == 0) {
                result += right;
            }
            else if (right == 0) {
                result += left;
            }
            else {
                result += left * right;
            }
        }
        cache[low - 1][high -1] = result;
        return result;
    }
}
