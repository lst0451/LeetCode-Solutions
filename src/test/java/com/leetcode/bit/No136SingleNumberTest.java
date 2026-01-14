package com.leetcode.bit;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * No136SingleNumber 单元测试
 */
@DisplayName("136. Single Number")
class No136SingleNumberTest {

    private No136SingleNumber solution;

    @BeforeEach
    void setUp() {
        solution = new No136SingleNumber();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
                // 参数: nums, expected
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2, 1}, 2),
                Arguments.of(new int[]{-1, -1, 2}, 2),
                Arguments.of(new int[]{0, 1, 0}, 1)
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] nums, int expected) {
        assertEquals(expected, solution.solutionEasy(nums));
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] nums, int expected) {
        assertEquals(expected, solution.solutionOptimal(nums));
    }

    @Test
    @DisplayName("测试大数组")
    void testLargeArray() {
        // 创建一个大数组，每个数出现两次，只有7出现一次
        int[] nums = new int[1001];
        for (int i = 0; i < 500; i++) {
            nums[i * 2] = i;
            nums[i * 2 + 1] = i;
        }
        nums[1000] = 7;

        assertEquals(7, solution.solutionEasy(nums.clone()));
        assertEquals(7, solution.solutionOptimal(nums.clone()));
    }

    @Test
    @DisplayName("测试负数和正数混合")
    void testMixedNumbers() {
        int[] nums = {-3, 5, -3, 5, 100};
        assertEquals(100, solution.solutionEasy(nums.clone()));
        assertEquals(100, solution.solutionOptimal(nums.clone()));
    }

    @Test
    @DisplayName("验证两种解法结果一致")
    void testBothSolutionsMatch() {
        int[][] testArrays = {
            {1, 1, 2, 2, 3},
            {5, 3, 5, 3, 7, 9, 7},
            {-5, 10, -5, 10, 0}
        };

        for (int[] nums : testArrays) {
            assertEquals(
                    solution.solutionEasy(nums.clone()),
                    solution.solutionOptimal(nums.clone())
            );
        }
    }
}
