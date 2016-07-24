package com.xuan.linkedlist_related;

import com.xuan.linkedlist_realted.CopyRandomLinkedList_138;
import com.xuan.util.RandomListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 7/23/16.
 */
public class CopyRandomList_138Test {
    @Test
    public void test() {
        RandomListNode node1 = new RandomListNode(1),
                node2 = new RandomListNode(2),
                node3 = new RandomListNode(3),
                node4 = new RandomListNode(4),
                node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node3.random = node1;
        node4.random = node4;
        node5.random = node1;

        RandomListNode result = new CopyRandomLinkedList_138().copyRandomList(node1);
        Assert.assertNotNull(result);
    }
}
