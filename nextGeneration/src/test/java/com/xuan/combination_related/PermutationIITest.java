package com.xuan.combination_related;

import com.xuan.util.UndirectedGraphNode;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PermutationIITest {
    @Test
    public void test() {
        PermutationII.Solution solution = new PermutationII().new Solution();
        System.out.println(solution.minWindow("abdecbfacb", "abc"));

    }
}
