package com.xuan.other;

import org.junit.experimental.theories.DataPoint;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

/**
 * Created by xzhou2 on 8/1/16.
 */
public class TrieTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        new Point[]{
                                new Point(1, "", true), new Point(0, "a", true), new Point(0, "abc", true),
                                new Point(1, "a", true), new Point(1, "b", false),
                                new Point(1, "ab", false), new Point(2,"ab", true),
                                new Point(1, "abc", true), new Point(2, "abc", true),
                                new Point(1, "abcd", false), new Point(2, "abcd", false),
                                new Point(0, "aaa", true), new Point(1,"aa", false), new Point(2, "aa", true)
                        }
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(Point[] points) {
        Trie trie = new Trie();
        for(Point p : points) {
            if (p.ops == 0) {
                trie.insert(p.s);
            } else if (p.ops == 1) {
                Assert.assertEquals(p.res, trie.search(p.s));
            } else {
                Assert.assertEquals(p.res, trie.startsWith(p.s));
            }
        }
    }

    class Point{
        int ops;
        String s;
        boolean res;

        public Point(int ops, String s, boolean res) {
            this.ops = ops;
            this.s = s;
            this.res = res;
        }
    }
}
