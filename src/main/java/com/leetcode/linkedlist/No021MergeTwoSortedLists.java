package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * 21. Merge Two Sorted Lists (合并两个有序链表)
 *
 * 难度: Easy
 * 标签: Linked List, Recursion
 * 链接: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * 题目描述:
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * 示例:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * 约束条件:
 * - The number of nodes in both lists is in the range [0, 50].
 * - -100 <= Node.val <= 100
 * - Both list1 and list2 are sorted in non-decreasing order.
 */
public class No021MergeTwoSortedLists {

    /**
     * 解决方案1: 迭代法 (容易理解)
     *
     * 解题思路:
     * 使用虚拟头节点，比较两个链表的当前节点，将较小的节点连接到结果链表。
     * 重复此过程直到一个链表为空，然后将剩余链表直接连接。
     *
     * 时间复杂度: O(m + n) - m和n分别是两个链表的长度
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param list1 第一个有序链表
     * @param list2 第二个有序链表
     * @return 合并后的有序链表
     */
    public ListNode solutionEasy(ListNode list1, ListNode list2) {
        // 使用虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 比较并合并
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 连接剩余部分
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    /**
     * 解决方案2: 递归法 (最优性能)
     *
     * 解题思路:
     * 递归比较两个链表的头节点，较小的节点作为当前节点，
     * 其next指向剩余部分的合并结果。
     *
     * 时间复杂度: O(m + n) - m和n分别是两个链表的长度
     * 空间复杂度: O(m + n) - 递归调用栈的深度
     *
     * @param list1 第一个有序链表
     * @param list2 第二个有序链表
     * @return 合并后的有序链表
     */
    public ListNode solutionOptimal(ListNode list1, ListNode list2) {
        // 递归终止条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 比较并递归
        if (list1.val <= list2.val) {
            list1.next = solutionOptimal(list1.next, list2);
            return list1;
        } else {
            list2.next = solutionOptimal(list1, list2.next);
            return list2;
        }
    }
}
