package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.common.ListNode;

/**
 * 141. Linked List Cycle (环形链表)
 *
 * 难度: Easy 标签: Linked List, Hash Table, Two Pointers 链接:
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * 题目描述: Given head, the head of a linked list, determine if the linked list has
 * a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * 示例: Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a
 * cycle in the linked list, where the tail connects to the 1st node.
 *
 * 约束条件: - The number of the nodes in the list is in the range [0, 10^4]. -
 * -10^5 <= Node.val <= 10^5 - pos is -1 or a valid index in the linked-list.
 */
public class No141LinkedListCycle {

    /**
     * 解决方案1: 哈希表法 (容易理解)
     *
     * 解题思路: 使用HashSet存储已经访问过的节点。遍历链表时，如果当前节点
     * 已经在HashSet中出现过，说明存在环；如果遍历到null，说明无环。
     *
     * 时间复杂度: O(n) - 遍历链表一次 空间复杂度: O(n) - HashSet存储最多n个节点
     *
     * @param head 链表头节点
     * @return 是否存在环
     */
    public boolean solutionEasy(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            // 如果当前节点已经访问过，说明有环
            if (visited.contains(current)) {
                return true;
            }
            // 记录当前节点
            visited.add(current);
            current = current.next;
        }

        // 遍历到null，说明没有环
        return false;
    }

    /**
     * 解决方案2: 快慢指针法 - Floyd判圈算法 (最优性能)
     *
     * 解题思路: 使用快慢两个指针，慢指针每次走1步，快指针每次走2步。 如果存在环，快指针最终会追上慢指针（在环内相遇）。
     * 如果不存在环，快指针会先到达链表末尾。
     *
     * 原理：如果有环，快慢指针都会进入环中。在环中，快指针每次 比慢指针多走1步，所以最终一定会追上慢指针。
     *
     * 时间复杂度: O(n) - 最多遍历2n次 空间复杂度: O(1) - 只使用两个指针
     *
     * @param head 链表头节点
     * @return 是否存在环
     */
    public boolean solutionOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 慢指针走1步
            fast = fast.next.next;   // 快指针走2步

            // 如果快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }

        // 快指针到达末尾，说明没有环
        return false;
    }
}
