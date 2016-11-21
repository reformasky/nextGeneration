package com.xuan.string_related;

/**
 * Created by xzhou2 on 10/13/16.
 */
public class AddedStrings_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carryOver = 0;
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        while(index1 >= 0 && index2 >= 0) {
            carryOver += num1.charAt(index1--) - '0' + num2.charAt(index2--) - '0';
            sb.append(carryOver % 10);
            carryOver /= 10;
        }
        if (index1 < 0) {
            index1 = index2;
            num1 = num2;
        }
        while(index1 >= 0) {
            carryOver += num1.charAt(index1--) - '0';
            sb.append(carryOver % 10);
            carryOver /= 10;
        }
        if (carryOver > 0) {
            sb.append(carryOver);
        }
        return sb.reverse().toString();
    }
}
