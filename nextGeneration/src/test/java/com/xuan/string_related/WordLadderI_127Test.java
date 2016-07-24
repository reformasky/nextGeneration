package com.xuan.string_related;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 7/19/16.
 */
public class WordLadderI_127Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "red","tax" , new String[] {"ted","tex","red","tax","tad","den","rex","pee"},5
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String begin, String end, String[] strings, int result) {
        Set<String> wordList = new HashSet<>(Arrays.asList(strings));
       List<List<String >> result1= new WordLadderII_128().findLadders(begin,end, wordList);
        int actualResult = new WordLadderI_127().ladderLength(begin, end, wordList);
        Assert.assertEquals(actualResult, result);
    }
}
