package com.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * No121BestTimeToBuyAndSellStock 单元测试
 */
@DisplayName("121. Best Time to Buy and Sell Stock")
class No121BestTimeToBuyAndSellStockTest {

    private No121BestTimeToBuyAndSellStock solution;

    @BeforeEach
    void setUp() {
        solution = new No121BestTimeToBuyAndSellStock();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: prices array, expected max profit
            Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
            Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
            Arguments.of(new int[]{2, 4, 1}, 2),
            Arguments.of(new int[]{3, 3, 3, 3}, 0),
            Arguments.of(new int[]{1}, 0),
            Arguments.of(new int[]{2, 1, 2, 1, 0, 1, 2}, 2)
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(int[] prices, int expected) {
        int result = solution.solutionEasy(prices);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(int[] prices, int expected) {
        int result = solution.solutionOptimal(prices);
        assertEquals(expected, result);
    }
}
