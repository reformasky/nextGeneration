package com.xuan.array_related;

import com.xuan.util.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 7/25/16.
 */
public class MaxPointsOnALine_149 {
    static Pair zero = new Pair(0, 0);
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int result = 2;
        Map<Pair, Integer> counts;
        for(int i = 0; i < points.length; i++) {
            if (points.length - i + 1 <= result) {
                break;
            }
            counts = new HashMap<>();
            int same = 1;
            Point point = points[i];
            for(int j = i + 1; j < points.length; j++) {
                Pair p = new Pair(point.x - points[j].x, point.y - points[j].y);
                if (p.equals(zero)) {
                    same++;
                } else {
                    if(!counts.containsKey(p)) {
                        counts.put(p, 1);
                    } else {
                        counts.put(p, counts.get(p) + 1);
                    }
                }
            }
            if (counts.isEmpty()) {
                result = Math.max(result, same);
            } else for(Integer k : counts.values()) {
                result = Math.max(result, k + same);
            }
        }
        return result;
    }


    static class Pair{
        int dx, dy;
        public Pair(int x, int y) {
            if (x == 0 && y == 0) {
                dx = 0;
                dy = 0;
            }
            else if (x == 0) {
                dx = 0;
                dy = 1;
            } else if (y == 0) {
                dy = 0;
                dx = 1;
            } else {
                int gcd = gcd(x, y);
                dx = x / gcd;
                dy = y / gcd;
            }
        }

        @Override
        public boolean equals(Object that) {
            if (that instanceof Pair) {
                Pair t = (Pair)that;
                return (t.dx == dx && t.dy == dy);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return dx * 31  + dy;
        }
        private static int gcd(int x, int y) {
            while(y != 0) {
                int r = x % y;
                x = y;
                y = r;
            }
            return x;
        }
    }
}
