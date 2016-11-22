package com.xuan.int_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 10/17/16.
 */
public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(0);
        if (n == 0) {
            return res;
        }
        for(int i = 1; i<= n; i++) {
            if ( i % 15 == 0) {
                res.add("FizzBuzz");
            } else if ( i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add("" + i);
            }
        }
        return res;
    }
}
