package com.xuan.array_related;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 8/29/16.
 */
public class CountSmaller_315 {
    /*Node root = null;
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            root = insert(i, nums[i], root, res, 0);
        }
        return Arrays.asList(res);
    }

    private Node insert(int index, int val, Node root, Integer[] res, int pathSum) {
        if (root == null) {
            Node node = new Node(val, 0);
            res[index] = pathSum;
            return node;
        }
        if (root.val > val) {
            root.less++;
            root.left = insert(index, val, root.left, res, pathSum);
        } else {
            root.right = insert(index, val, root.right, res, root.less + pathSum + (root.val < val ? 1 : 0));
        }
        return root;
    }


    class Node{
        int less, val;
        Node left, right;

        public Node(int v, int l) {
            val = v;
            less = l;
        }
    }*/
/*
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int n : nums) {
            low = Math.min(low, n);
            high = Math.max(high, n);
        }
        Segment root = new Segment(low, high);
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = find(nums[i] - 1, root);
            add(nums[i], root);
        }
        return Arrays.asList(res);
    }

    private int find(int val, Segment root) {
        if (root == null) {
            return 0;
        }
        if (val >= root.high) {
            return root.count;
        }
        int mid = root.mid();
        if (val > mid) {
            return find(val, root.left) + find(val, root.right);
        } else {
            return find(val, root.left);
        }
    }

    private void add(int val, Segment root) {
        if (val < root.low || val > root.high) {
            return;
        }
        root.count++;
        if(root.low == root.high) {
            return;
        }
        int mid = root.mid();
        if (mid >= val) {
            if (root.left == null) {
                root.left = new Segment(root.low, mid);
            }
            add(val, root.left);
        } else {
            if (root.right == null) {
                root.right = new Segment(mid + 1, root.high);
            }
            add(val, root.right);
        }
    }


    class Segment{
        int low, high;
        int count;
        Segment left, right;

        public Segment(int l, int h) {
            low = l;
            high = h;
        }

        private int mid() {
            return low + (high - low) / 2;
        }
    }*/

    public List<Integer> countSmaller(int[] nums) {
        Triple[] copy = new Triple[nums.length],
                assist = new Triple[nums.length];
        for(int i = 0; i < nums.length; i++) {
            copy[i] = new Triple(i, nums[i]);
        }
        mergeSort(copy, assist, 0, nums.length - 1);
        Integer[] res = new Integer[nums.length];
        for(Triple t : copy) {
            res[t.index] = t.count;
        }
        return Arrays.asList(res);
    }

    private void mergeSort(Triple[] copy, Triple[] assist, int low, int high) {
        if (low >= high) {return; }
        int mid = low + (high - low) / 2;
        mergeSort(copy, assist, low, mid);
        mergeSort(copy, assist, mid + 1, high);
        merge(copy, assist, low, mid, high);
    }

    private void merge(Triple[] copy, Triple[] assist, int low, int mid, int high) {
        for(int i = low; i <= high; i++) {
            assist[i] = copy[i];
        }
        int left = low, right = mid + 1, curr = low;
        while(left <= mid && right <= high) {
            if (assist[left].val > assist[right].val) {
                copy[curr++] = assist[right++];
            } else {
                assist[left].count += right - mid - 1;
                copy[curr++] = assist[left++];
            }
        }
        while(left <= mid) {
            assist[left].count += right - mid - 1;
            copy[curr++] = assist[left++];
        }
        while(right <= high) {
            copy[curr++] = assist[right++];
        }
    }



    class Triple{
        int index;
        int val;
        int count;

        public Triple(int i, int v) {
            index = i;
            val = v;
            count = 0;
        }
    }
}
