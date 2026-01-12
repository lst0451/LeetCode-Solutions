# LeetCode Top 150 Solutions (Java)

## 项目简介

本项目包含LeetCode Top 150高频面试题的Java解决方案。每道题目提供两种解法：
- **容易理解的解决方案** (solutionEasy): 注重代码可读性，适合初学者理解
- **最优性能的解决方案** (solutionOptimal): 追求时间和空间复杂度最优

## 项目特点

- 标准Maven项目结构
- 完整的单元测试覆盖 (JUnit 5)
- 详细的中英文注释
- 按题目类型分类组织
- 统一的代码风格 (EditorConfig)
- 包含时间/空间复杂度分析

## 技术栈

- Java 17
- Maven 3.x
- JUnit 5.10.1

## 快速开始

### 环境要求
- JDK 17 或更高版本
- Maven 3.6 或更高版本

### 运行测试

#### 运行所有测试
```bash
mvn test
```

#### 运行特定分类的测试
```bash
mvn test -Dtest="com.leetcode.array.*Test"
```

#### 运行单个题目的测试
```bash
mvn test -Dtest="No001TwoSumTest"
```

### 编译项目
```bash
mvn clean compile
```

## 项目结构

```
LeetCode/
├── src/main/java/com/leetcode/    # 题目解决方案
│   ├── array/                     # 数组类题目
│   ├── linkedlist/                # 链表类题目
│   ├── string/                    # 字符串类题目
│   ├── tree/                      # 树类题目
│   ├── dp/                        # 动态规划题目
│   ├── graph/                     # 图类题目
│   ├── backtracking/              # 回溯类题目
│   ├── greedy/                    # 贪心算法题目
│   ├── binarysearch/              # 二分查找题目
│   ├── heap/                      # 堆/优先队列题目
│   ├── stack/                     # 栈类题目
│   ├── queue/                     # 队列类题目
│   ├── math/                      # 数学类题目
│   ├── bit/                       # 位运算题目
│   ├── design/                    # 设计类题目
│   ├── trie/                      # 字典树题目
│   ├── divideconquer/             # 分治算法题目
│   └── common/                    # 公共数据结构
├── src/test/java/com/leetcode/    # 单元测试
└── docs/                          # 文档目录
```

## 题目索引

详见:
- [按编号索引](docs/PROBLEM_INDEX.md)
- [按分类索引](docs/CATEGORY_INDEX.md)

### 进度统计

| 分类 | 完成数 | 总数 |
|------|--------|------|
| 数组 | 1 | 25 |
| 字符串 | 1 | 15 |
| 链表 | 1 | 10 |
| 树 | 0 | 20 |
| 动态规划 | 0 | 30 |
| 其他 | 0 | 50 |
| **总计** | **3** | **150** |

## 代码规范

### 文件命名规范
- 格式: `No{编号}{题目名称}.java`
- 示例: `No001TwoSum.java`, `No002AddTwoNumbers.java`
- 编号使用3位数字补零

### 方法命名规范
- 容易理解的方法: `solutionEasy()`
- 最优性能的方法: `solutionOptimal()`

### 注释规范
每个题目类必须包含:
- 题目描述 (中英文)
- 难度标签
- 相关标签
- LeetCode链接
- 示例和约束条件
- 每个方法的解题思路
- 时间和空间复杂度分析

详见 [CODE_TEMPLATE.md](CODE_TEMPLATE.md)

## 添加新题目

1. 确定题目分类，在对应包下创建文件
2. 使用代码模板创建解决方案类
3. 创建对应的测试类
4. 实现两种解决方案
5. 编写测试用例
6. 运行测试确保通过
7. 更新题目索引文档

## 许可证

MIT License
