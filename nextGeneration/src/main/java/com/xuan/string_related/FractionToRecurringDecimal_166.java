package com.xuan.string_related;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 7/27/16.
 */
public class FractionToRecurringDecimal_166 {
    public String fractionToDecimal(int a1,int b1){
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        long a = (long) a1, b = (long)b1;
        long r = a / b;
        if (r == 0 && ( (a > 0 && b < 0) || (a < 0 && b > 0)) ) {
            sb.append('-');
        }
        sb.append(r);
        a = a % b;
        if (a == 0) {
            return sb.toString();
        } else {
            sb.append('.');
        }

        while(a != 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            a *= 10;
            r = Math.abs(a/b);
            sb.append(r);
            a = a % b;
        }
        if (a == 0) {
            return sb.toString();
        } else {
            StringBuilder result = new StringBuilder(sb.length() + 2);
            for(int i = 0; i < map.get(a); i++) {
                result.append(sb.charAt(i));
            }
            result.append('(');
            for(int i = map.get(a); i < sb.length(); i++) {
                result.append(sb.charAt(i));
            }
            result.append(')');
            return result.toString();
        }
    }
}
