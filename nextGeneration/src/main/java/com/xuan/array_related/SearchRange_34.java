package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/27/16.
 */
public class SearchRange_34 {
    public int[] searchRange_better(int[] A, int target) {
        int index = binarySearch(A, 0, A.length-1, target);
        int[] result = {-1, -1};
        if (index != -1) {
            int left  = index;
            int right = index;
            result[0] = left;
            result[1] = right;
            while ((left  = binarySearch(A, 0, left-1, target)) != -1)           result[0] = left;
            while ((right = binarySearch(A, right+1, A.length-1, target)) != -1) result[1] = right;
        }
        return result;
    }

    public int[] searchRange_divideAndConquer(int[] A, int target) {
        return search(A, 0, A.length - 1, target);
    }

    private int[] search(int[] a, int low, int high, int target) {
        if(a[low] == a[high] && a[low] == target) {
            return new int[]{low, high};
        }
        if (a[low] <= target && target <= a[high]) {
            int mid = low + (high - low)/2;
            int[] left = search(a, low, mid, target);
            int[] right = search(a, mid+1, high, target);
            if (left[0] == -1) {
                return right;
            }
            if (right[0] == -1) {
                return left;
            }
            return new int[]{left[0], right[1]};
        }
        else {
            return new int[]{-1, -1};
        }
    }

    private int binarySearch(int[] A, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (A[mid] < target) lo = mid + 1;
            else if (A[mid] > target) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (high + low) /2;
            if (nums[mid] == target) {
                low = mid;
                break;
            }
            else if (nums[mid] > target) {
                high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
        if (low  >= nums.length || nums[low] != target) {
            return new int[]{-1, -1};
        }
        int left = find(nums, 0, low - 1, target, true);
        int right = find(nums, low + 1, nums.length -1, target, false);
        return new int[]{left, right};
    }

    private int find(int[] nums, int low, int high, int target, boolean left) {
        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (left) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (left) {
                    low = mid + 1;
                }
                else {
                    high = mid -1;
                }
            }
        }
        if (left && high < 0) {
            return 0;
        }
        if (!left && low >= nums.length) {
            return nums.length - 1;
        }
        return nums[low] == target ? low : high;
    }

}
