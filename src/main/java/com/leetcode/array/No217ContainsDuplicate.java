package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate (存在重复元素)
 *
 * 难度: Easy 标签: Array, Hash Table, Sorting 链接:
 * https://leetcode.com/problems/contains-duplicate/
 *
 * 题目描述: Given an integer array nums, return true if any value appears at least
 * twice in the array, and return false if every element is distinct.
 *
 * 示例: Input: nums = [1,2,3,1] Output: true
 *
 * Input: nums = [1,2,3,4] Output: false
 *
 * 约束条件: - 1 <= nums.length <= 10^5 - -10^9 <= nums[i] <= 10^9
 */
public class No217ContainsDuplicate {

    /**
     * 解决方案1: 排序法 (容易理解)
     *
     * 解题思路: 先对数组进行排序，然后检查相邻元素是否相等。 如果存在相等的相邻元素，说明有重复。
     *
     * 时间复杂度: O(n log n) - 排序的复杂度 空间复杂度: O(1) 或 O(n) - 取决于排序算法
     *
     * @param nums 整数数组
     * @return 是否存在重复元素
     */
    public boolean solutionEasy(int[] nums) {
        // 复制数组以避免修改原数组
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // 检查相邻元素是否相等
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == sorted[i - 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解决方案2: 哈希表法 (最优性能)
     *
     * 解题思路: 使用HashSet存储已经遍历过的元素。遍历数组时，如果当前元素 已经在Set中，说明是重复元素，返回true。否则将元素加入Set。
     *
     * 时间复杂度: O(n) - 遍历数组一次，HashSet操作平均O(1) 空间复杂度: O(n) - HashSet存储最多n个元素
     *
     * @param nums 整数数组
     * @return 是否存在重复元素
     */
    public boolean solutionOptimal(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // 如果已经见过这个数，说明有重复
            if (seen.contains(num)) {
                return true;
            }
            // 将当前数加入集合
            seen.add(num);
        }

        return false;
    }

    /**
     * 解决方案3: 利用Set大小判断 (简洁版)
     *
     * 解题思路: 将数组所有元素放入HashSet，比较Set大小和数组长度。 如果Set大小小于数组长度，说明有重复元素。
     *
     * 时间复杂度: O(n) - 遍历数组一次 空间复杂度: O(n) - HashSet存储最多n个元素
     *
     * @param nums 整数数组
     * @return 是否存在重复元素
     */
    public boolean solutionConcise(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}
