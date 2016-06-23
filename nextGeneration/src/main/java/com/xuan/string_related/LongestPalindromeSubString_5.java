package com.xuan.string_related;

/**
 * Created by xzhou2 on 6/19/16.
 */
public class LongestPalindromeSubString_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] arr = new char[s.length() * 2 + 1];
        for(int i = 0; i < 2 * s.length() + 1; i++) {
            if (i % 2 == 1) {
                arr[i] = s.charAt(i/2);
            }
            else {
                arr[i] ='#';
            }
        }
       int len = 0, low = 0;
        for(int i = 1; i < arr.length; i++) {
            int l = helper(arr, i);
            if (len < 2 * (i - l) + 1) {
                low = l;
                len = 2 *(i - l) + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< len;i++) {
            if (arr[low+i] != '#')
            sb.append(arr[low+i]);
        }
        return sb.toString();
    }

    private int helper(char[] arr, int index) {
        int left = index, right = index;
        while(left > 0 && right < arr.length-1) {
            if (arr[--left] != arr[++right]) {
                left++;
                right--;
                break;
            }

        }
        return left;

    }
}
