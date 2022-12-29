package dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一个整数数组coins，表示不同金额的硬币，以及一个整数amount，表示总金额，
 * 计算并返回可以凑成总金额所需的最小的硬币数；如果找不到任何一种组合，返回-1。
 * <p>
 * Created by Frank_Hon on 2022/10/20 11:04 AM.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 3, 5};
        int amount = 7;
        System.out.println(solution.coinsChange(coins, amount));
    }

    private List<Integer> coinsChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        List<List<Integer>> items = new ArrayList<>(amount + 1);
        Arrays.fill(dp, -1);
        dp[0] = 0;
        items.add(0, new ArrayList<>());
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        List<Integer> temp = new ArrayList<>(items.get(i - coin));
                        temp.add(coin);
                        items.add(i, temp);
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        if (dp[i] > dp[i - coin] + 1) {
                            List<Integer> temp = new ArrayList<>(items.get(i - coin));
                            temp.add(coin);
                            items.add(i, temp);
                        }
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);//关键，利用上一步结果
                    }
                }
            }
        }
        return items.get(amount);
    }

}
