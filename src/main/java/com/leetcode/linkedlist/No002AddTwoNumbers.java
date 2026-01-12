package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * 2. Add Two Numbers (两数相加)
 *
 * 难度: Medium
 * 标签: Linked List, Math, Recursion
 * 链接: https://leetcode.com/problems/add-two-numbers/
 *
 * 题目描述:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * 示例:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * 约束条件:
 * - The number of nodes in each linked list is in the range [1, 100].
 * - 0 <= Node.val <= 9
 * - It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class No002AddTwoNumbers {

    /**
     * 解决方案1: 迭代法 (容易理解)
     *
     * 解题思路:
     * 使用虚拟头节点简化链表操作，同时遍历两个链表，将对应位置的数字和进位相加，
     * 生成新的节点。处理进位，直到两个链表都遍历完且进位为0。
     *
     * 时间复杂度: O(max(m, n)) - m和n分别是两个链表的长度
     * 空间复杂度: O(max(m, n)) - 需要创建新的链表存储结果
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 相加后的链表
     */
    public ListNode solutionEasy(ListNode l1, ListNode l2) {
        // 使用虚拟头节点简化链表操作
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0; // 进位

        // 同时遍历两个链表
        while (l1 != null || l2 != null || carry != 0) {
            // 获取当前位的值
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // 计算当前位的和
            int sum = val1 + val2 + carry;
            carry = sum / 10; // 计算新的进位
            int digit = sum % 10; // 当前位的数字

            // 创建新节点
            current.next = new ListNode(digit);
            current = current.next;

            // 移动到下一位
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    /**
     * 解决方案2: 递归法 (最优性能)
     *
     * 解题思路:
     * 使用递归处理链表加法。每次递归处理当前位的加法和进位，
     * 递归终止条件是两个链表都为空且进位为0。
     *
     * 时间复杂度: O(max(m, n)) - m和n分别是两个链表的长度
     * 空间复杂度: O(max(m, n)) - 递归调用栈的深度
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 相加后的链表
     */
    public ListNode solutionOptimal(ListNode l1, ListNode l2) {
        return addTwoNumbersRecursive(l1, l2, 0);
    }

    /**
     * 递归辅助方法
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @param carry 进位
     * @return 相加后的链表节点
     */
    private ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2, int carry) {
        // 递归终止条件
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        // 获取当前位的值
        int val1 = (l1 != null) ? l1.val : 0;
        int val2 = (l2 != null) ? l2.val : 0;

        // 计算当前位的和
        int sum = val1 + val2 + carry;
        int newCarry = sum / 10;
        int digit = sum % 10;

        // 创建新节点
        ListNode newNode = new ListNode(digit);

        // 递归处理下一位
        ListNode next1 = (l1 != null) ? l1.next : null;
        ListNode next2 = (l2 != null) ? l2.next : null;
        newNode.next = addTwoNumbersRecursive(next1, next2, newCarry);

        return newNode;
    }
}
