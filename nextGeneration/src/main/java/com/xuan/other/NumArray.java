package com.xuan.other;

/**
 * Created by xzhou2 on 8/24/16.
 */
public class NumArray {
    int[] bits;
    int[] nums;
    int len;
    public NumArray(int[] nums) {
        len = nums.length;
        this.nums = nums;
        bits = new int[len + 1];
        for(int i = 0; i < len; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
        i++;
        while(i <= len) {
            bits[i] += val;
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    private int getSum(int i) {
        int sum = 0;
        i++;
        while(i > 0) {
            sum += bits[i];
            i -= (i & -i);
        }
        return sum;
    }
}

/*
public class NumArray {
    Node root;
    int[] nums;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
        this.nums = nums;
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        Node node = root;
        while(node != null) {
            node.sum += diff;
            int mid = node.begin + (node.end - node.begin) / 2;
            if (i <= mid) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

    }

    public int sumRange(int i, int j) {
        return sumRange(i, j, root);
    }

    private int sumRange(int i, int j, Node root) {
        if (root.begin == i && root.end == j) {
            return root.sum;
        }
        int mid = root.begin + (root.end - root.begin) / 2;
        if (mid >= j) {
            return sumRange(i, j, root.left);
        } else if (mid < i) {
            return sumRange(i, j, root.right);
        } else {
            return sumRange(i, mid, root.left) + sumRange(mid + 1, j, root.right);
        }
    }

    private Node buildTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        Node node = new Node(begin, end);
        if (begin == end) {
            node.sum = nums[begin];
        } else {
            int mid = begin + (end - begin) / 2;
            node.left = buildTree(nums, begin, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }


    class Node {
        int begin, end, sum;
        Node left, right;
        Node(int b, int e) {
            begin = b;
            end = e;
        }
    }
}
*/
