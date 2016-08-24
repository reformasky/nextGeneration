package com.xuan.int_related;

import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 8/22/16.
 */
public class NImGame_291 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>((p, q) -> (- p.compareTo(q)));
}
