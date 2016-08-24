package com.xuan.other;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by xzhou2 on 8/22/16.
 */
public class MedianFinderTest {
    @Test
    public void test() {
        int n  = 1000;
        Random random = new Random();
        List<Integer> list = new ArrayList<>(n);
        MedianFinder m = new MedianFinder();
        for(int i = 0; i < n; i++) {
            int num = random.nextInt(n);
            m.addNum(num);
            list.add(num);
            Assert.assertEquals(m.findMedian(), median(list));
        }
    }

    private double median(List<Integer> list) {
        Collections.sort(list);
        return list.size() % 2 == 0 ? 0.5 * (list.get(list.size()/ 2 - 1) + list.get(list.size()/ 2)) :
                1.0 * list.get(list.size() / 2);
    }
}
