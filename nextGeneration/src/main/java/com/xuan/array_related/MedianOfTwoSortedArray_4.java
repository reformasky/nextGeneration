package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/17/16.
 */
public class MedianOfTwoSortedArray_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //assume here that both nums1 and nums2 is not null;
        int len1 = nums1.length, len2 = nums2.length;
        int total = len1 + len2;
        if (total % 2 == 1) {
            return (double)findKth(nums1, 0, len1, nums2, 0, len2, total/2 +1);
        }
        else {
            return 0.5 * (findKth(nums1, 0, len1, nums2, 0, len2, total /2 +1) +
                    findKth(nums1, 0, len1, nums2, 0, len2, total/2));
        }
    }

    public int findKth(int[] nums1, int low1, int len1, int[] nums2, int low2, int len2, int k) {
        if (len1 > len2) {
            return findKth(nums2, low2, len2, nums1, low1, len1, k);
        }
        if (len1==0) {
            return nums2[low2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[low1], nums2[low2]);
        }

        int pa = Math.min(k / 2, len1);
        int pb = k - pa;
        if (nums1[low1 + pa - 1] == nums2[low2 + pb - 1]) {
            return nums1[low1 + pa - 1];
        }
        else if (nums1[low1 + pa - 1] > nums2[low2 + pb -1]) {
            return findKth(nums1, low1, len1, nums2, low2 + pb, len2 - pb, k - pb);
        }
        else {
            return findKth(nums1, low1 + pa, len1 - pa, nums2, low2, len2, k - pa);
        }
    }

    public double findMedianSortedArrays_sol2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays_sol2(nums2, nums1);
        }

        int min_i = 0, max_i = len1 * 2, half_len = (len1 + len2 + 1 ) /2;
        int max_left, min_right;
        while(min_i <= max_i) {
            int i = min_i + (max_i - min_i) / 2;
            int j = half_len - i;
            if (i > 0 && j < len2 && nums1[i-1] > nums2[j]) {
                max_i = i - 1;
            }
            else if (j >0 && i < len1 && nums2[j-1] > nums1[i]) {
                min_i = i + 1;
            }
            else {
                if (i == 0) {
                    max_left = nums2[j-1];

                }
                else if (j == 0) {
                    max_left = nums1[i-1];
                }
                else {
                    max_left = Math.max(nums2[j-1], nums1[i-1]);
                }

                if ((len1 + len2) % 2 == 1) {
                    return 1.0 * max_left;
                }

                if (i >= len1) {
                    min_right = nums2[j];
                }
                else if (j >= len2) {
                    min_right = nums1[i];
                }
                else {
                    min_right = Math.min(nums1[i], nums2[j]);
                }

                return 0.5 * (max_left + min_right);
            }
        }
        return 0;
    }
}
