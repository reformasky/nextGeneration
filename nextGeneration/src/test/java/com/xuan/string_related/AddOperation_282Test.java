package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 8/17/16.
 */
public class AddOperation_282Test {

    @Test
    public void test() {
        String input =
        "2147483648";
        int target = -2147483648;
        AddOperations_282 object = new AddOperations_282();
        List<String> res = object.addOperators(input, target);
        Assert.assertEquals(res.size(), 2);
    }
}
