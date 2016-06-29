package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 6/26/16.
 */
public class FindAllSubString_30Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "barfoothefoobarman", new String[]{"foo","bar"}, new int[]{0,9}

                },
                {
                        "abcabbcabbbc", new String[]{"a","b", "c"}, new int[]{0,1,2,5,6}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String str, String[] words, int[] result) {
        List<Integer> act = new FindAllSubString_30().findSubstring(str, words);
        Assert.assertEquals(act.size(), result.length);
    }
}
