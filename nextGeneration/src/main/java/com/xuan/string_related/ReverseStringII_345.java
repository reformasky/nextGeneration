package com.xuan.string_related;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class ReverseStringII_345 {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while(true) {
            while(low < high && !isVowel(c[low])) {low++;}
            while(high > low && ! isVowel(c[high])){high--;}
            if (low < high) {
                char t = c[low];
                c[low++] = c[high];
                c[high--] = t;
            } else {
                break;
            }
        }
        return new String(c);
    }

    private boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':

                return true;
            default:
                return false;
        }
    }
}
