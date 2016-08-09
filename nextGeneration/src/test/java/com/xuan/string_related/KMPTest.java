package com.xuan.string_related;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 8/2/16.
 */
public class KMPTest {
    @Test
    public void test() {
        for(int k = 0; k < 10; k++) {
            int n = 2;
            Random random = new Random();
            char[] s = new char[1000],
                    p = new char[9];
            for(int i = 0; i < s.length; i++) {
                s[i] = (char)(random.nextInt(n) + 'a');
            }
            for(int i = 0; i <p.length;i++) {
                p[i] = (char)(random.nextInt(n) + 'a');
            }

            int act = KMP.search(new String(s), new String(p));
            if (act >= 0) {
                System.out.println(new String(s).substring(act) + "\n" + new String(p));
                Assert.assertTrue(new String(s).substring(act).startsWith(new String(p)));
            }
        }


    }
}
