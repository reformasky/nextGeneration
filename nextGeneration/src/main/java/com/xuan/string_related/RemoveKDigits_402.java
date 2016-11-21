package com.xuan.string_related;

/**
 * Created by xzhou2 on 10/8/16.
 */
public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        int begin = 0, end = num.length() - 1;
        char[] arr = num.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                if ( k >= (i - begin)) {
                    k -= (i - begin);
                } else {
                    break;
                }
                begin = i + 1;
            }
        }
        if (begin >= end || k >= (end - begin + 1)) {
            return "0";
        }
        if (k == 0) {
            return new String(arr, begin, end - begin + 1);
        }

        return helper(arr, begin,end, k, '0');
    }

    public String helper(char[] arr, int begin, int end, int k, char currVal) {
        if (k == 0) {
            return new String(arr, begin, end - begin + 1);
        }
        if (currVal == '9') {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < end - begin - k; i++) {
                sb.append('9');
            }
            return sb.toString();
        }
        if (begin >= end || k >=(end - begin + 1)) {
            return "";
        }
        for(int i = begin; i <= end; i++) {
            if (arr[i] == currVal) {
                //do not take any before it, removed i - begin digits.
                if (i - begin <= k) {
                    return currVal + helper(arr, i + 1, end, k - (i - begin), currVal);
                } else {
                    //remove k before it, keep everything else.
                    return helper(arr, begin, i - 1, k, (char)(currVal + 1) ) + new String(arr, i , end - i + 1);
                }
            }
        }
        return helper(arr, begin, end, k, (char)(currVal + 1));
    }
}
