package com.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses (有效的括号)
 *
 * 难度: Easy
 * 标签: String, Stack
 * 链接: https://leetcode.com/problems/valid-parentheses/
 *
 * 题目描述:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 *
 * 示例:
 * Input: s = "()"
 * Output: true
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Input: s = "(]"
 * Output: false
 *
 * 约束条件:
 * - 1 <= s.length <= 10^4
 * - s consists of parentheses only '()[]{}'.
 */
public class No020ValidParentheses {

    /**
     * 解决方案1: 栈 + if-else判断 (容易理解)
     *
     * 解题思路:
     * 使用栈来存储左括号。遇到右括号时，检查栈顶是否是匹配的左括号。
     * 使用if-else分支明确处理每种括号类型。
     *
     * 时间复杂度: O(n) - 遍历字符串一次
     * 空间复杂度: O(n) - 栈可能存储所有字符
     *
     * @param s 括号字符串
     * @return 是否有效
     */
    public boolean solutionEasy(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 左括号入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // 右括号匹配
            else {
                // 栈空，无法匹配
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // 检查是否匹配
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        // 栈应该为空
        return stack.isEmpty();
    }

    /**
     * 解决方案2: 栈 + HashMap (最优性能)
     *
     * 解题思路:
     * 使用HashMap存储括号对应关系，使代码更简洁。
     * 遇到左括号入栈，遇到右括号检查栈顶是否匹配。
     *
     * 时间复杂度: O(n) - 遍历字符串一次
     * 空间复杂度: O(n) - 栈可能存储所有字符
     *
     * @param s 括号字符串
     * @return 是否有效
     */
    public boolean solutionOptimal(String s) {
        // 创建括号映射表
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 如果是右括号
            if (pairs.containsKey(c)) {
                // 检查栈顶是否匹配
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
            // 左括号入栈
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
