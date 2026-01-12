package com.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表节点定义
 * 用于链表相关的LeetCode题目
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 从数组创建链表 (测试辅助方法)
     *
     * @param values 整数数组
     * @return 链表头节点
     */
    public static ListNode fromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * 将链表转换为数组 (测试辅助方法)
     *
     * @param head 链表头节点
     * @return 整数数组
     */
    public static int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
