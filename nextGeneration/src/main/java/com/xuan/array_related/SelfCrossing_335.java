package com.xuan.array_related;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xzhou2 on 9/7/16.
 */
public class SelfCrossing_335 {
    public boolean isSelfCrossing(int[] nums) {
        LinkedList<Point> v = new LinkedList<>(),
                h = new LinkedList<>();
        int x = 0, y = 0;
        Point pre = null, curr = null;
        pre = new Point(0, 0);
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            switch(i % 4) {
                case 0: val = -val;
                case 2: y -= val;
                    curr = new Point(x, y);
                    if (isCross(h, pre, curr)) {
                        return true;
                    }
                    if (v.size() >= 6) {
                        v.removeFirst();
                        v.removeFirst();
                    }
                    v.addLast(pre);
                    v.addLast(curr);
                    break;
                case 1: val = -val;
                case 3: x += val;
                    curr = new Point(x, y);
                    if (isCross(v, pre, curr)) {
                        return true;
                    }
                    if (h.size() >= 6) {
                        h.removeFirst();
                        h.removeFirst();
                    }
                    h.addLast(pre);
                    h.addLast(curr);
            }
            if (i == 4) {
                if (pre.x == 0 && curr.y >= 0 && curr.y <= v.get(1).y ) {
                    return true;
                }
            }
            pre = curr;
        }
        return false;
    }

    private boolean isCross(List<Point> list, Point pre, Point curr) {
        for(int i = 0; i < list.size() - 2; i += 2) {
            if (isCross(list.get(i), list.get(i + 1), pre, curr)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if(x1 != x2) {
            return isCross(x3, y3, x4, y4, x1, y1, x2, y2);
        }
        int maxY = Math.max(y1, y2), minY = Math.min(y1, y2), maxX = Math.max(x3, x4), minX = Math.min(x3, x4);
        if (x1 >= minX && x1 <= maxX) {return y3 >= minY && y3 <= maxY;}
        return false;
    }

    private boolean isCross(Point a, Point b, Point c, Point d) {
        return isCross(a.x, a.y, b.x, b.y, c.x, c.y, d.x, d.y);
    }

    class Point{
        int x;
        int y;
        public Point(int _x, int _y) {x = _x; y = _y;}
    }
}
