package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/22/16.
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int curr = 0;
        int sum = 0;
        for(int i = 0;  i < gas.length; i++) {
            int temp = gas[i] - cost[i];
            curr += temp;
            sum += temp;
            if (curr < 0) {
                curr = 0;
                result = i + 1;
            }
        }
        if (sum >= 0) {
            return result;
        }
        return -1;
    }
}
