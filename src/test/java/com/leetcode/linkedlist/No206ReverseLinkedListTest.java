package com.leetcode.linkedlist;

import com.leetcode.common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * No206ReverseLinkedList 单元测试
 */
@DisplayName("206. Reverse Linked List")
class No206ReverseLinkedListTest {

    private No206ReverseLinkedList solution;

    @BeforeEach
    void setUp() {
        solution = new No206ReverseLinkedList();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: input array, expected array
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
            Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1})
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] input, int[] expected) {
        ListNode head = ListNode.fromArray(input);
        ListNode result = solution.solutionEasy(head);
        int[] resultArray = ListNode.toArray(result);
        assertArrayEquals(expected, resultArray);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] input, int[] expected) {
        ListNode head = ListNode.fromArray(input);
        ListNode result = solution.solutionOptimal(head);
        int[] resultArray = ListNode.toArray(result);
        assertArrayEquals(expected, resultArray);
    }

    @Test
    @DisplayName("测试长链表")
    void testLongList() {
        int[] input = new int[100];
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            input[i] = i;
            expected[99 - i] = i;
        }

        ListNode head1 = ListNode.fromArray(input);
        int[] result1 = ListNode.toArray(solution.solutionEasy(head1));
        assertArrayEquals(expected, result1);

        ListNode head2 = ListNode.fromArray(input);
        int[] result2 = ListNode.toArray(solution.solutionOptimal(head2));
        assertArrayEquals(expected, result2);
    }
}
