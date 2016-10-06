package com.xuan.other;

import com.xuan.array_related.IntegerBreak_343;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by xzhou2 on 9/29/16.
 */
public class RandomizeSetTest {
    //0: insert; 1, remove; 2, random
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
            new Object[]{
                   "0,1,0;0,1,1;0,2,0;0,2,1;0,2,1;1,1,0;1,1,0;1,2,0;0,1,0;1,2,0"
            }
        };
    }

    @Test(dataProvider = "data")
    public void test(String ops) {
        RandomizedCollection randomizedSet = new RandomizedCollection();
        String[] tokens = ops.split(";");
        for(String t : tokens) {
            String[] curr = t.split(",");
            for(int i = 0; i < curr.length; i++) {
                curr[i] = curr[i].trim();
            }
            switch (Integer.parseInt(curr[0])) {
                case 0:
                    Assert.assertEquals(randomizedSet.insert(Integer.parseInt(curr[1])), Integer.parseInt(curr[2]) == 0);
                    break;
                case 1:
                    Assert.assertEquals(randomizedSet.remove(Integer.parseInt(curr[1])), Integer.parseInt(curr[2]) == 0);
                    break;
                case 2:
                    Map<Integer, Integer> count = new HashMap<>();
                    for(int i = 0; i < Integer.parseInt(curr[1]); i++) {
                        int val = randomizedSet.getRandom();
                        if (count.containsKey(val)) {
                            count.put(val, count.get(val) + 1);
                        } else {
                            count.put(val, 1);
                        }
                    }
                    for(int i : count.keySet()) {
                        System.out.print(i + "  -> " + count.get(i) + " || ");
                    }
                    System.out.println();
            }
        }
    }


}
