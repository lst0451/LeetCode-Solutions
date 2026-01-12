package com.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * No001TwoSum 单元测试
 */
@DisplayName("1. Two Sum")
class No001TwoSumTest {

    private No001TwoSum solution;

    @BeforeEach
    void setUp() {
        solution = new No001TwoSum();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: nums, target, expected
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
            Arguments.of(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4})
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] nums, int target, int[] expected) {
        int[] result = solution.solutionEasy(nums, target);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] nums, int target, int[] expected) {
        int[] result = solution.solutionOptimal(nums, target);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("测试边界情况 - 最小数组")
    void testMinimumArray() {
        int[] nums = {1, 2};
        int target = 3;
        int[] expected = {0, 1};

        assertArrayEquals(expected, solution.solutionEasy(nums, target));
        assertArrayEquals(expected, solution.solutionOptimal(nums, target));
    }

    @Test
    @DisplayName("测试负数和正数混合")
    void testMixedNumbers() {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] expected = {0, 2};

        assertArrayEquals(expected, solution.solutionEasy(nums, target));
        assertArrayEquals(expected, solution.solutionOptimal(nums, target));
    }
}
