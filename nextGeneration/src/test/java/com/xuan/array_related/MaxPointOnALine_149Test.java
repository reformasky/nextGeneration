package com.xuan.array_related;

import com.xuan.util.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 7/25/16.
 */
public class MaxPointOnALine_149Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {new Point[]{new Point(0,-12),new Point(5,2),new Point(2,5),new Point(0,-5),new Point(1,5),new Point(2,-2),new Point(5,-4),new Point(3,4),new Point(-2,4),new Point(-1,4),new Point(0,-5),new Point(0,-8),new Point(-2,-1),new Point(0,-11),new Point(0,-9)}, 5}

        };
    }

    @Test(dataProvider = "data")
    public void test(Point[] points, int result) {
        int actualResult = new MaxPointsOnALine_149().maxPoints(points);
        Assert.assertEquals(actualResult, result);
    }
}
