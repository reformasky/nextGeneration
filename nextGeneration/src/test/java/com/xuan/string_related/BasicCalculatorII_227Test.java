package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 8/8/16.
 */
public class BasicCalculatorII_227Test {
    @Test
    public void test() {
        BasicCalculator_227 calculator = new BasicCalculator_227();
        String s = "5 +  13 * 4 - 36/ 3 + 4 * 5 / 2" ;
        Assert.assertEquals(calculator.calculate(s), 55);
    }
}
