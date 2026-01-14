package com.leetcode.linkedlist;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.leetcode.common.ListNode;

/**
 * No019RemoveNthFromEnd 单元测试
 */
@DisplayName("19. Remove Nth Node From End of List")
class No019RemoveNthFromEndTest {

    private No019RemoveNthFromEnd solution;

    @BeforeEach
    void setUp() {
        solution = new No019RemoveNthFromEnd();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
                // 参数: inputArray, n, expectedArray
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}),
                Arguments.of(new int[]{1}, 1, new int[]{}),
                Arguments.of(new int[]{1, 2}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2}, 2, new int[]{2}),
                Arguments.of(new int[]{1, 2, 3}, 3, new int[]{2, 3})
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] inputArray, int n, int[] expectedArray) {
        ListNode head = ListNode.fromArray(inputArray);
        ListNode result = solution.solutionEasy(head, n);
        assertArrayEquals(expectedArray, ListNode.toArray(result));
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] inputArray, int n, int[] expectedArray) {
        ListNode head = ListNode.fromArray(inputArray);
        ListNode result = solution.solutionOptimal(head, n);
        assertArrayEquals(expectedArray, ListNode.toArray(result));
    }

    @Test
    @DisplayName("测试删除中间节点")
    void testRemoveMiddleNode() {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        int[] expected = {1, 2, 3, 5, 6, 7};

        assertArrayEquals(expected, ListNode.toArray(solution.solutionEasy(ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7}), 4)));
        assertArrayEquals(expected, ListNode.toArray(solution.solutionOptimal(ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7}), 4)));
    }
}
