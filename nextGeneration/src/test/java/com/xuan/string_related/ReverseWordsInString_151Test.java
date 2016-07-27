package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class ReverseWordsInString_151Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"this is  a good  day", "day good a is this"},
                {" this is  a good  day ", "day good a is this"},
                {"    this              is  a good  day    ", "day good a is this"},
                {"    ", ""},
                {"",""}
        };
    }

    @Test(dataProvider = "data")
    public void test(String input, String res) {
        String act = new ReverseWordsInString_151().reverseWords(input);
        Assert.assertEquals(act, res);
    }

}
