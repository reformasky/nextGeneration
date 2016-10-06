package com.xuan.array_related;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 9/9/16.
 */
public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
                
        for(int n : nums1) { set1.add(n);}
        for(int n : nums2) { if (set1.contains(n)){ list.add(n);}}
        
        int[] res = new int[ list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] =  list.get(i);
        }
        return res;
    }
}
