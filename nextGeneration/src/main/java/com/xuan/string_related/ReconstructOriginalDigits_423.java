package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xzhou2 on 10/18/16.
 */
public class ReconstructOriginalDigits_423 {
    public String originalDigits(String s) {
        int[] counts = new int[26];

        int[] res = new int[10];
        int[][] primaryKey = new int[][]{
                {'z', 0}, {'w', 2}, {'x',6},{'g',8},
                {'h', 3}, {'r', 4}, {'f', 5}, {'v', 7}, {'o', 1},{'i', 9}
        };
        for(int[] i : primaryKey) {
            i[0] -= 'a';
        }
        String[] secondaryKey = new String[]{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for(int[] pk : primaryKey) {
            int times = counts[pk[0]];
            res[pk[1]] += times;
            minus(counts, secondaryKey[pk[1]], times);
        }
        StringBuilder sb = new StringBuilder(res.length);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < res[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    private void minus(int[] counts, String key, int times) {
        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            counts[index] -= times;
        }
    }

}
