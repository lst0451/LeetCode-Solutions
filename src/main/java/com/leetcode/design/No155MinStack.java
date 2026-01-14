package com.leetcode.design;

import java.util.Stack;

/**
 * 155. Min Stack (最小栈)
 *
 * 难度: Medium 标签: Stack, Design 链接: https://leetcode.com/problems/min-stack/
 *
 * 题目描述: Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * Implement the MinStack class: - MinStack() initializes the stack object. -
 * void push(int val) pushes the element val onto the stack. - void pop()
 * removes the element on the top of the stack. - int top() gets the top element
 * of the stack. - int getMin() retrieves the minimum element in the stack.
 *
 * You must implement a solution with O(1) time complexity for each function.
 *
 * 示例: Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]] Output: [null,null,null,null,-3,null,0,-2]
 *
 * 约束条件: - -2^31 <= val <= 2^31 - 1 - Methods pop, top and getMin operations
 * will always be called on non-empty stacks. - At most 3 * 10^4 calls will be
 * made to push, pop, top, and getMin.
 */
public class No155MinStack {

    /**
     * 解决方案1: 辅助栈法 (容易理解)
     *
     * 解题思路: 使用两个栈：一个主栈存储所有元素，一个辅助栈同步存储当前最小值。 每次push时，辅助栈存入当前最小值（新元素和辅助栈顶的较小者）。
     * 每次pop时，两个栈同步弹出。 getMin直接返回辅助栈顶元素。
     */
    public static class MinStackEasy {

        private Stack<Integer> mainStack;
        private Stack<Integer> minStack;

        /**
         * 初始化最小栈
         */
        public MinStackEasy() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
        }

        /**
         * 压入元素 时间复杂度: O(1)
         */
        public void push(int val) {
            mainStack.push(val);
            // 辅助栈存入当前最小值
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        /**
         * 弹出栈顶元素 时间复杂度: O(1)
         */
        public void pop() {
            mainStack.pop();
            minStack.pop();
        }

        /**
         * 获取栈顶元素 时间复杂度: O(1)
         */
        public int top() {
            return mainStack.peek();
        }

        /**
         * 获取最小元素 时间复杂度: O(1)
         */
        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * 解决方案2: 单栈法 - 存储差值 (最优性能)
     *
     * 解题思路: 只使用一个栈，存储当前值与最小值的差值。 用一个变量记录当前最小值。
     *
     * Push时：存入 val - min，如果差值为负，更新min为val。
     * Pop时：如果栈顶为负，说明当前最小值是pop前的元素，需要恢复之前的min。 Top时：如果栈顶为负，返回min；否则返回栈顶+min。
     * GetMin时：直接返回min。
     *
     * 注意：使用long避免整数溢出。
     *
     * 空间复杂度: O(n) - 只使用一个栈
     */
    public static class MinStackOptimal {

        private Stack<Long> stack;
        private long min;

        /**
         * 初始化最小栈
         */
        public MinStackOptimal() {
            stack = new Stack<>();
        }

        /**
         * 压入元素 时间复杂度: O(1)
         */
        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(0L);
                min = val;
            } else {
                // 存储差值
                stack.push((long) val - min);
                // 如果差值为负，更新最小值
                if (val < min) {
                    min = val;
                }
            }
        }

        /**
         * 弹出栈顶元素 时间复杂度: O(1)
         */
        public void pop() {
            long top = stack.pop();
            // 如果栈顶为负，需要恢复之前的最小值
            if (top < 0) {
                min = min - top;
            }
        }

        /**
         * 获取栈顶元素 时间复杂度: O(1)
         */
        public int top() {
            long top = stack.peek();
            // 如果栈顶为负，当前最小值就是栈顶元素的实际值
            if (top < 0) {
                return (int) min;
            } else {
                return (int) (top + min);
            }
        }

        /**
         * 获取最小元素 时间复杂度: O(1)
         */
        public int getMin() {
            return (int) min;
        }
    }
}
