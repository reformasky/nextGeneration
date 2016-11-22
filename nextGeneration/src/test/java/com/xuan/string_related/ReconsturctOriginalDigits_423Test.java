package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by xzhou2 on 10/18/16.
 */
public class ReconsturctOriginalDigits_423Test {
    String[] secondaryKey = new String[]{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    @Test
    public void test(){
        int len = 100;
        Random random = new Random();
        List<Integer> ints = new ArrayList<>(len);
        for(int i = 0; i < len; i++) {
            ints.add(random.nextInt(10));
        }
        List<Character> chars = new ArrayList<>();
        for(int i : ints) {
            for(char c : secondaryKey[i].toCharArray()) {
                chars.add(c);
            }
        }
        Collections.shuffle(chars);
        StringBuilder sb = new StringBuilder(chars.size()), exp = new StringBuilder();
        for(char c : chars) {
            sb.append(c);
        }
        ReconstructOriginalDigits_423 r = new ReconstructOriginalDigits_423();
        String res = r.originalDigits(sb.toString());
        Collections.sort(ints);
        for(int i : ints) {
            exp.append(i);
        }
        Assert.assertEquals(res, exp.toString());


    }
}
