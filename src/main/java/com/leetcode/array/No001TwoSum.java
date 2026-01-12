package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum (两数之和)
 *
 * 难度: Easy
 * 标签: Array, Hash Table
 * 链接: https://leetcode.com/problems/two-sum/
 *
 * 题目描述:
 * Given an array of integers nums and an integer target, return indices of
 * the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice.
 *
 * 示例:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * 约束条件:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 */
public class No001TwoSum {

    /**
     * 解决方案1: 暴力搜索法 (容易理解)
     *
     * 解题思路:
     * 使用两层循环遍历数组，对于每个元素，检查数组中是否存在另一个元素
     * 使得两者之和等于目标值。
     *
     * 时间复杂度: O(n^2) - 两层嵌套循环
     * 空间复杂度: O(1) - 只使用了常量级额外空间
     *
     * @param nums 整数数组
     * @param target 目标和
     * @return 两个数字的索引数组
     */
    public int[] solutionEasy(int[] nums, int target) {
        // 外层循环遍历每个元素
        for (int i = 0; i < nums.length; i++) {
            // 内层循环查找匹配的元素
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // 根据题目约束，总是存在解，所以不应该到达这里
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 解决方案2: 哈希表法 (最优性能)
     *
     * 解题思路:
     * 使用HashMap存储已经遍历过的元素及其索引。对于当前元素，计算
     * target - nums[i]，然后在HashMap中查找是否存在这个差值。
     *
     * 时间复杂度: O(n) - 只需遍历数组一次
     * 空间复杂度: O(n) - 需要额外的HashMap存储最多n个元素
     *
     * @param nums 整数数组
     * @param target 目标和
     * @return 两个数字的索引数组
     */
    public int[] solutionOptimal(int[] nums, int target) {
        // 使用HashMap存储值到索引的映射
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // 检查补数是否已经在map中
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // 将当前元素存入map
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
