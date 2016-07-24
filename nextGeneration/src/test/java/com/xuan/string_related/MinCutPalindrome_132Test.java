package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 7/21/16.
 */
public class MinCutPalindrome_132Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "ccaacabacb",3
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, int res) {
        Assert.assertEquals(new MinCutPalindrome_132().minCut_DP(s), res);
    }
}
