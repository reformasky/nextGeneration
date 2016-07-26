package com.xuan.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 7/25/16.
 */
public class LRUCache {
    Map<Integer, Node> map;
    int capacity, size;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(1, -1);
        tail = new Node(1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.next != tail) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.pre = tail.pre;
                node.next = tail;
                tail.pre.next = node;
                tail.pre = node;
            }
            return node.val;

        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
        } else {
            node = new Node(key, value);
            map.put(key, node);
            if (size < capacity) {
                size++;
            } else {
                Node tmp = head.next;
                head.next = tmp.next;
                tmp.next.pre = head;
                map.remove(tmp.key);
            }
        }
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }

    private static class Node {
        int key;
        int val;
        Node pre, next;

        public Node (int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
}
