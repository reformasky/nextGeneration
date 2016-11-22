package com.xuan.int_related;

/**
 * Created by xzhou2 on 10/15/16.
 */
public class IntToHex_405 {
    public String toHex(int num) {
        if (num == 0) {
            return  "0";
        }
        char[] arr = new char[8];
        int mask = 15;
        int index = 7;
        for(; num != 0;) {
            int curr = (mask & num);
            if (curr >= 10) {
                arr[index--] = (char)(curr - 10 + 'a');
            } else {
                arr[index--] = (char)(curr + '0');
            }
            num >>>= 4;
        }
        return new String(arr, index+1, (7 - index));
    }
}
