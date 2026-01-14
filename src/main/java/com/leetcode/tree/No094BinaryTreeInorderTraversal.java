package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.common.TreeNode;

/**
 * 94. Binary Tree Inorder Traversal (二叉树的中序遍历)
 *
 * 难度: Easy 标签: Tree, Stack, Depth-First Search, Binary Tree 链接:
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * 题目描述: Given the root of a binary tree, return the inorder traversal of its
 * nodes' values.
 *
 * 中序遍历顺序: 左子树 -> 根节点 -> 右子树
 *
 * 示例: Input: root = [1,null,2,3] Output: [1,3,2]
 *
 * 约束条件: - The number of nodes in the tree is in the range [0, 100]. - -100 <=
 * Node.val <= 100
 */
public class No094BinaryTreeInorderTraversal {

    /**
     * 解决方案1: 递归法 (容易理解)
     *
     * 解题思路: 中序遍历的顺序是：左子树 -> 根节点 -> 右子树。 递归实现非常直观：先递归遍历左子树，然后访问当前节点， 最后递归遍历右子树。
     *
     * 时间复杂度: O(n) - 访问每个节点一次 空间复杂度: O(n) - 递归调用栈的深度，最坏情况下（斜树）为n
     *
     * @param root 二叉树根节点
     * @return 中序遍历结果列表
     */
    public List<Integer> solutionEasy(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // 先遍历左子树
        inorderHelper(node.left, result);
        // 访问当前节点
        result.add(node.val);
        // 再遍历右子树
        inorderHelper(node.right, result);
    }

    /**
     * 解决方案2: 迭代法（使用栈）(最优性能)
     *
     * 解题思路: 使用栈来模拟递归过程。首先沿着左子树一直走到底， 将所有经过的节点压入栈中。然后弹出栈顶节点访问， 再转向它的右子树，重复这个过程。
     *
     * 时间复杂度: O(n) - 访问每个节点一次 空间复杂度: O(n) - 栈的大小，最坏情况下为n
     *
     * @param root 二叉树根节点
     * @return 中序遍历结果列表
     */
    public List<Integer> solutionOptimal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 一直向左走，将所有左节点压入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 弹出栈顶节点（当前最左的未访问节点）
            current = stack.pop();
            // 访问这个节点
            result.add(current.val);
            // 转向右子树
            current = current.right;
        }

        return result;
    }
}
