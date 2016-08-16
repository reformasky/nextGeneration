package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 8/12/16.
 */
public class DifferentWaysToAddParentheses_241Test {

    @Test
    public void test() {
        String input = "1+2*3-4";
        List<Integer> res = new DifferentWaysToAddParentheses_241().diffWaysToCompute(input);
        Assert.assertEquals(res.size(), 5);
    }
}
