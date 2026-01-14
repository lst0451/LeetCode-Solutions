package com.leetcode.dp;

/**
 * 70. Climbing Stairs (爬楼梯)
 *
 * 难度: Easy 标签: Dynamic Programming, Math, Memoization 链接:
 * https://leetcode.com/problems/climbing-stairs/
 *
 * 题目描述: You are climbing a staircase. It takes n steps to reach the top. Each
 * time you can either climb 1 or 2 steps. In how many distinct ways can you
 * climb to the top?
 *
 * 示例: Input: n = 3 Output: 3 Explanation: There are three ways to climb to the
 * top. 1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 *
 * 约束条件: - 1 <= n <= 45
 */
public class No070ClimbingStairs {

    /**
     * 解决方案1: 递归 + 记忆化 (容易理解)
     *
     * 解题思路: 到达第n阶的方法数 = 到达第(n-1)阶的方法数 + 到达第(n-2)阶的方法数
     * 这是因为我们可以从第(n-1)阶跨1步，或从第(n-2)阶跨2步到达第n阶。 使用记忆化避免重复计算。
     *
     * 时间复杂度: O(n) - 每个状态只计算一次 空间复杂度: O(n) - 递归调用栈和记忆化数组
     *
     * @param n 楼梯阶数
     * @return 不同的爬楼梯方法数
     */
    public int solutionEasy(int n) {
        // 记忆化数组，memo[i]表示到达第i阶的方法数
        int[] memo = new int[n + 1];
        return climbHelper(n, memo);
    }

    private int climbHelper(int n, int[] memo) {
        // 基础情况
        if (n <= 2) {
            return n;
        }

        // 如果已经计算过，直接返回
        if (memo[n] != 0) {
            return memo[n];
        }

        // 递归计算并记忆
        memo[n] = climbHelper(n - 1, memo) + climbHelper(n - 2, memo);
        return memo[n];
    }

    /**
     * 解决方案2: 动态规划（空间优化）(最优性能)
     *
     * 解题思路: 使用自底向上的动态规划。由于每个状态只依赖前两个状态， 所以只需要两个变量来保存前两个状态，无需完整数组。
     * 本质上就是计算斐波那契数列。
     *
     * 时间复杂度: O(n) - 遍历一次 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param n 楼梯阶数
     * @return 不同的爬楼梯方法数
     */
    public int solutionOptimal(int n) {
        if (n <= 2) {
            return n;
        }

        // prev1表示到达第(i-1)阶的方法数
        // prev2表示到达第(i-2)阶的方法数
        int prev1 = 2;  // f(2) = 2
        int prev2 = 1;  // f(1) = 1

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
