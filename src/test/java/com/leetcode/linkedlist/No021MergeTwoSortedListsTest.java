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
 * No021MergeTwoSortedLists 单元测试
 */
@DisplayName("21. Merge Two Sorted Lists")
class No021MergeTwoSortedListsTest {

    private No021MergeTwoSortedLists solution;

    @BeforeEach
    void setUp() {
        solution = new No021MergeTwoSortedLists();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: list1_array, list2_array, expected_array
            Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
            Arguments.of(new int[]{}, new int[]{}, new int[]{}),
            Arguments.of(new int[]{}, new int[]{0}, new int[]{0}),
            Arguments.of(new int[]{1}, new int[]{2}, new int[]{1, 2}),
            Arguments.of(new int[]{2}, new int[]{1}, new int[]{1, 2})
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] list1Array, int[] list2Array, int[] expectedArray) {
        ListNode list1 = ListNode.fromArray(list1Array);
        ListNode list2 = ListNode.fromArray(list2Array);
        ListNode result = solution.solutionEasy(list1, list2);
        int[] resultArray = ListNode.toArray(result);
        assertArrayEquals(expectedArray, resultArray);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] list1Array, int[] list2Array, int[] expectedArray) {
        ListNode list1 = ListNode.fromArray(list1Array);
        ListNode list2 = ListNode.fromArray(list2Array);
        ListNode result = solution.solutionOptimal(list1, list2);
        int[] resultArray = ListNode.toArray(result);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    @DisplayName("测试负数")
    void testNegativeNumbers() {
        ListNode list1 = ListNode.fromArray(new int[]{-10, -5, 0});
        ListNode list2 = ListNode.fromArray(new int[]{-8, -3, 1});
        int[] expected = {-10, -8, -5, -3, 0, 1};

        int[] resultEasy = ListNode.toArray(solution.solutionEasy(list1, list2));
        assertArrayEquals(expected, resultEasy);

        list1 = ListNode.fromArray(new int[]{-10, -5, 0});
        list2 = ListNode.fromArray(new int[]{-8, -3, 1});
        int[] resultOptimal = ListNode.toArray(solution.solutionOptimal(list1, list2));
        assertArrayEquals(expected, resultOptimal);
    }
}
