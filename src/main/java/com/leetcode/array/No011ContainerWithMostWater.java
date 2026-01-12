package com.leetcode.array;

/**
 * 11. Container With Most Water (盛最多水的容器)
 *
 * 难度: Medium
 * 标签: Array, Two Pointers, Greedy
 * 链接: https://leetcode.com/problems/container-with-most-water/
 *
 * 题目描述:
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains
 * the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * 示例:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The vertical lines are at positions 1 and 8 with heights 8 and 7,
 * area = min(8,7) * (8-1) = 7 * 7 = 49
 *
 * 约束条件:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 */
public class No011ContainerWithMostWater {

    /**
     * 解决方案1: 暴力法 (容易理解)
     *
     * 解题思路:
     * 尝试所有可能的线对组合，计算每对之间可以容纳的水量。
     * 水量 = min(height[i], height[j]) * (j - i)
     *
     * 时间复杂度: O(n^2) - 需要检查所有线对组合
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param height 高度数组
     * @return 最大水量
     */
    public int solutionEasy(int[] height) {
        int maxArea = 0;

        // 遍历所有可能的线对
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 计算当前线对的容量
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                int area = width * minHeight;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    /**
     * 解决方案2: 双指针法 (最优性能)
     *
     * 解题思路:
     * 使用两个指针从数组两端向中间移动。每次移动较矮的那一端，
     * 因为移动较高的一端不可能获得更大的面积（宽度减小且高度不会增加）。
     *
     * 时间复杂度: O(n) - 只需遍历数组一次
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param height 高度数组
     * @return 最大水量
     */
    public int solutionOptimal(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // 计算当前容量
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            // 移动较矮的指针
            // 因为移动较高的指针只会让宽度减小，而高度不会增加
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
