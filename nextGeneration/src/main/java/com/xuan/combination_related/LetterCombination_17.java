package com.xuan.combination_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 6/23/16.
 */
public class LetterCombination_17 {
    static List<Character>[] map =  (List<Character>[]) new List[10];
    static {
        map[2] = Arrays.asList('a','b','c');
        map[3] = Arrays.asList('d','e','f');
        map[4] = Arrays.asList('g', 'h','i');
        map[5] = Arrays.asList('j','k','l');
        map[6] = Arrays.asList('m','n','o');
        map[7] = Arrays.asList('p','q','r','s');
        map[8] = Arrays.asList('t','u','v');
        map[9] = Arrays.asList('w','x','y','z');
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        helper(digits, 0, new char[digits.length()], result);
        return result;
    }

    private void helper(String digits, int index, char[] path, List<String> result) {
        if (index >= digits.length()) {
            result.add(new String(path));
        } else {
            int i = digits.charAt(index) - '0';
            for(char c : map[i]) {
                path[index] = c;
                helper(digits, index+1, path, result);
            }
        }
    }
}
