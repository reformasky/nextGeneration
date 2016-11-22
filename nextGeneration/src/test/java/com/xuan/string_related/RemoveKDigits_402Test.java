package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 10/8/16.
 */
public class RemoveKDigits_402Test {
    @Test
    public void test() {
        RemoveKDigits_402 r = new RemoveKDigits_402();
        String s = "103432219";
        String res = r.removeKdigits(s,2);
        Assert.assertEquals(res,"1219");

    }
}
