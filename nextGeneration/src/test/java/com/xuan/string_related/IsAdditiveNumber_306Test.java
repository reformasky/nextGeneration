package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 8/23/16.
 */
public class IsAdditiveNumber_306Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "112358", true
                },
                {
                        "199100199", true
                },
                {
                        "0111111", true
                },
                {
                        "001111", false
                },
                {
                        "111222333555", true
                },
                {
                        "198019823962", true
                }
        };
    }



    @Test(dataProvider = "data")
    public void test(String s, boolean res) {
        IsAdditiveNumber_306 object = new IsAdditiveNumber_306();
        Assert.assertEquals(object.isAdditiveNumber(s), res);
    }
}
