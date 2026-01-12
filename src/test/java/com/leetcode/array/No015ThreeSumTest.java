package com.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * No015ThreeSum 单元测试
 */
@DisplayName("15. 3Sum")
class No015ThreeSumTest {

    private No015ThreeSum solution;

    @BeforeEach
    void setUp() {
        solution = new No015ThreeSum();
    }

    @Test
    @DisplayName("测试示例1")
    void testExample1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-1, -1, 2),
            Arrays.asList(-1, 0, 1)
        );

        List<List<Integer>> resultEasy = solution.solutionEasy(nums);
        List<List<Integer>> resultOptimal = solution.solutionOptimal(nums);

        assertEquals(2, resultEasy.size());
        assertEquals(2, resultOptimal.size());
        assertTrue(containsAll(resultEasy, expected));
        assertTrue(containsAll(resultOptimal, expected));
    }

    @Test
    @DisplayName("测试空结果")
    void testNoSolution() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> resultEasy = solution.solutionEasy(nums);
        List<List<Integer>> resultOptimal = solution.solutionOptimal(nums);

        assertTrue(resultEasy.isEmpty());
        assertTrue(resultOptimal.isEmpty());
    }

    @Test
    @DisplayName("测试全0")
    void testAllZeros() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0, 0, 0)
        );

        List<List<Integer>> resultEasy = solution.solutionEasy(nums);
        List<List<Integer>> resultOptimal = solution.solutionOptimal(nums);

        assertEquals(1, resultEasy.size());
        assertEquals(1, resultOptimal.size());
        assertTrue(containsAll(resultEasy, expected));
        assertTrue(containsAll(resultOptimal, expected));
    }

    @Test
    @DisplayName("测试多个重复元素")
    void testDuplicates() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> resultEasy = solution.solutionEasy(nums);
        List<List<Integer>> resultOptimal = solution.solutionOptimal(nums);

        assertEquals(1, resultEasy.size());
        assertEquals(1, resultOptimal.size());
        assertTrue(resultEasy.get(0).containsAll(Arrays.asList(-2, 0, 2)));
        assertTrue(resultOptimal.get(0).containsAll(Arrays.asList(-2, 0, 2)));
    }

    @Test
    @DisplayName("测试大数组")
    void testLargeArray() {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> resultEasy = solution.solutionEasy(nums);
        List<List<Integer>> resultOptimal = solution.solutionOptimal(nums);

        assertEquals(resultEasy.size(), resultOptimal.size());
        assertTrue(resultEasy.size() > 0);
    }

    /**
     * 辅助方法：检查两个结果列表是否包含相同的三元组
     */
    private boolean containsAll(List<List<Integer>> result, List<List<Integer>> expected) {
        if (result.size() != expected.size()) {
            return false;
        }

        for (List<Integer> triplet : expected) {
            boolean found = false;
            for (List<Integer> resultTriplet : result) {
                if (triplet.size() == resultTriplet.size() &&
                    triplet.containsAll(resultTriplet)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
