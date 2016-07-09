package com.xuan.int_releated;

import com.xuan.int_related.Sqrt_69;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class Sqrt_69Test {
    static Logger logger = LoggerFactory.getLogger(Sqrt_69Test.class);

    @Test
    public void test() {
        Sqrt_69 sqrt_69 = new Sqrt_69();
        for(int i = 0; i < 1024; i++) {
            logger.info(String.format("i=%d, r=%d", i, sqrt_69.mySqrt(i)));
        }
    }
}
