package com.leetcode.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * No003LongestSubstring 单元测试
 */
@DisplayName("3. Longest Substring Without Repeating Characters")
class No003LongestSubstringTest {

    private No003LongestSubstring solution;

    @BeforeEach
    void setUp() {
        solution = new No003LongestSubstring();
    }

    /**
     * 提供测试用例数据
     */
    static Stream<Arguments> testCases() {
        return Stream.of(
            // 参数: input string, expected length
            Arguments.of("abcabcbb", 3),  // "abc"
            Arguments.of("bbbbb", 1),      // "b"
            Arguments.of("pwwkew", 3),     // "wke"
            Arguments.of("", 0),           // empty string
            Arguments.of(" ", 1),          // single space
            Arguments.of("au", 2),         // two different chars
            Arguments.of("dvdf", 3)        // "vdf"
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}: \"{0}\"")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(String input, int expected) {
        int result = solution.solutionEasy(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}: \"{0}\"")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(String input, int expected) {
        int result = solution.solutionOptimal(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("测试包含特殊字符的字符串")
    void testWithSpecialCharacters() {
        String input = "!@#$%^&*()";
        int expected = 10;

        assertEquals(expected, solution.solutionEasy(input));
        assertEquals(expected, solution.solutionOptimal(input));
    }

    @Test
    @DisplayName("测试全部唯一字符")
    void testAllUniqueCharacters() {
        String input = "abcdefghijk";
        int expected = 11;

        assertEquals(expected, solution.solutionEasy(input));
        assertEquals(expected, solution.solutionOptimal(input));
    }

    @Test
    @DisplayName("测试包含数字的字符串")
    void testWithDigits() {
        String input = "0123456789";
        int expected = 10;

        assertEquals(expected, solution.solutionEasy(input));
        assertEquals(expected, solution.solutionOptimal(input));
    }

    @Test
    @DisplayName("测试长字符串")
    void testLongString() {
        String input = "abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz";
        int expected = 26; // all lowercase letters

        assertEquals(expected, solution.solutionEasy(input));
        assertEquals(expected, solution.solutionOptimal(input));
    }
}
