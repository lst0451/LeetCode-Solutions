package com.leetcode.array;

/**
 * 66. Plus One (加一)
 *
 * 难度: Easy 标签: Array, Math 链接: https://leetcode.com/problems/plus-one/
 *
 * 题目描述: You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer. The digits are ordered
 * from most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * 示例: Input: digits = [1,2,3] Output: [1,2,4] Explanation: The array represents
 * the integer 123. Incrementing by one gives 123 + 1 = 124.
 *
 * 约束条件: - 1 <= digits.length <= 100 - 0 <= digits[i] <= 9 - digits does not
 * contain any leading 0's.
 */
public class No066PlusOne {

    /**
     * 解决方案1: 逐位进位法 (容易理解)
     *
     * 解题思路: 从最低位（数组末尾）开始，加1并处理进位。 如果当前位加1后小于10，直接返回结果。 如果等于10，设为0并继续处理更高位。
     * 如果最高位也有进位（如999->1000），需要创建新数组。
     *
     * 时间复杂度: O(n) - 最坏情况下遍历所有位 空间复杂度: O(n) - 最坏情况下需要新数组（如999->1000）
     *
     * @param digits 表示大整数的数组
     * @return 加一后的结果数组
     */
    public int[] solutionEasy(int[] digits) {
        int n = digits.length;

        // 从最低位开始处理
        for (int i = n - 1; i >= 0; i--) {
            // 当前位加1
            digits[i]++;

            // 如果没有进位，直接返回
            if (digits[i] < 10) {
                return digits;
            }

            // 有进位，当前位设为0，继续处理更高位
            digits[i] = 0;
        }

        // 如果循环结束还没返回，说明最高位也产生了进位
        // 例如: 999 -> 1000
        int[] result = new int[n + 1];
        result[0] = 1;
        // 其余位默认就是0，无需额外设置

        return result;
    }

    /**
     * 解决方案2: 优化版本 (最优性能)
     *
     * 解题思路: 与方案1相同的逻辑，但使用更简洁的代码。 利用模运算和除法来处理加法和进位。 当需要扩展数组时，才创建新数组。
     *
     * 时间复杂度: O(n) - 最坏情况下遍历所有位 空间复杂度: O(n) - 最坏情况下需要新数组
     *
     * @param digits 表示大整数的数组
     * @return 加一后的结果数组
     */
    public int[] solutionOptimal(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 只有当前位是9时，加1才会产生进位
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 当前位是9，加1变成0，继续处理进位
            digits[i] = 0;
        }

        // 所有位都是9的情况：需要扩展数组
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
