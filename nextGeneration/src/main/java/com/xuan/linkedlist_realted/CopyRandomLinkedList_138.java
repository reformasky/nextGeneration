package com.xuan.linkedlist_realted;

import com.xuan.util.RandomListNode;

/**
 * Created by xzhou2 on 7/23/16.
 */
public class CopyRandomLinkedList_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode result = new RandomListNode(-1);
        RandomListNode ori = head, des = result, via, tmp;
        while(ori != null) {
            tmp = new RandomListNode(ori.label);
            via = new RandomListNode(ori.label);
            via.next = tmp;
            via.random = ori.random;
            ori.random = via;
            des.next = tmp;
            des = des.next;
            ori = ori.next;
        }
        //set random for copy
        ori = head;
        while(ori != null) {
            tmp = ori.random;
            if (tmp.random != null) {
                des = tmp.next;
                des.random = tmp.random.random.next;
            }
            ori = ori.next;
        }
        //reconstruct ori
        ori = head;
        while(ori != null) {
            tmp = ori.random;
            ori.random = tmp.random;
            ori = ori.next;
        }
        return result.next;
    }
}
