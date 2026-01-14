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
 * No026RemoveDuplicates 单元测试
 */
@DisplayName("26. Remove Duplicates from Sorted Array")
class No026RemoveDuplicatesTest {

    private No026RemoveDuplicates solution;

    @BeforeEach
    void setUp() {
        solution = new No026RemoveDuplicates();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
                // 参数: inputArray, expectedLength, expectedElements
                Arguments.of(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, new int[]{0, 1, 2, 3, 4}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3}, 3, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, new int[]{1})
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] nums, int expectedLength, int[] expectedElements) {
        int[] numsCopy = nums.clone();
        int result = solution.solutionEasy(numsCopy);

        assertEquals(expectedLength, result);
        for (int i = 0; i < expectedLength; i++) {
            assertEquals(expectedElements[i], numsCopy[i]);
        }
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] nums, int expectedLength, int[] expectedElements) {
        int[] numsCopy = nums.clone();
        int result = solution.solutionOptimal(numsCopy);

        assertEquals(expectedLength, result);
        for (int i = 0; i < expectedLength; i++) {
            assertEquals(expectedElements[i], numsCopy[i]);
        }
    }

    @Test
    @DisplayName("测试空数组")
    void testEmptyArray() {
        assertEquals(0, solution.solutionEasy(new int[]{}));
        assertEquals(0, solution.solutionOptimal(new int[]{}));
    }

    @Test
    @DisplayName("测试负数数组")
    void testNegativeNumbers() {
        int[] nums = {-5, -5, -3, -1, -1, 0, 0, 1};
        int[] expected = {-5, -3, -1, 0, 1};

        int[] numsCopy1 = nums.clone();
        int result1 = solution.solutionEasy(numsCopy1);
        assertEquals(5, result1);

        int[] numsCopy2 = nums.clone();
        int result2 = solution.solutionOptimal(numsCopy2);
        assertEquals(5, result2);
    }
}
