package com.leetcode.array;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * No217ContainsDuplicate 单元测试
 */
@DisplayName("217. Contains Duplicate")
class No217ContainsDuplicateTest {

    private No217ContainsDuplicate solution;

    @BeforeEach
    void setUp() {
        solution = new No217ContainsDuplicate();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
                // 参数: nums, expected
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true),
                Arguments.of(new int[]{1}, false),
                Arguments.of(new int[]{1, 2}, false),
                Arguments.of(new int[]{1, 1}, true)
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案 (排序法)")
    void testSolutionEasy(int[] nums, boolean expected) {
        assertEquals(expected, solution.solutionEasy(nums.clone()));
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案 (哈希表法)")
    void testSolutionOptimal(int[] nums, boolean expected) {
        assertEquals(expected, solution.solutionOptimal(nums.clone()));
    }

    @ParameterizedTest(name = "Concise Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试简洁解决方案")
    void testSolutionConcise(int[] nums, boolean expected) {
        assertEquals(expected, solution.solutionConcise(nums.clone()));
    }

    @Test
    @DisplayName("测试大数组 - 无重复")
    void testLargeArrayNoDuplicate() {
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i;
        }

        assertFalse(solution.solutionEasy(nums.clone()));
        assertFalse(solution.solutionOptimal(nums.clone()));
        assertFalse(solution.solutionConcise(nums.clone()));
    }

    @Test
    @DisplayName("测试大数组 - 有重复")
    void testLargeArrayWithDuplicate() {
        int[] nums = new int[10001];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i;
        }
        nums[10000] = 5000; // 添加重复元素

        assertTrue(solution.solutionEasy(nums.clone()));
        assertTrue(solution.solutionOptimal(nums.clone()));
        assertTrue(solution.solutionConcise(nums.clone()));
    }

    @Test
    @DisplayName("测试负数")
    void testNegativeNumbers() {
        int[] nums = {-1, -2, -3, -1};
        assertTrue(solution.solutionEasy(nums.clone()));
        assertTrue(solution.solutionOptimal(nums.clone()));
        assertTrue(solution.solutionConcise(nums.clone()));
    }

    @Test
    @DisplayName("测试混合正负数")
    void testMixedNumbers() {
        int[] nums = {-1, 1, -2, 2, 0};
        assertFalse(solution.solutionEasy(nums.clone()));
        assertFalse(solution.solutionOptimal(nums.clone()));
        assertFalse(solution.solutionConcise(nums.clone()));
    }

    @Test
    @DisplayName("验证三种解法结果一致")
    void testAllSolutionsMatch() {
        int[][] testArrays = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 5},
            {-100, 0, 100},
            {0, 0}
        };

        for (int[] nums : testArrays) {
            boolean easy = solution.solutionEasy(nums.clone());
            boolean optimal = solution.solutionOptimal(nums.clone());
            boolean concise = solution.solutionConcise(nums.clone());

            assertEquals(easy, optimal);
            assertEquals(optimal, concise);
        }
    }
}
