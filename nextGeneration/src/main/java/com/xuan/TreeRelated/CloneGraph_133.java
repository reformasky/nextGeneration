package com.xuan.TreeRelated;

import com.xuan.util.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 7/22/16.
 */
public class CloneGraph_133 {

    public UndirectedGraphNode cloneGraph_NotEfficient(UndirectedGraphNode node) {
            if (node == null) {
                return null;
            }
            Map<UndirectedGraphNode, UndirectedGraphNode> reverse = new HashMap<>();
            Set<UndirectedGraphNode> visited = new HashSet<>();
            Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                UndirectedGraphNode src = queue.poll();
                if (visited.contains(src)) {
                    continue;
                }
                UndirectedGraphNode target;
                if (reverse.containsKey(src)) {
                    target =  reverse.get(src);
                } else {
                    target = new UndirectedGraphNode(node.label);
                    reverse.put(node, target);
                }

                visited.add(src);
                for(UndirectedGraphNode n : src.neighbors) {
                    UndirectedGraphNode clone;
                    if (reverse.containsKey(n)) {
                        clone = reverse.get(n);
                    } else {
                        clone = new UndirectedGraphNode(n.label);
                        reverse.put(n, clone);
                    }
                    target.neighbors.add(clone);
                    queue.offer(n);
                }
            }
            return reverse.get(node);
    }
}
