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
 * No002AddTwoNumbers 单元测试
 */
@DisplayName("2. Add Two Numbers")
class No002AddTwoNumbersTest {

    private No002AddTwoNumbers solution;

    @BeforeEach
    void setUp() {
        solution = new No002AddTwoNumbers();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: l1_array, l2_array, expected_array
            // 342 + 465 = 807
            Arguments.of(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}),
            // 0 + 0 = 0
            Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}),
            // 9999999 + 9999 = 10009998
            Arguments.of(
                new int[]{9, 9, 9, 9, 9, 9, 9},
                new int[]{9, 9, 9, 9},
                new int[]{8, 9, 9, 9, 0, 0, 0, 1}
            )
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] l1Array, int[] l2Array, int[] expectedArray) {
        ListNode l1 = ListNode.fromArray(l1Array);
        ListNode l2 = ListNode.fromArray(l2Array);
        ListNode result = solution.solutionEasy(l1, l2);
        int[] resultArray = ListNode.toArray(result);
        assertArrayEquals(expectedArray, resultArray);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] l1Array, int[] l2Array, int[] expectedArray) {
        ListNode l1 = ListNode.fromArray(l1Array);
        ListNode l2 = ListNode.fromArray(l2Array);
        ListNode result = solution.solutionOptimal(l1, l2);
        int[] resultArray = ListNode.toArray(result);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    @DisplayName("测试不同长度的链表")
    void testDifferentLengthLists() {
        // 99 + 1 = 100
        ListNode l1 = ListNode.fromArray(new int[]{9, 9});
        ListNode l2 = ListNode.fromArray(new int[]{1});
        int[] expected = {0, 0, 1};

        int[] resultEasy = ListNode.toArray(solution.solutionEasy(l1, l2));
        assertArrayEquals(expected, resultEasy);

        l1 = ListNode.fromArray(new int[]{9, 9});
        l2 = ListNode.fromArray(new int[]{1});
        int[] resultOptimal = ListNode.toArray(solution.solutionOptimal(l1, l2));
        assertArrayEquals(expected, resultOptimal);
    }

    @Test
    @DisplayName("测试单节点链表")
    void testSingleNodeLists() {
        // 5 + 5 = 10
        ListNode l1 = ListNode.fromArray(new int[]{5});
        ListNode l2 = ListNode.fromArray(new int[]{5});
        int[] expected = {0, 1};

        int[] resultEasy = ListNode.toArray(solution.solutionEasy(l1, l2));
        assertArrayEquals(expected, resultEasy);

        l1 = ListNode.fromArray(new int[]{5});
        l2 = ListNode.fromArray(new int[]{5});
        int[] resultOptimal = ListNode.toArray(solution.solutionOptimal(l1, l2));
        assertArrayEquals(expected, resultOptimal);
    }
}
