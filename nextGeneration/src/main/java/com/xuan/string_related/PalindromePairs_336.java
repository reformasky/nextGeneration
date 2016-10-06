package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class PalindromePairs_336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, List<Integer>> suffix = new HashMap<>();
        Map<Integer, List<String>> prefix = new HashMap<>();
        Map<String, Integer> wholeWord = new HashMap<>();
        buildMap(words, suffix, prefix, wholeWord);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (suffix.containsKey(reverse)) {
                for(int j : suffix.get(reverse)) {
                    if (j != i) {
                        result.add(Arrays.asList(i,j));
                    }
                }
            }

            for(String s : prefix.get(i)) {
                reverse = new StringBuilder(s).reverse().toString();
                if (wholeWord.containsKey(reverse)) {
                    int j = wholeWord.get(reverse);
                    if (j != i) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }
        }

        return result;
    }

    private void buildMap(String[] words, Map<String, List<Integer>> suffix, Map<Integer, List<String>> prefix, Map<String, Integer> wholeWord) {
        for(int i = 0; i < words.length; i++) {
            wholeWord.put(words[i], i);
            for(int j = -1; j < words[i].length(); j++) {
                if (isPalindrome(words[i], 0, j)) {
                    String s = words[i].substring(j + 1);
                    if (!suffix.containsKey(s)) {
                        suffix.put(s, new ArrayList<>());
                    }
                    suffix.get(s).add(i);
                }
            }
            prefix.put(i, new ArrayList<>());
            for(int j = words[i].length() - 1; j >= 0; j--) {
                if (isPalindrome(words[i], j, words[i].length() - 1)) {
                    prefix.get(i).add(words[i].substring(0, j));
                }
            }
        }
    }

    private boolean isPalindrome(String word, int begin, int end) {
        while(begin < end) {
            if (word.charAt(begin++) != word.charAt(end--)) {return false;}
        }
        return true;
    }
}
