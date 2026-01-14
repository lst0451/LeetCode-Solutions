package com.leetcode.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.leetcode.common.TreeNode;

/**
 * No094BinaryTreeInorderTraversal 单元测试
 */
@DisplayName("94. Binary Tree Inorder Traversal")
class No094BinaryTreeInorderTraversalTest {

    private No094BinaryTreeInorderTraversal solution;

    @BeforeEach
    void setUp() {
        solution = new No094BinaryTreeInorderTraversal();
    }

    @Test
    @DisplayName("测试示例1 - [1,null,2,3]")
    void testExample1() {
        // 构建树: 1 -> null, 2 -> 3, null
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(1, 3, 2);

        assertEquals(expected, solution.solutionEasy(root));

        // 重新构建树（因为遍历可能修改结构）
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertEquals(expected, solution.solutionOptimal(root));
    }

    @Test
    @DisplayName("测试空树")
    void testEmptyTree() {
        List<Integer> expected = Collections.emptyList();

        assertEquals(expected, solution.solutionEasy(null));
        assertEquals(expected, solution.solutionOptimal(null));
    }

    @Test
    @DisplayName("测试单节点树")
    void testSingleNode() {
        TreeNode root = new TreeNode(1);
        List<Integer> expected = Collections.singletonList(1);

        assertEquals(expected, solution.solutionEasy(root));
        assertEquals(expected, solution.solutionOptimal(new TreeNode(1)));
    }

    @Test
    @DisplayName("测试完全二叉树")
    void testCompleteBinaryTree() {
        // 构建完全二叉树:
        //       4
        //      / \
        //     2   6
        //    / \ / \
        //   1  3 5  7
        TreeNode root = TreeNode.fromArray(new Integer[]{4, 2, 6, 1, 3, 5, 7});
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertEquals(expected, solution.solutionEasy(root));
        assertEquals(expected, solution.solutionOptimal(TreeNode.fromArray(new Integer[]{4, 2, 6, 1, 3, 5, 7})));
    }

    @Test
    @DisplayName("测试左斜树")
    void testLeftSkewedTree() {
        // 构建左斜树: 3 -> 2 -> 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        List<Integer> expected = Arrays.asList(1, 2, 3);

        assertEquals(expected, solution.solutionEasy(root));

        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        assertEquals(expected, solution.solutionOptimal(root));
    }

    @Test
    @DisplayName("测试右斜树")
    void testRightSkewedTree() {
        // 构建右斜树: 1 -> 2 -> 3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        List<Integer> expected = Arrays.asList(1, 2, 3);

        assertEquals(expected, solution.solutionEasy(root));

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        assertEquals(expected, solution.solutionOptimal(root));
    }

    @Test
    @DisplayName("验证两种解法结果一致")
    void testBothSolutionsMatch() {
        TreeNode root = TreeNode.fromArray(new Integer[]{5, 3, 7, 2, 4, 6, 8, 1});

        List<Integer> easyResult = solution.solutionEasy(root);
        List<Integer> optimalResult = solution.solutionOptimal(TreeNode.fromArray(new Integer[]{5, 3, 7, 2, 4, 6, 8, 1}));

        assertEquals(easyResult, optimalResult);
    }
}
