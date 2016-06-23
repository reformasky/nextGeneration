package com.xuan.int_related;

/**
 * Created by xzhou2 on 6/21/16.
 */
public class RomanToInt_13 {
    static final int[] cache;
    static {
        cache = new int[26];
        cache['I' - 'A'] = 1;
        cache['V' - 'A'] = 5;
        cache['X' - 'A'] = 10;
        cache['L' - 'A'] = 50;
        cache['C' - 'A'] = 100;
        cache['D' - 'A'] = 500;
        cache['M' - 'A'] = 1000;
    }

    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int curr = cache[s.charAt(i) - 'A'];
            int next = i < s.length() -1 ? cache[s.charAt(i+1) - 'A'] : 0;
            if (curr < next) {
                result -= curr;
            }
            else {
                result += curr;
            }
        }
        return result;
    }
}
