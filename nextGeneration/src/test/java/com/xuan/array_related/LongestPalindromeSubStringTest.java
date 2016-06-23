package com.xuan.array_related;

import com.xuan.string_related.LongestPalindromeSubString_5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 6/19/16.
 */
public class LongestPalindromeSubStringTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test() {
        String s = "abb";
        logger.info(new LongestPalindromeSubString_5().longestPalindrome(s));
    }
}
