package com.xuan.other;

import com.xuan.util.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 8/22/16.
 */
public class CodecTest {
    @Test
    public void test() {
        String tree = "1,2,3,|,|,4,|,|,5,6,|,|,7,|,|";
        Codec codec = new Codec();
        TreeNode root = codec.deserialize(tree);
        String res = codec.serialize(root);
        Assert.assertEquals(res, tree);
    }
}
