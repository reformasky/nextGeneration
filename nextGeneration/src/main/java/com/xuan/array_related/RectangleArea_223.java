package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/6/16.
 */
public class RectangleArea_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int size1 = (C - A) * (D - B), size2 = (G - E) * (H - F);
        return size1 + size2 - overlap(A, B, C, D, E, F, G, H);
    }

    private int overlap(int a, int b, int c, int d, int e, int f, int g, int h) {
        if (a > e) {
            return overlap(e, f, g, h, a, b, c,d);
        }

        if (c <= e  || d <= f || b >= h) {
            return 0;
        }
        int hi;

        if (h > d) {
            if (b > f) {
                hi = d - b;
            } else {
                hi = d - f;
            }
        } else {
            if (b > f) {
                hi = h - b;
            } else {
                hi = h - f;
            }
        }
        return (Math.min(c, g) - e) * hi;
    }
}
