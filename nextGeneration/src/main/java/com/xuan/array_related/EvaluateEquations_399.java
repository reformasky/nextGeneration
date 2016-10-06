package com.xuan.array_related;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 9/15/16.
 */
public class EvaluateEquations_399 {
    Map<String, Integer> keyMap;
    List<Map<Integer, Double>> valList;
    int len;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        keyMap = new HashMap<>();
        valList = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < equations.length;i++) {
            String s1 = equations[i][0], s2 = equations[i][1];
            double val = values[i];
            int c1, c2;
            if (keyMap.containsKey(s1)) {
                c1 = keyMap.get(s1);
            } else {
                c1 = count++;
                keyMap.put(s1, c1);
                valList.add(new HashMap<>());
            }
            if (keyMap.containsKey(s2)) {
                c2 = keyMap.get(s2);
            } else {
                c2 = count++;
                keyMap.put(s2, c2);
                valList.add(new HashMap<>());
            }
            valList.get(c1).put(c2, val);
            valList.get(c2).put(c1, 1 / val);
        }
        len = valList.size();
        double[] res = new double[queries.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = dfs(queries[i]);
        }
        return res;
    }

    private double dfs(String[] query) {
        if (!keyMap.containsKey(query[0]) || !keyMap.containsKey(query[1])) {
            return -1.0;
        }
        int d1 = keyMap.get(query[0]), d2 = keyMap.get(query[1]);
        if (d1 == d2) {return 1.0;}
        boolean[] visited = new boolean[len];
        visited[d1] = true;
        return dfs(d1, d2, visited);
    }

    private double dfs(int d1, int d2, boolean[] visited) {
        if (d1 == d2) { return  1.0;}
        Map<Integer, Double> map = valList.get(d1);
        if (map.containsKey(d2)) {
            return map.get(d2);
        }
        for(Integer i : map.keySet()) {
            if (!visited[i]) {
                visited[i] = true;
                double next = dfs(i, d2, visited);
                if (next > -0.5) {
                    double res = map.get(i) * next;
                    map.put(d2, res);
                    valList.get(d2).put(d1, 1 / res);
                    return res;
                }
            }
        }
        return -1.0;
    }
}
