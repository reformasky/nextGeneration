package com.xuan.string_related;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 7/28/16.
 */
public class RepeatDNASequences_187 {
    private final int len = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<>();
        int[] map = new int[0xfffff + 1];
        char[] c = s.toCharArray();
        for(int i = 0; i <= c.length - len; i++) {
            int val = strToInt(c, i);
            map[val]++;
            if (map[val] > 1) {
                set.add(val);
            }
        }
        List<String> result = new ArrayList<>();
        for(int i : set) {
            result.add(intToStr(i));
        }

        return result;
    }

    private int strToInt(char[] str, int index) {
        int result = 0;
        for(int i = index; i < index + len; i++) {
            char c = str[i];
            result = result * 4 + charToInt(c);
        }
        return result;
    }

    private String intToStr(int num) {
        char[] c = new char[len];
        for(int i = len - 1; i >= 0; i--) {
            c[i] = intToChar(num % 4);
            num /= 4;
        }
        return new String(c);
    }

    private int charToInt(char c) {
        switch(c) {
            case 'A': return 0;
            case 'T': return 1;
            case 'G': return 2;
            case 'C': return 3;
            default:
                throw new RuntimeException();
        }
    }

    private char intToChar(int i) {
        switch(i) {
            case 0 : return 'A';
            case 1 : return 'T';
            case 2 : return 'G';
            case 3 : return 'C';
            default:
                throw new RuntimeException();
        }
    }
}
