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
 * No011ContainerWithMostWater 单元测试
 */
@DisplayName("11. Container With Most Water")
class No011ContainerWithMostWaterTest {

    private No011ContainerWithMostWater solution;

    @BeforeEach
    void setUp() {
        solution = new No011ContainerWithMostWater();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: height array, expected max area
            Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
            Arguments.of(new int[]{1, 1}, 1),
            Arguments.of(new int[]{4, 3, 2, 1, 4}, 16),
            Arguments.of(new int[]{1, 2, 1}, 2)
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] height, int expected) {
        int result = solution.solutionEasy(height);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] height, int expected) {
        int result = solution.solutionOptimal(height);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试所有高度相同")
    void testAllSameHeight() {
        int[] height = {5, 5, 5, 5, 5};
        int expected = 20; // min(5,5) * 4 = 20

        assertEquals(expected, solution.solutionEasy(height));
        assertEquals(expected, solution.solutionOptimal(height));
    }

    @Test
    @DisplayName("测试递增高度")
    void testIncreasingHeight() {
        int[] height = {1, 2, 3, 4, 5};
        int expected = 6; // min(2,5) * 3 = 6 or min(1,4) * 3 = 3

        assertEquals(expected, solution.solutionEasy(height));
        assertEquals(expected, solution.solutionOptimal(height));
    }
}
