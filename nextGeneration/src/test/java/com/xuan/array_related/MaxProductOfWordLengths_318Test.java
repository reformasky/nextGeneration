package com.xuan.array_related;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 8/29/16.
 */
public class MaxProductOfWordLengths_318Test {

    @Test
    public void test() {
        String[] input = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        MaxProductOfWordLengths_318 maxProductOfWordLengths_318 = new MaxProductOfWordLengths_318();
        Assert.assertEquals(maxProductOfWordLengths_318.maxProduct(input), 16);
    }
}
