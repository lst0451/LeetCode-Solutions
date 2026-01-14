package com.leetcode.array;

/**
 * 26. Remove Duplicates from Sorted Array (删除有序数组中的重复项)
 *
 * 难度: Easy 标签: Array, Two Pointers 链接:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * 题目描述: Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same. Then return the
 * number of unique elements in nums.
 *
 * 示例: Input: nums = [1,1,2] Output: 2, nums = [1,2,_] Explanation: Your
 * function should return k = 2, with the first two elements of nums being 1 and
 * 2 respectively.
 *
 * 约束条件: - 1 <= nums.length <= 3 * 10^4 - -100 <= nums[i] <= 100 - nums is
 * sorted in non-decreasing order.
 */
public class No026RemoveDuplicates {

    /**
     * 解决方案1: 双指针法 (容易理解)
     *
     * 解题思路: 使用两个指针，慢指针指向当前不重复元素的位置，快指针遍历数组。 当快指针遇到新元素时，将其复制到慢指针位置并移动慢指针。
     * 逻辑清晰，每一步都有明确的含义。
     *
     * 时间复杂度: O(n) - 遍历数组一次 空间复杂度: O(1) - 原地修改，只使用常量级额外空间
     *
     * @param nums 有序整数数组
     * @return 不重复元素的个数
     */
    public int solutionEasy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // slow指向当前不重复序列的最后一个元素
        int slow = 0;

        // fast用于遍历整个数组
        for (int fast = 1; fast < nums.length; fast++) {
            // 当发现新元素时（与slow位置的元素不同）
            if (nums[fast] != nums[slow]) {
                // 移动slow指针，然后将新元素放到slow位置
                slow++;
                nums[slow] = nums[fast];
            }
            // 如果相同，fast继续前进寻找新元素
        }

        // 返回不重复元素的个数（长度 = 索引 + 1）
        return slow + 1;
    }

    /**
     * 解决方案2: 优化的双指针法 (最优性能)
     *
     * 解题思路: 与方案1相同，但增加了一个小优化：当slow + 1 == fast时， 无需复制元素（因为它们已经在正确位置）。
     * 这减少了不必要的数组写入操作。
     *
     * 时间复杂度: O(n) - 遍历数组一次 空间复杂度: O(1) - 原地修改，只使用常量级额外空间
     *
     * @param nums 有序整数数组
     * @return 不重复元素的个数
     */
    public int solutionOptimal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 只有当需要移动时才复制（避免不必要的写操作）
                if (slow != fast) {
                    nums[slow] = nums[fast];
                }
            }
        }

        return slow + 1;
    }
}
