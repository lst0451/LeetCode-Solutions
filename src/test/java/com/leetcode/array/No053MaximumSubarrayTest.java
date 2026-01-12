package com.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * No053MaximumSubarray 单元测试
 */
@DisplayName("53. Maximum Subarray")
class No053MaximumSubarrayTest {

    private No053MaximumSubarray solution;

    @BeforeEach
    void setUp() {
        solution = new No053MaximumSubarray();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: nums array, expected max sum
            Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
            Arguments.of(new int[]{-1}, -1),
            Arguments.of(new int[]{-2, -1}, -1),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 15),
            Arguments.of(new int[]{-1, -2, -3, -4}, -1)
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] nums, int expected) {
        int result = solution.solutionEasy(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] nums, int expected) {
        int result = solution.solutionOptimal(nums);
        assertEquals(expected, result);
    }
}
