package com.xuan.array_related;

import com.xuan.string_related.StrStr_28;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

/**
 * Created by xzhou2 on 9/7/16.
 */
public class ReconstructItinerary_332Test {
    @Test
    public void test() {
        ReconstructItinerary_332 r = new ReconstructItinerary_332();
        String s = //"JFK,SFO,JFK,ATL,SFO,ATL,ATL,JFK,ATL,SFO";
                "EZE,TIA,EZE,HBA,AXA,TIA,JFK,AXA,ANU,JFK,ADL,ANU,TIA,AUA,ANU,AUA,ADL,EZE,ADL,EZE,EZE,ADL,AXA,EZE,AUA,AXA,JFK,AXA,AXA,AUA,AUA,ADL,ANU,EZE,TIA,ADL,EZE,ANU,AUA,ANU";
        String[][] input =generate(s);
        List<String> res = r.findItinerary(input);
        print(res);
        Assert.assertEquals(res.size(), input.length + 1);
    }

    public void print(List res) {
        for(Object o : res) {
            System.out.print( "\""+ o + "\",");
        }
    }

    public static String[][] generate(String s) {
        String[] tokens = s.split(",");
        String[][] res = new String[tokens.length / 2][2];
        for(int i = 0; i < tokens.length; i+=2) {
            res[i/2] = new String[]{tokens[i].trim(), tokens[i + 1].trim()};
        }
        return res;
    }
}
