package com.xuan.array_related;

import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 8/29/16.
 */
public class CountSmaller_315Test {
    @Test
    public void test(){
        int[] nums = new int[]{4,2,5,3,0,2,1,0};
        new CountSmaller_315().countSmaller(nums);
    }
}
