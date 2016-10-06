package com.xuan.array_related;

/**
 * Created by xzhou2 on 9/1/16.
 */
public class CountRangeSum_327 {
    int result = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) {return result;}
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) { sums[i] = sums[i - 1] + nums[i];}
        helper(sums, lower, upper, 0, nums.length - 1, new long[nums.length]);
        return result;
    }

    private void helper(long[] sums, int lower, int upper, int left, int right, long[] assist) {
        if (left == right) {result += (sums[left] >= lower && sums[left] <= upper) ? 1 : 0;}
        if (left < right ) {
            int mid = left + (right - left) / 2;
            helper(sums, lower, upper, left, mid, assist);
            helper(sums, lower, upper, mid + 1, right, assist);
            int i = mid + 1, j = mid + 1;
            for(int index = left; index < mid + 1; index++) {
                while(i <= right && sums[i] - sums[index] < lower) {
                    i++;
                }
                while(j <= right && sums[j] - sums[index] <= upper) {
                    j++;
                }
                if (i > right) {
                    break;
                }
                result += j - i;
            }
            merge(sums, left, mid, right, assist);
        }
    }

    private void merge(long[] sums, int left, int mid, int right, long[] assist) {
        for(int i = left; i <= right; i++) {
            assist[i] = sums[i];
        }

        int l = left, r = mid + 1, index = l;

        while(l <= mid && r <= right) {
            if (assist[l] < assist[r]) {sums[index++] = assist[l++];}
            else { sums[index++] = assist[r++];}
        }
        while(l <= mid) { sums[index++] = assist[l++];}
        while(r <= right) { sums[index++] = assist[r++];}
    }
}
