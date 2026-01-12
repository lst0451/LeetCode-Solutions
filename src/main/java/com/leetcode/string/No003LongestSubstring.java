package com.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters (无重复字符的最长子串)
 *
 * 难度: Medium
 * 标签: Hash Table, String, Sliding Window
 * 链接: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 题目描述:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * 示例:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * 约束条件:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 */
public class No003LongestSubstring {

    /**
     * 解决方案1: 滑动窗口 + HashSet (容易理解)
     *
     * 解题思路:
     * 使用滑动窗口维护一个无重复字符的子串。使用HashSet存储当前窗口中的字符，
     * 右指针不断扩展窗口，遇到重复字符时，左指针收缩窗口直到移除重复字符。
     *
     * 时间复杂度: O(n) - 每个字符最多被访问两次（左右指针各一次）
     * 空间复杂度: O(min(n, m)) - m是字符集大小，n是字符串长度
     *
     * @param s 输入字符串
     * @return 最长无重复子串的长度
     */
    public int solutionEasy(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // 右指针遍历字符串
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符已存在，移动左指针直到移除重复字符
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }

            // 将当前字符加入窗口
            window.add(currentChar);

            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * 解决方案2: 滑动窗口 + HashMap (最优性能)
     *
     * 解题思路:
     * 使用HashMap存储字符及其最新出现的位置。当遇到重复字符时，可以直接
     * 跳过中间的字符，将左指针移动到重复字符上次出现位置的下一位。
     * 这样可以减少不必要的左指针移动。
     *
     * 时间复杂度: O(n) - 只需遍历字符串一次
     * 空间复杂度: O(min(n, m)) - m是字符集大小，n是字符串长度
     *
     * @param s 输入字符串
     * @return 最长无重复子串的长度
     */
    public int solutionOptimal(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 存储字符到索引的映射
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果字符已存在且在当前窗口内，更新左指针
            if (charIndexMap.containsKey(currentChar)) {
                // 左指针移动到重复字符上次出现位置的下一位
                // 使用Math.max确保左指针只向右移动
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // 更新字符的最新位置
            charIndexMap.put(currentChar, right);

            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
