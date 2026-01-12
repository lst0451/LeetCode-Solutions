package com.leetcode.array;

/**
 * 121. Best Time to Buy and Sell Stock (买卖股票的最佳时机)
 *
 * 难度: Easy
 * 标签: Array, Dynamic Programming
 * 链接: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 题目描述:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve
 * any profit, return 0.
 *
 * 示例:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *
 * 约束条件:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 */
public class No121BestTimeToBuyAndSellStock {

    /**
     * 解决方案1: 暴力法 (容易理解)
     *
     * 解题思路:
     * 枚举所有可能的买入和卖出日期组合，计算每次交易的利润，记录最大值。
     * 买入日期必须在卖出日期之前。
     *
     * 时间复杂度: O(n^2) - 需要检查所有买卖组合
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int solutionEasy(int[] prices) {
        int maxProfit = 0;

        // 枚举所有买入日期
        for (int buy = 0; buy < prices.length; buy++) {
            // 枚举所有在买入日期之后的卖出日期
            for (int sell = buy + 1; sell < prices.length; sell++) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    /**
     * 解决方案2: 一次遍历 (最优性能)
     *
     * 解题思路:
     * 维护到目前为止的最低价格，以及最大利润。
     * 对于每一天，计算如果今天卖出能获得的利润（今天价格 - 最低价格）。
     *
     * 时间复杂度: O(n) - 只需遍历数组一次
     * 空间复杂度: O(1) - 只使用常量级额外空间
     *
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int solutionOptimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // 更新最低价格
            if (price < minPrice) {
                minPrice = price;
            }
            // 计算如果今天卖出的利润
            else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
