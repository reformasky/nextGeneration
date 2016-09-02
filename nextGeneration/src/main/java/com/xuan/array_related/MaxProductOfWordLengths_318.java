package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 8/29/16.
 */
public class MaxProductOfWordLengths_318 {
    public int maxProduct(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (p, q) -> (q.length() - p.length()));

        int[] bitMaps = buildBitMaps(words);
        int result = 0;
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i; j < words.length; j++) {
                int curr = words[i].length() * words[j].length();
                if (curr <= result) {
                    break;
                }
                if ((bitMaps[i] & bitMaps[j]) == 0) {
                    result = curr;
                }
            }
        }
        return result;
    }

    private int[] buildBitMaps(String[] words) {
        int[] result = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length();j++) {
                result[i] |= (1<< (words[i].charAt(j) - 'a'));
            }
        }
        return result;
    }
}
