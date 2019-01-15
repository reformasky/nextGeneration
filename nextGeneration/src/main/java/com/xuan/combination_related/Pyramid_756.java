package com.xuan.combination_related;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pyramid_756 {
    Set<String> seen = new HashSet<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<Integer, List<Character>> map = new HashMap<>();
        for(String a : allowed) {
            Integer key = 0;
            key += (a.charAt(0) - 'A') * 10 + (a.charAt(1) - 'A');
            Character val = a.charAt(2);
            List<Character> l = map.get(key);
            if (l == null) {
                l = new ArrayList<>();
                map.put(key, l);
            }
            l.add(val);
        }
        if (dfs(bottom.toCharArray(),0, new char[bottom.length() - 1], map)) {
            return true;
        }
        return false;
    }

    private boolean dfs(char[] bottom, int index, char[] path, Map<Integer, List<Character>> map) {
        if (bottom.length == 1) {
            return true;
        }
        if (index == bottom.length - 1) {
            if (seen.contains(new String(path))) {
                return false;
            }
            return dfs(path, 0, new char[path.length - 1], map);
        }

        Integer key = (bottom[index] - 'A') * 10 + (bottom[index + 1] - 'A');
        List<Character> val = map.get(key);
        if (val == null) {
            return false;
        }
        for(Character c : val) {
            path[index] = c;
            if (dfs(bottom, index + 1, path, map)){
                return true;
            }
        }
        seen.add(new String(bottom));
        return false;
    }
}
