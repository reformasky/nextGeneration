package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class PalindromePairs_336Test {
    private static final PalindromePairs_336 p = new PalindromePairs_336();
    Random random = new Random();
    @Test
    public void test() {
       /* String[] input = new String[100] ;//{"", "a", "aa", "aaa", "ab", "aba", "ba", "aaba", "acba", "bca","abca", "babca", "bbabca"};
        input[0] = "";*/
        int rounds = 3000, maxLen = 20, max = 8;
        Set<String> set = new HashSet<>();
        set.add("");
        for(int i = 1; i < rounds; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < maxLen; j++)
            if (random.nextBoolean()) {
                sb.append(random.nextInt(max));
            }
            set.add(sb.toString());
        }
        String[] input = new String[set.size()];
        new ArrayList<>(set).toArray(input);
        long start = System.currentTimeMillis();
        List<List<Integer>> res = p.palindromePairs(input);
        long length1 = System.currentTimeMillis() - start;

        System.out.println(length1);
        /*for(List<Integer> l : res) {
            System.out.println(input[l.get(0)] + "---"+input[l.get(1)] );
        }*/
        start = System.currentTimeMillis();
        List<List<Integer>> alt = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input.length; j++) {
                if (i != j && isPalindrome(input[i] + input[j])) {
                    alt.add(Arrays.asList(i, j));
                }
            }
        }
        length1 = System.currentTimeMillis() - start;

        System.out.print(length1);
       /* System.out.println("**********");
        for(List<Integer> l : res) {
            System.out.println(input[l.get(0)] + "---"+input[l.get(1)] );
        }*/
        Assert.assertEquals(alt.size(), res.size());
    }

    private boolean isPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
