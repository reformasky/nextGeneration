package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/16/16.
 */
public class IntToEnglish_273 {
    static int[] val;
    static String[] str;
    static {
        val = new int[]{1000000000, 1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        str = new String[]{"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
    }
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            sb.append("Zero");
            return sb.toString();
        }
        for(int i = 0; i < val.length; i++) {
            if (num >= val[i]) {
                int q = num / val[i];
                if (val[i] >= 100) {
                    sb.append(numberToWords(q));
                    sb.append(" ");
                }

                sb.append(str[i]);
                num %= val[i];
                if (num != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
