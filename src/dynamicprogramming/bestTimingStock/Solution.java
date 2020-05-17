package dynamicprogramming.bestTimingStock;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * <p>
 * Created by Frank_Hon on 2020-02-02 17:31.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices =
                {4, 2, 1, 7};
//                {1, 2, 3, 4, 5, 6, 7, 8};
//                {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }

    // 贪心算法 O(n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        int index = 0;
        int totalProfit = 0;
        while (index < length) {
            int buyPoint = prices[index];
            if (index + 1 < length) {
                int newBuyPoint = prices[index + 1];
                while (newBuyPoint < buyPoint) {
                    buyPoint = newBuyPoint;
                    index++;
                    if (index + 1 < length) {
                        newBuyPoint = prices[index + 1];
                    } else {
                        break;
                    }
                }
            }
            index++;

            if (index >= length) {
                break;
            }
            int sellPoint = prices[index];
            if (index + 1 < length) {
                int newSellPoint = prices[index + 1];
                while (newSellPoint > sellPoint) {
                    sellPoint = newSellPoint;
                    index++;
                    if (index + 1 < length) {
                        newSellPoint = prices[index + 1];
                    } else {
                        break;
                    }
                }
            }
            index++;

            int profit = sellPoint - buyPoint;
            if (profit > 0) {
                System.out.println(String.format("buy=%d, sell=%d", buyPoint, sellPoint));
                totalProfit += profit;
            }
        }
        return totalProfit;
    }

    // 其他人的解法，由于不需要输出买卖点，所以下面这种可取
    public int maxProfit02(int[] prices) {
        int intes = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > prices[i-1])
                intes += prices[i] - prices[i-1];
        }

        return intes;
    }

}