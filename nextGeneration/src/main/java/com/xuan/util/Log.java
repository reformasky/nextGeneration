package com.xuan.util;

/**
 * Created by xzhou2 on 9/1/16.
 */
public class Log {
    public static void log(int[] num) {
        for(int n : num) {
            System.out.print(n + ", ");
        }
        System.out.println();
    }
}