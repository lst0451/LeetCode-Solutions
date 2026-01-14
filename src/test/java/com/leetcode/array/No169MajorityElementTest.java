package com.leetcode.array;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * No169MajorityElement 单元测试
 */
@DisplayName("169. Majority Element")
class No169MajorityElementTest {

    private No169MajorityElement solution;

    @BeforeEach
    void setUp() {
        solution = new No169MajorityElement();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
                // 参数: nums, expected
                Arguments.of(new int[]{3, 2, 3}, 3),
                Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 1, 1}, 1),
                Arguments.of(new int[]{3, 3, 4}, 3)
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] nums, int expected) {
        assertEquals(expected, solution.solutionEasy(nums.clone()));
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案 (Boyer-Moore)")
    void testSolutionOptimal(int[] nums, int expected) {
        assertEquals(expected, solution.solutionOptimal(nums.clone()));
    }

    @ParameterizedTest(name = "Sort Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试排序解决方案")
    void testSolutionSort(int[] nums, int expected) {
        assertEquals(expected, solution.solutionSort(nums.clone()));
    }

    @Test
    @DisplayName("测试大数组")
    void testLargeArray() {
        // 创建大数组：多数元素是5
        int[] nums = new int[10001];
        for (int i = 0; i < 5001; i++) {
            nums[i] = 5;
        }
        for (int i = 5001; i < 10001; i++) {
            nums[i] = i;
        }

        assertEquals(5, solution.solutionEasy(nums.clone()));
        assertEquals(5, solution.solutionOptimal(nums.clone()));
        assertEquals(5, solution.solutionSort(nums.clone()));
    }

    @Test
    @DisplayName("测试负数")
    void testNegativeNumbers() {
        int[] nums = {-1, -1, -1, 2, 2};
        assertEquals(-1, solution.solutionEasy(nums.clone()));
        assertEquals(-1, solution.solutionOptimal(nums.clone()));
        assertEquals(-1, solution.solutionSort(nums.clone()));
    }

    @Test
    @DisplayName("验证三种解法结果一致")
    void testAllSolutionsMatch() {
        int[][] testArrays = {
            {1, 1, 2},
            {5, 5, 5, 3, 3},
            {7, 7, 7, 7, 1, 2, 3},
            {100, 100, 100, 1, 2}
        };

        for (int[] nums : testArrays) {
            int easy = solution.solutionEasy(nums.clone());
            int optimal = solution.solutionOptimal(nums.clone());
            int sort = solution.solutionSort(nums.clone());

            assertEquals(easy, optimal);
            assertEquals(optimal, sort);
        }
    }
}
