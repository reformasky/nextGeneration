package com.xuan.tree_related;

import com.xuan.TreeRelated.CloneGraph_133;
import com.xuan.util.UndirectedGraphNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 7/22/16.
 */
public class CloneGraph_133Test {

    @Test
    public void test() {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0),
                node1 = new UndirectedGraphNode(1),
                node2 = new UndirectedGraphNode(2),
                node3 = new UndirectedGraphNode(3),
                node4 = new UndirectedGraphNode(4),
                node5 = new UndirectedGraphNode(5);

        node0.neighbors.add(node1);
        node1.neighbors.add(node0);

        node0.neighbors.add(node5);
        node5.neighbors.add(node0);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        node1.neighbors.add(node5);
        node5.neighbors.add(node1);

        node2.neighbors.add(node3);
        node3.neighbors.add(node2);

        node3.neighbors.add(node4);
        node4.neighbors.add(node3);

        node3.neighbors.add(node4);
        node4.neighbors.add(node3);

        node4.neighbors.add(node5);
        node5.neighbors.add(node4);

        node4.neighbors.add(node5);
        node5.neighbors.add(node4);

        node5.neighbors.add(node5);
        node5.neighbors.add(node5);

        UndirectedGraphNode graphNode = new CloneGraph_133().cloneGraph_NotEfficient(node0);
        Assert.assertNotNull(graphNode);
    }
}
