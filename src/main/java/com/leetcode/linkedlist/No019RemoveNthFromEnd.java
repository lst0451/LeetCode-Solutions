package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;

/**
 * 19. Remove Nth Node From End of List (删除链表的倒数第N个结点)
 *
 * 难度: Medium 标签: Linked List, Two Pointers 链接:
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * 题目描述: Given the head of a linked list, remove the nth node from the end of
 * the list and return its head.
 *
 * 示例: Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5] Explanation: Remove
 * the second node from the end, the node with value 4.
 *
 * 约束条件: - The number of nodes in the list is sz. - 1 <= sz <= 30 - 0 <=
 * Node.val <= 100 - 1 <= n <= sz
 */
public class No019RemoveNthFromEnd {

    /**
     * 解决方案1: 两次遍历法 (容易理解)
     *
     * 解题思路: 第一次遍历计算链表长度，第二次遍历找到倒数第n个节点的前一个节点， 然后删除目标节点。使用dummy节点简化边界条件处理。
     *
     * 时间复杂度: O(n) - 遍历链表两次 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param head 链表头节点
     * @param n 要删除的倒数第n个节点
     * @return 删除后的链表头节点
     */
    public ListNode solutionEasy(ListNode head, int n) {
        // 使用dummy节点简化头节点的删除操作
        ListNode dummy = new ListNode(0, head);

        // 第一次遍历：计算链表长度
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // 第二次遍历：找到要删除节点的前一个节点
        // 要删除的是第 (length - n + 1) 个节点，所以我们要找到第 (length - n) 个节点
        current = dummy;
        for (int i = 0; i < length - n; i++) {
            current = current.next;
        }

        // 删除目标节点
        current.next = current.next.next;

        return dummy.next;
    }

    /**
     * 解决方案2: 快慢指针法 (最优性能)
     *
     * 解题思路: 使用两个指针，让快指针先走n步，然后快慢指针一起走， 当快指针到达末尾时，慢指针刚好在要删除节点的前一个位置。
     * 这样只需一次遍历即可完成。
     *
     * 时间复杂度: O(n) - 只需遍历链表一次 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param head 链表头节点
     * @param n 要删除的倒数第n个节点
     * @return 删除后的链表头节点
     */
    public ListNode solutionOptimal(ListNode head, int n) {
        // 使用dummy节点简化头节点的删除操作
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针先走n+1步（这样当fast到达末尾时，slow在目标节点的前一个位置）
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时移动，直到快指针到达末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除目标节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
