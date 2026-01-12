package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 3Sum (三数之和)
 *
 * 难度: Medium
 * 标签: Array, Two Pointers, Sorting
 * 链接: https://leetcode.com/problems/3sum/
 *
 * 题目描述:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * 示例:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * 约束条件:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 */
public class No015ThreeSum {

    /**
     * 解决方案1: 排序 + 双指针 + Set去重 (容易理解)
     *
     * 解题思路:
     * 先排序数组，固定一个数，然后使用双指针在剩余数组中查找两个数使得三数之和为0。
     * 使用Set来自动去除重复的三元组。
     *
     * 时间复杂度: O(n^2) - 外层循环O(n)，内层双指针O(n)
     * 空间复杂度: O(n) - Set存储结果
     *
     * @param nums 整数数组
     * @return 所有和为0的不重复三元组
     */
    public List<List<Integer>> solutionEasy(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);

        // 固定第一个数
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前数大于0，后面不可能有和为0的组合
            if (nums[i] > 0) break;

            int left = i + 1;
            int right = nums.length - 1;

            // 双指针查找
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    /**
     * 解决方案2: 排序 + 双指针 + 跳过重复 (最优性能)
     *
     * 解题思路:
     * 同样使用排序和双指针，但通过跳过重复元素来避免生成重复的三元组，
     * 而不是使用Set，这样可以节省空间并提高效率。
     *
     * 时间复杂度: O(n^2) - 外层循环O(n)，内层双指针O(n)
     * 空间复杂度: O(1) - 不计结果空间，只使用常量级额外空间
     *
     * @param nums 整数数组
     * @return 所有和为0的不重复三元组
     */
    public List<List<Integer>> solutionOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 优化：如果当前数大于0，后面不可能有和为0的组合
            if (nums[i] > 0) break;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 跳过重复的right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
