package interview.noNeighborNumMaxSum;

/**
 * 输入一个整数数组，找到数组中不相邻元素的最大和
 * 例如: 输入 {1,5,3,9,4,7}, 输出 21(5+9+7)
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 5, 3, 9, 4, 7};
        System.out.println(solution.maxSum(input));
    }

    private int maxSum(int[] input) {
        if (input == null) {
            return 0;
        }
        int length = input.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return input[0];
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = input[0];
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + input[i - 1]);
        }
        return dp[length];
    }

}
