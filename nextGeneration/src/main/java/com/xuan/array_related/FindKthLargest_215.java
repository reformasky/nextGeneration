package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/3/16.
 */
public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length -1, k);
    }

    private int findKthLargest(int[] nums, int low, int high, int k) {
        if (low == high) {
            return nums[low];
        }
        int i = low, j = high + 1;
        while(true) {
            while(i < high && nums[low] <= nums[++i]);
            while(nums[low] > nums[--j]);
            if (j <= i) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[j];
        nums[j] = nums[low];
        nums[low] = tmp;
       /* StringBuilder sb = new StringBuilder();
        sb.append("low=" + low + ", high=" + high + ", j=" + j  + ", k=" + k + ", val=" + nums[j] + "\n[");
        for(int m = 0; m < low; m++) {
            sb.append(nums[m] + ",");
        }
        sb.append("\n");
        for(int m = low; m <= high; m++) {
            sb.append(nums[m] + ",");
        }
        sb.append("\n");
        for(int m = high + 1; m < nums.length; m++) {
            sb.append(nums[m] + ",");
        }
        sb.append("]");
        System.out.println(sb.toString());*/
        if (j == k - 1) {
            return nums[j];
        } else if (j > k - 1) {
            return findKthLargest(nums, low, j -1, k);
        } else {
            return findKthLargest(nums, j + 1, high, k);
        }
    }
}
