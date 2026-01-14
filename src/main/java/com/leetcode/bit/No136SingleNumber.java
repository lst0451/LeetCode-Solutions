package com.leetcode.bit;

/**
 * 136. Single Number (只出现一次的数字)
 *
 * 难度: Easy 标签: Array, Bit Manipulation 链接:
 * https://leetcode.com/problems/single-number/
 *
 * 题目描述: Given a non-empty array of integers nums, every element appears twice
 * except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 *
 * 示例: Input: nums = [4,1,2,1,2] Output: 4
 *
 * 约束条件: - 1 <= nums.length <= 3 * 10^4 - -3 * 10^4 <= nums[i] <= 3 * 10^4 -
 * Each element in the array appears twice except for one element which appears
 * only once.
 */
public class No136SingleNumber {

    /**
     * 解决方案1: 排序法 (容易理解)
     *
     * 解题思路: 先对数组排序，然后成对检查相邻元素。如果某对相邻元素不相等， 第一个就是答案。如果遍历完仍未找到，最后一个元素就是答案。
     * 这种方法直观但不满足O(1)空间的要求。
     *
     * 时间复杂度: O(n log n) - 排序的复杂度 空间复杂度: O(1) 或 O(log n) - 取决于排序算法
     *
     * @param nums 整数数组
     * @return 只出现一次的数字
     */
    public int solutionEasy(int[] nums) {
        // 复制数组以避免修改原数组
        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);

        // 成对检查
        for (int i = 0; i < sorted.length - 1; i += 2) {
            if (sorted[i] != sorted[i + 1]) {
                return sorted[i];
            }
        }

        // 如果没找到，答案是最后一个元素
        return sorted[sorted.length - 1];
    }

    /**
     * 解决方案2: 异或法 (最优性能)
     *
     * 解题思路: 利用异或运算的特性： 1. a ^ a = 0 (相同数异或为0) 2. a ^ 0 = a (任何数与0异或为自身) 3.
     * 异或满足交换律和结合律
     *
     * 所有数异或后，成对出现的数互相抵消变成0，最后留下的就是只出现一次的数。
     *
     * 时间复杂度: O(n) - 遍历数组一次 空间复杂度: O(1) - 只使用一个变量
     *
     * @param nums 整数数组
     * @return 只出现一次的数字
     */
    public int solutionOptimal(int[] nums) {
        int result = 0;

        for (int num : nums) {
            // 所有数异或，成对的会抵消变成0
            result ^= num;
        }

        // 最后result就是只出现一次的数
        return result;
    }
}
