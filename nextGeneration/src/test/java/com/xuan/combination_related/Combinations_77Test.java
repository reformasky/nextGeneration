package com.xuan.combination_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 7/7/16.
 */
public class Combinations_77Test {
    Combinations_77 combinations_77 = new Combinations_77();

    @Test
    public void test() {
        List<List<Integer>> result = combinations_77.combine_dfs(5,3);
        Assert.assertEquals(result.size(), 60);
    }
}
