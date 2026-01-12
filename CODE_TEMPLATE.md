# LeetCode 代码模板

## 解决方案类模板

### 类级注释模板

```java
/**
 * {编号}. {题目英文名} ({题目中文名})
 *
 * 难度: Easy/Medium/Hard
 * 标签: Array, Hash Table, Two Pointers, etc.
 * 链接: https://leetcode.com/problems/{problem-slug}/
 *
 * 题目描述:
 * {题目的英文描述}
 *
 * 示例:
 * Input: {输入示例}
 * Output: {输出示例}
 * Explanation: {解释}
 *
 * 约束条件:
 * - {约束1}
 * - {约束2}
 */
```

### 方法注释模板

```java
/**
 * 解决方案{N}: {方法名称} ({适用场景})
 *
 * 解题思路:
 * {详细描述解题思路，包括关键步骤和算法选择理由}
 *
 * 时间复杂度: O({复杂度}) - {说明}
 * 空间复杂度: O({复杂度}) - {说明}
 *
 * @param {参数名} {参数描述}
 * @return {返回值描述}
 */
```

## 测试类模板

### 基本结构

```java
@DisplayName("{编号}. {题目名}")
class No{XXX}{ProblemName}Test {

    private No{XXX}{ProblemName} solution;

    @BeforeEach
    void setUp() {
        solution = new No{XXX}{ProblemName}();
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of({参数1}, {参数2}, {期望结果}),
            // 更多测试用例
        );
    }

    @ParameterizedTest(name = "Easy Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试容易理解的解决方案")
    void testSolutionEasy(...) {
        // 测试实现
    }

    @ParameterizedTest(name = "Optimal Solution - Case {index}")
    @MethodSource("testCases")
    @DisplayName("测试最优性能的解决方案")
    void testSolutionOptimal(...) {
        // 测试实现
    }
}
```

## 包分类说明

| 包名 | 分类 | 典型题目 |
|------|------|----------|
| array | 数组 | Two Sum, 3Sum, Container With Most Water |
| string | 字符串 | Longest Substring, Valid Palindrome |
| linkedlist | 链表 | Reverse Linked List, Merge Two Lists |
| tree | 树 | Inorder Traversal, Validate BST |
| graph | 图 | Course Schedule, Number of Islands |
| dp | 动态规划 | Climbing Stairs, Longest Increasing Subsequence |
| backtracking | 回溯 | Permutations, N-Queens |
| greedy | 贪心 | Jump Game, Gas Station |
| binarysearch | 二分查找 | Search in Rotated Array |
| heap | 堆 | Kth Largest Element, Merge K Lists |
| stack | 栈 | Valid Parentheses, Daily Temperatures |
| queue | 队列 | Implement Queue using Stacks |
| math | 数学 | Happy Number, Pow(x, n) |
| bit | 位运算 | Single Number, Counting Bits |
| design | 设计 | LRU Cache, Min Stack |
| trie | 字典树 | Implement Trie, Word Search II |
| divideconquer | 分治 | Merge Sort, Quick Sort |

## 示例：完整的题目实现

查看项目中的示例文件：
- `src/main/java/com/leetcode/array/No001TwoSum.java`
- `src/main/java/com/leetcode/linkedlist/No002AddTwoNumbers.java`
- `src/main/java/com/leetcode/string/No003LongestSubstring.java`

以及对应的测试文件：
- `src/test/java/com/leetcode/array/No001TwoSumTest.java`
- `src/test/java/com/leetcode/linkedlist/No002AddTwoNumbersTest.java`
- `src/test/java/com/leetcode/string/No003LongestSubstringTest.java`
