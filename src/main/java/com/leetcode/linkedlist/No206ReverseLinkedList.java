package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * 206. Reverse Linked List (反转链表)
 *
 * 难度: Easy
 * 标签: Linked List, Recursion
 * 链接: https://leetcode.com/problems/reverse-linked-list/
 *
 * 题目描述:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * 示例:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * 约束条件:
 * - The number of nodes in the list is the range [0, 5000].
 * - -5000 <= Node.val <= 5000
 */
public class No206ReverseLinkedList {

    /**
     * 解决方案1: 迭代法 (容易理解)
     *
     * 解题思路:
     * 使用三个指针：prev(前一个节点)、current(当前节点)、next(下一个节点)。
     * 遍历链表，每次将当前节点的next指向前一个节点，然后三个指针都向前移动。
     *
     * 时间复杂度: O(n) - 遍历链表一次
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    public ListNode solutionEasy(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            // 保存下一个节点
            ListNode next = current.next;

            // 反转当前节点的指针
            current.next = prev;

            // 移动指针
            prev = current;
            current = next;
        }

        // prev现在指向新的头节点
        return prev;
    }

    /**
     * 解决方案2: 递归法 (最优性能)
     *
     * 解题思路:
     * 递归到链表末尾，然后在回溯过程中反转指针。
     * 对于每个节点，让其下一个节点指向自己，然后断开自己指向下一个节点的指针。
     *
     * 时间复杂度: O(n) - 遍历链表一次
     * 空间复杂度: O(n) - 递归调用栈的深度
     *
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    public ListNode solutionOptimal(ListNode head) {
        // 递归终止条件：空链表或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转后续链表
        ListNode newHead = solutionOptimal(head.next);

        // 反转当前节点
        // head.next 当前指向下一个节点
        // 让下一个节点的next指向当前节点
        head.next.next = head;

        // 断开当前节点指向下一个节点的指针
        head.next = null;

        return newHead;
    }
}
