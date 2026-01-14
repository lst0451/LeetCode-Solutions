package com.leetcode.array;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * No066PlusOne 单元测试
 */
@DisplayName("66. Plus One")
class No066PlusOneTest {

    private No066PlusOne solution;

    @BeforeEach
    void setUp() {
        solution = new No066PlusOne();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
                // 参数: inputArray, expectedArray
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                Arguments.of(new int[]{9}, new int[]{1, 0}),
                Arguments.of(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0}),
                Arguments.of(new int[]{1, 9, 9}, new int[]{2, 0, 0}),
                Arguments.of(new int[]{0}, new int[]{1})
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] digits, int[] expected) {
        assertArrayEquals(expected, solution.solutionEasy(digits.clone()));
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] digits, int[] expected) {
        assertArrayEquals(expected, solution.solutionOptimal(digits.clone()));
    }

    @Test
    @DisplayName("测试大数组")
    void testLargeArray() {
        int[] digits = new int[100];
        digits[0] = 1;
        int[] expected = new int[100];
        expected[0] = 1;
        expected[99] = 1;

        assertArrayEquals(expected, solution.solutionEasy(digits.clone()));
        assertArrayEquals(expected, solution.solutionOptimal(digits.clone()));
    }

    @Test
    @DisplayName("测试混合进位")
    void testMixedCarry() {
        int[] digits = {2, 9, 9};
        int[] expected = {3, 0, 0};

        assertArrayEquals(expected, solution.solutionEasy(digits.clone()));
        assertArrayEquals(expected, solution.solutionOptimal(digits.clone()));
    }
}
