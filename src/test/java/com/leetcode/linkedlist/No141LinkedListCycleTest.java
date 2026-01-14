package com.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.leetcode.common.ListNode;

/**
 * No141LinkedListCycle 单元测试
 */
@DisplayName("141. Linked List Cycle")
class No141LinkedListCycleTest {

    private No141LinkedListCycle solution;

    @BeforeEach
    void setUp() {
        solution = new No141LinkedListCycle();
    }

    /**
     * 创建有环链表的辅助方法
     *
     * @param values 节点值数组
     * @param pos 环的起始位置（-1表示无环）
     * @return 链表头节点
     */
    private ListNode createCyclicList(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleTarget = (pos == 0) ? head : null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleTarget = current;
            }
        }

        // 创建环
        if (pos >= 0 && cycleTarget != null) {
            current.next = cycleTarget;
        }

        return head;
    }

    @Test
    @DisplayName("测试示例1 - 有环链表 [3,2,0,-4], pos=1")
    void testExample1() {
        ListNode head = createCyclicList(new int[]{3, 2, 0, -4}, 1);

        assertTrue(solution.solutionEasy(createCyclicList(new int[]{3, 2, 0, -4}, 1)));
        assertTrue(solution.solutionOptimal(head));
    }

    @Test
    @DisplayName("测试示例2 - 有环链表 [1,2], pos=0")
    void testExample2() {
        assertTrue(solution.solutionEasy(createCyclicList(new int[]{1, 2}, 0)));
        assertTrue(solution.solutionOptimal(createCyclicList(new int[]{1, 2}, 0)));
    }

    @Test
    @DisplayName("测试无环链表 [1], pos=-1")
    void testNoCycle() {
        ListNode head = ListNode.fromArray(new int[]{1});

        assertFalse(solution.solutionEasy(head));
        assertFalse(solution.solutionOptimal(ListNode.fromArray(new int[]{1})));
    }

    @Test
    @DisplayName("测试空链表")
    void testEmptyList() {
        assertFalse(solution.solutionEasy(null));
        assertFalse(solution.solutionOptimal(null));
    }

    @Test
    @DisplayName("测试无环长链表")
    void testLongListNoCycle() {
        int[] values = new int[100];
        for (int i = 0; i < 100; i++) {
            values[i] = i;
        }
        ListNode head = ListNode.fromArray(values);

        assertFalse(solution.solutionEasy(head));
        assertFalse(solution.solutionOptimal(ListNode.fromArray(values)));
    }

    @Test
    @DisplayName("测试有环长链表")
    void testLongListWithCycle() {
        int[] values = new int[100];
        for (int i = 0; i < 100; i++) {
            values[i] = i;
        }

        assertTrue(solution.solutionEasy(createCyclicList(values, 50)));
        assertTrue(solution.solutionOptimal(createCyclicList(values, 50)));
    }

    @Test
    @DisplayName("测试环在末尾回到开头")
    void testCycleAtEnd() {
        ListNode head = createCyclicList(new int[]{1, 2, 3, 4, 5}, 0);

        assertTrue(solution.solutionEasy(createCyclicList(new int[]{1, 2, 3, 4, 5}, 0)));
        assertTrue(solution.solutionOptimal(head));
    }

    @Test
    @DisplayName("测试自循环节点")
    void testSelfLoop() {
        ListNode head = new ListNode(1);
        head.next = head;

        ListNode head2 = new ListNode(1);
        head2.next = head2;

        assertTrue(solution.solutionEasy(head));
        assertTrue(solution.solutionOptimal(head2));
    }
}
