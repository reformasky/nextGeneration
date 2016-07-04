package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 7/1/16.
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String b = base(str);
            if (! map.containsKey(b)) {
                map.put(b, new ArrayList<String>());
            }
            map.get(b).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String base(String str) {
        char[] chars = str.toCharArray();
        if (str.length() < 26) {
            Arrays.sort(chars);
            return new String(chars);
        }
        StringBuilder sb = new StringBuilder(str.length());
        int[] cache = new int[26];
        for(int i = 0; i < str.length(); i++) {
            cache[chars[i] - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < cache[i]; j++) {
                sb.append(i+'a');
            }
        }
        return sb.toString();
    }
}
