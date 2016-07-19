package com.xuan.util;

/**
 * Created by xzhou2 on 7/14/16.
 */
public class ListBuilder {
    private ListNode head;
    private ListNode tail;
    public ListBuilder(int val) {
        head = new ListNode(val);
        tail = head;
    }

    public ListBuilder add(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        return this;
    }

    public ListNode build() {
        return head;
    }
    public static ListNode buildFromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListBuilder listBuilder = new ListBuilder(values[0]);
        for(int i = 1; i < values.length;i++) {
            listBuilder = listBuilder.add(values[i]);
        }
        return listBuilder.build();
    }
}
