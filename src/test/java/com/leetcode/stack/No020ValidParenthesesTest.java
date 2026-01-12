package com.leetcode.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * No020ValidParentheses 单元测试
 */
@DisplayName("20. Valid Parentheses")
class No020ValidParenthesesTest {

    private No020ValidParentheses solution;

    @BeforeEach
    void setUp() {
        solution = new No020ValidParentheses();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: input string, expected result
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("([)]", false),
            Arguments.of("{[]}", true),
            Arguments.of("", true),
            Arguments.of("(", false),
            Arguments.of(")", false),
            Arguments.of("((", false),
            Arguments.of("))", false),
            Arguments.of("(())", true),
            Arguments.of("((()))", true)
        );
    }

    @ParameterizedTest(name = "Easy Solution - \"{0}\" = {1}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(String s, boolean expected) {
        boolean result = solution.solutionEasy(s);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Optimal Solution - \"{0}\" = {1}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(String s, boolean expected) {
        boolean result = solution.solutionOptimal(s);
        assertEquals(expected, result);
    }
}
