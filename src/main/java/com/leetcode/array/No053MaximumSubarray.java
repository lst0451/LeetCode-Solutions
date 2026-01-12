package com.leetcode.array;

/**
 * 53. Maximum Subarray (最大子数组和)
 *
 * 难度: Medium
 * 标签: Array, Divide and Conquer, Dynamic Programming
 * 链接: https://leetcode.com/problems/maximum-subarray/
 *
 * 题目描述:
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * 示例:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * 约束条件:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 */
public class No053MaximumSubarray {

    /**
     * 解决方案1: 暴力法 (容易理解)
     *
     * 解题思路:
     * 枚举所有可能的子数组，计算每个子数组的和，记录最大值。
     *
     * 时间复杂度: O(n^2) - 需要检查所有子数组
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param nums 整数数组
     * @return 最大子数组和
     */
    public int solutionEasy(int[] nums) {
        int maxSum = nums[0];

        // 枚举所有子数组的起点
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            // 枚举所有以i为起点的子数组
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    /**
     * 解决方案2: Kadane算法 (最优性能)
     *
     * 解题思路:
     * 动态规划思想。维护以当前位置结尾的最大子数组和。
     * 对于每个位置，要么加入前面的子数组，要么重新开始。
     * currentSum = max(nums[i], currentSum + nums[i])
     *
     * 时间复杂度: O(n) - 只需遍历数组一次
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param nums 整数数组
     * @return 最大子数组和
     */
    public int solutionOptimal(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 要么加入当前元素到之前的子数组，要么重新开始
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
