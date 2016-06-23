package com.xuan.array_related.com.xuan.string_related;

import com.xuan.string_related.RegularExpression_10;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 6/21/16.
 */
public class RegularExpression_10Test {

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {"", "a*", true},
                {"", ".*", true},
                {"", "", true},
                {"aa","a", false},
                {"aa","aa", true},
                {"aaa","aa", false},
                {"aa", "a*",true},
                {"aa", ".*",true},
                {"ab", ".*",true},
                {"aabbc", ".*a*b.*",true}
        };
    }

    @Test(dataProvider = "data")
    public void test(String s, String p, boolean exp) {
        RegularExpression_10 regular = new RegularExpression_10();
        Assert.assertEquals(regular.isMatch(s, p), exp);
    }

}
