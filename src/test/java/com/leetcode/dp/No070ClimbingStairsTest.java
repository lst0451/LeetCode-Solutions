package com.leetcode.dp;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * No070ClimbingStairs 单元测试
 */
@DisplayName("70. Climbing Stairs")
class No070ClimbingStairsTest {

    private No070ClimbingStairs solution;

    @BeforeEach
    void setUp() {
        solution = new No070ClimbingStairs();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
                // 参数: n, expected
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8),
                Arguments.of(10, 89),
                Arguments.of(20, 10946)
        );
    }

    @ParameterizedTest(name = "Easy Solution - n={0}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int n, int expected) {
        assertEquals(expected, solution.solutionEasy(n));
    }

    @ParameterizedTest(name = "Optimal Solution - n={0}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int n, int expected) {
        assertEquals(expected, solution.solutionOptimal(n));
    }

    @Test
    @DisplayName("测试边界情况 - 最大值")
    void testMaxValue() {
        // n = 45 时的结果
        int expected = 1836311903;
        assertEquals(expected, solution.solutionEasy(45));
        assertEquals(expected, solution.solutionOptimal(45));
    }

    @Test
    @DisplayName("验证两种解法结果一致")
    void testBothSolutionsMatch() {
        for (int n = 1; n <= 30; n++) {
            assertEquals(
                    solution.solutionEasy(n),
                    solution.solutionOptimal(n),
                    "Results should match for n=" + n
            );
        }
    }
}
