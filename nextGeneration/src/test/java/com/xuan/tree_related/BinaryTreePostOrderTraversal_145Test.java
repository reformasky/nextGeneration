package com.xuan.tree_related;

import com.xuan.TreeRelated.BinaryTreePostOrderTraversal_145;
import com.xuan.TreeRelated.SortedListToBST_109;
import com.xuan.util.ListBuilder;
import com.xuan.util.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/24/16.
 */
public class BinaryTreePostOrderTraversal_145Test {
    @Test
    public void test() {
        TreeNode root = new SortedListToBST_109().sortedListToBST(ListBuilder.buildFromArray(new int[]{2,1}));
        List<Integer> result = new BinaryTreePostOrderTraversal_145().postorderTraversal(root);
        Assert.assertEquals(result.size(), 10);
    }
}
