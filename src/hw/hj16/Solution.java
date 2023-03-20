package hw.hj16;

import java.util.*;

/**
 * Java不支持泛型数组，即List<String>[]; 但支持泛型变量为数组，即List<String[]>
 */
public class Solution {

    private int[] belongs;

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int sum = in.nextInt();
            int m = in.nextInt();
            int[] prices = new int[m];
            int[] weights = new int[m];
            int[] belongs = new int[m];
            for (int i = 0; i < m; i++) {
                prices[i] = in.nextInt();
                weights[i] = in.nextInt();
                belongs[i] = in.nextInt();
            }
            System.out.println(solution.mostValuable(sum, prices, weights, belongs));
        }
    }

    //todo
    private int mostValuable(int sum, int[] prices, int[] weights, int[] belongs) {
        int[] dp = new int[sum / 10 + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.fill(dp, 0);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                int price = prices[j];
                if (i >= price / 10) {
                    int temp;
                    if (belongs[j] != 0) {
                        int parentIndex = belongs[j] - 1;
                        int parentPrice = prices[parentIndex];
                        if (i >= price / 10 + parentPrice / 10) {
                            List<Integer> list = map.get(i - price / 10 - parentPrice / 10);
                            if (list == null || (!list.contains(j) && !list.contains(parentIndex))) {
                                temp = dp[i - price / 10 - parentPrice / 10] + price * weights[j] + parentPrice * weights[parentIndex];
                                if (temp > dp[i]) {
                                    List<Integer> result = new ArrayList<>();
                                    if (list != null) {
                                        result.addAll(list);
                                    }
                                    result.add(j);
                                    result.add(parentIndex);
                                    map.put(i, result);
                                    dp[i] = temp;
                                }
                            }
                        }
                    } else {
                        List<Integer> list = map.get(i - price / 10);
                        if (list == null || !list.contains(j)) {
                            temp = dp[i - price / 10] + price * weights[j];
                            if (temp > dp[i]) {
                                List<Integer> result = new ArrayList<>();
                                if (list != null) {
                                    result.addAll(list);
                                }
                                result.add(j);
                                map.put(i, result);
                                dp[i] = temp;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(map.get(sum/10));
        return dp[sum / 10];
    }

}
