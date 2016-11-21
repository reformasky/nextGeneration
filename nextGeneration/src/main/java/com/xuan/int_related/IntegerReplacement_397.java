package com.xuan.int_related;

/**
 * Created by xzhou2 on 10/12/16.
 */
public class IntegerReplacement_397 {
    //proof for the greedy algs:
    /**
     * First we will demonstrate that f(2k + 1) >= f(2k) && f(2k+ 1) >= f(2k +2)
     * let just proove the first half. Let's say f(2k + 1) < f(2k), that means that f(2k +1 ) = 1 + f(2k + 2) < f(2k),
     * (the other branch, f(2k + 1) = 1 + f(2k) < f(2k) will never work), which means that 1 + 1 + f(k + 1) < 1 + f(k),
     * f(k + 1) + 1 < f(k).
     *
     */
}
