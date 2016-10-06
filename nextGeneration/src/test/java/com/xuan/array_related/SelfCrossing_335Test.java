package com.xuan.array_related;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 9/7/16.
 */
public class SelfCrossing_335Test {
    private static SelfCrossing_335 s = new SelfCrossing_335();

    @Test
    public void test() {
        int[] input = new int[]{1,2,3,4,5,1,7,8};
        boolean res = s.isSelfCrossing(input);
        Assert.assertTrue(res);
    }
}
