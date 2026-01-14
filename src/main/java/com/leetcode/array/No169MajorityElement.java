package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element (多数元素)
 *
 * 难度: Easy 标签: Array, Hash Table, Divide and Conquer, Sorting, Counting 链接:
 * https://leetcode.com/problems/majority-element/
 *
 * 题目描述: Given an array nums of size n, return the majority element. The
 * majority element is the element that appears more than ⌊n / 2⌋ times. You may
 * assume that the majority element always exists in the array.
 *
 * 示例: Input: nums = [3,2,3] Output: 3
 *
 * Input: nums = [2,2,1,1,1,2,2] Output: 2
 *
 * 约束条件: - n == nums.length - 1 <= n <= 5 * 10^4 - -10^9 <= nums[i] <= 10^9
 */
public class No169MajorityElement {

    /**
     * 解决方案1: 哈希表计数法 (容易理解)
     *
     * 解题思路: 使用HashMap统计每个元素出现的次数，然后找出出现次数超过n/2的元素。 逻辑直观，易于理解。
     *
     * 时间复杂度: O(n) - 遍历数组一次 空间复杂度: O(n) - HashMap存储最多n个不同元素
     *
     * @param nums 整数数组
     * @return 多数元素
     */
    public int solutionEasy(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int threshold = nums.length / 2;

        for (int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            if (count > threshold) {
                return num;
            }
            counts.put(num, count);
        }

        // 根据题目保证，总是存在多数元素，不应该到达这里
        throw new IllegalArgumentException("No majority element found");
    }

    /**
     * 解决方案2: Boyer-Moore投票算法 (最优性能)
     *
     * 解题思路: 如果一个数是多数元素（出现次数 > n/2），那么它的出现次数比其他所有元素 出现次数之和还多。
     *
     * 算法思想：维护一个候选者和计数器。遍历数组： - 如果计数为0，设当前元素为新候选者 - 如果当前元素等于候选者，计数+1 - 否则计数-1
     *
     * 最后的候选者就是多数元素。
     *
     * 时间复杂度: O(n) - 遍历数组一次 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param nums 整数数组
     * @return 多数元素
     */
    public int solutionOptimal(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // 如果计数为0，选择新的候选者
            if (count == 0) {
                candidate = num;
            }

            // 如果当前元素等于候选者，计数+1；否则计数-1
            count += (num == candidate) ? 1 : -1;
        }

        // candidate就是多数元素
        return candidate;
    }

    /**
     * 解决方案3: 排序法 (备选方案)
     *
     * 解题思路: 排序后，多数元素一定在数组中间位置（索引 n/2）。 因为它出现次数超过n/2，无论偏向哪边，中间位置一定是它。
     *
     * 时间复杂度: O(n log n) - 排序的复杂度 空间复杂度: O(1) 或 O(n) - 取决于排序算法
     *
     * @param nums 整数数组
     * @return 多数元素
     */
    public int solutionSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
