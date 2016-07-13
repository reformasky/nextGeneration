package com.xuan.string_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/10/16.
 */
public class RestoreIpAddress_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4) {
            return result;
        }
        dfs(s.toCharArray(), 0, new int[4],0,  result);
        return result;
    }

    private void dfs(char[] arr, int cIndex, int[] path, int iIndex, List<String> result) {
        if (cIndex >= arr.length && iIndex >= 4) {
            StringBuilder sb = new StringBuilder(arr.length + 3);
            sb.append(path[0]);
            for(int i = 1; i < 4; i++) {
                sb.append('.');
                sb.append(path[i]+"");
            }
            result.add(sb.toString());
            return;
        }
        if (cIndex >= arr.length || iIndex >= 4) {
            return;
        }
        int curr = 0;
        int leftOverDigits, needDigits = 4 - iIndex - 1;
        for(int i = cIndex; i < Math.min(cIndex + 3, arr.length); i++) {
            curr = 10 * curr + arr[i] - '0';
            leftOverDigits = arr.length - i - 1;
            if (leftOverDigits >= needDigits && leftOverDigits <= 3 * needDigits && curr < 256) {
                path[iIndex] = curr;
                dfs(arr, i + 1, path, iIndex + 1, result);
            }
            if (curr == 0) {
                break;
            }
        }
    }
}
