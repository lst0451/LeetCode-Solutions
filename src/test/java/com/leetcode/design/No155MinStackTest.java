package com.leetcode.design;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * No155MinStack 单元测试
 */
@DisplayName("155. Min Stack")
class No155MinStackTest {

    @Nested
    @DisplayName("测试容易理解的解决方案 (MinStackEasy)")
    class MinStackEasyTest {

        @Test
        @DisplayName("测试示例操作序列")
        void testExample() {
            No155MinStack.MinStackEasy minStack = new No155MinStack.MinStackEasy();

            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);

            assertEquals(-3, minStack.getMin()); // return -3

            minStack.pop();
            assertEquals(0, minStack.top());     // return 0
            assertEquals(-2, minStack.getMin()); // return -2
        }

        @Test
        @DisplayName("测试单元素")
        void testSingleElement() {
            No155MinStack.MinStackEasy minStack = new No155MinStack.MinStackEasy();

            minStack.push(5);
            assertEquals(5, minStack.top());
            assertEquals(5, minStack.getMin());

            minStack.pop();
            minStack.push(-1);
            assertEquals(-1, minStack.top());
            assertEquals(-1, minStack.getMin());
        }

        @Test
        @DisplayName("测试递增序列")
        void testIncreasingSequence() {
            No155MinStack.MinStackEasy minStack = new No155MinStack.MinStackEasy();

            minStack.push(1);
            minStack.push(2);
            minStack.push(3);

            assertEquals(1, minStack.getMin());
            assertEquals(3, minStack.top());
        }

        @Test
        @DisplayName("测试递减序列")
        void testDecreasingSequence() {
            No155MinStack.MinStackEasy minStack = new No155MinStack.MinStackEasy();

            minStack.push(3);
            assertEquals(3, minStack.getMin());

            minStack.push(2);
            assertEquals(2, minStack.getMin());

            minStack.push(1);
            assertEquals(1, minStack.getMin());

            minStack.pop();
            assertEquals(2, minStack.getMin());
        }

        @Test
        @DisplayName("测试大量操作")
        void testManyOperations() {
            No155MinStack.MinStackEasy minStack = new No155MinStack.MinStackEasy();

            for (int i = 100; i >= 1; i--) {
                minStack.push(i);
                assertEquals(i, minStack.getMin());
            }

            for (int i = 1; i <= 100; i++) {
                assertEquals(i, minStack.getMin());
                minStack.pop();
            }
        }
    }

    @Nested
    @DisplayName("测试最优性能的解决方案 (MinStackOptimal)")
    class MinStackOptimalTest {

        @Test
        @DisplayName("测试示例操作序列")
        void testExample() {
            No155MinStack.MinStackOptimal minStack = new No155MinStack.MinStackOptimal();

            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);

            assertEquals(-3, minStack.getMin());

            minStack.pop();
            assertEquals(0, minStack.top());
            assertEquals(-2, minStack.getMin());
        }

        @Test
        @DisplayName("测试单元素")
        void testSingleElement() {
            No155MinStack.MinStackOptimal minStack = new No155MinStack.MinStackOptimal();

            minStack.push(5);
            assertEquals(5, minStack.top());
            assertEquals(5, minStack.getMin());
        }

        @Test
        @DisplayName("测试极值")
        void testExtremeValues() {
            No155MinStack.MinStackOptimal minStack = new No155MinStack.MinStackOptimal();

            minStack.push(Integer.MAX_VALUE);
            minStack.push(Integer.MIN_VALUE);

            assertEquals(Integer.MIN_VALUE, minStack.getMin());
            assertEquals(Integer.MIN_VALUE, minStack.top());

            minStack.pop();
            assertEquals(Integer.MAX_VALUE, minStack.getMin());
            assertEquals(Integer.MAX_VALUE, minStack.top());
        }

        @Test
        @DisplayName("测试重复最小值")
        void testDuplicateMin() {
            No155MinStack.MinStackOptimal minStack = new No155MinStack.MinStackOptimal();

            minStack.push(1);
            minStack.push(1);
            minStack.push(1);

            assertEquals(1, minStack.getMin());
            minStack.pop();
            assertEquals(1, minStack.getMin());
            minStack.pop();
            assertEquals(1, minStack.getMin());
        }

        @Test
        @DisplayName("测试大量操作")
        void testManyOperations() {
            No155MinStack.MinStackOptimal minStack = new No155MinStack.MinStackOptimal();

            for (int i = 100; i >= 1; i--) {
                minStack.push(i);
                assertEquals(i, minStack.getMin());
            }

            for (int i = 1; i <= 100; i++) {
                assertEquals(i, minStack.getMin());
                minStack.pop();
            }
        }
    }
}
