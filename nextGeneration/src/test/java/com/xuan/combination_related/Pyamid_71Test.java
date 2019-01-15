package com.xuan.combination_related;


import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pyamid_71Test {
    @Test
    public void test() {
        String bottom = "XXYX";
        List<String> allowed = Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ");
        Pyramid_756 pyamid71 = new Pyramid_756();
        Assert.assertFalse(pyamid71.pyramidTransition(bottom, allowed));
    }

    @Test
    public void testFile() throws FileNotFoundException {
        long num = 1;
        num <<= 1;
        System.out.println(num);
    }

}
