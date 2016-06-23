package com.xuan.int_related;

/**
 * Created by xzhou2 on 6/21/16.
 */
public class IntToRome_12 {
    public String intToRoman(int num) {
        int[] keys = new int[]{1, 5, 10, 50, 100, 500, 1000};
        char[] vals = new char[]{'I', 'V', 'X', 'L','C','D', 'M'};
        StringBuilder sb = new StringBuilder();
        for(int i = keys.length - 1; i >= 0; i--) {
            while(num >= keys[i]) {
                sb.append(vals[i]);
                num -= keys[i];
            }
            if (num == 0) {
                break;
            }
            if (i % 2 == 0 ){
                if (num >= keys[i] - keys[i-2]) {
                    sb.append(vals[i-2]);
                    sb.append(vals[i]);
                    num -= keys[i] - keys[i-2];
                }
            }

            else {
                if(num >= keys[i] - keys[i-1]) {
                    sb.append(vals[i-1]);
                    sb.append(vals[i]);
                    num -= keys[i] - keys[i-1];
                }
            }
        }
        return sb.toString();
    }
}
