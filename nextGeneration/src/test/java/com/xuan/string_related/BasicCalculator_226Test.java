package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 8/7/16.
 */
public class BasicCalculator_226Test {
    @Test
    public void test() {
        String s = "0 + 3 - 4 - ( 5 + 6) - (5 - (4 +4))";
        BasicCalculator_226 calculator = new BasicCalculator_226();
        Assert.assertEquals(calculator.calculate(s), -9);
    }
}
