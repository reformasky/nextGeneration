package com.xuan.string_related;

/**
 * Created by xzhou2 on 6/30/16.
 */
public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int left1 = 0, left2 = 0;
        boolean isNeg = false;
        if (num1.charAt(0) == '-') {
            isNeg = !isNeg;
            left1++;
        }
        if (num2.charAt(0) == '-') {
            isNeg = !isNeg;
            left2++;
        }
        int[] result = new int[num1.length() + num2.length()];
        int index=result.length, curr, carryOver;
        for(int i = num2.length() - 1; i >= left2; i--) {
            index = result.length - num2.length() + i;
            carryOver = 0;
            for(int j = num1.length() - 1; j >= left1; j--) {
                curr = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carryOver + result[index];
                result[index--] = curr % 10;
                carryOver = curr / 10;
            }
            if (carryOver != 0) {
                result[index--] = carryOver;
            }
        }

        StringBuilder sb = new StringBuilder(result.length);
        int i = index + 1;
        while(i < result.length && result[i] == 0) {
            i++;
        }
        for(; i < result.length; i++) {
            sb.append(result[i]);
        }
        if (sb.length() == 0 ) {
            sb.append(0);
        }
        return isNeg ? "-" + sb.toString() : sb.toString();
    }
}
