package dynamicprogramming.maxSum;

/**
 * 题目：最大和子数组
 * 给定一个数组，找到其中的一个连续子数组，其和最大
 * 例如：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 *
 * @see interview.noNeighborNumMaxSum.Solution, 数组的不相邻元素最大和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array =
//                {7, 6, 8, 6, 7}
                {1, -2, 3, 10, -4, 7, 2, -5};
//        System.out.println(solution.maxSum(array));

//        System.out.println(solution.maxSumContinuous2(array));
        System.out.println(solution.maxSumContinuous1(array));

    }

    /**
     * dp方式解决，状态转换方程（关键函数）dp[i],以第i个元素为结尾的最大子数组的和
     */
    public int maxSumContinuous1(int[] array) {
        int length = array.length;
        int[] dp = new int[length];
        int maxSum = dp[0] = array[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    // 数组中连续元素组成的子数组的最大和
    public int maxSumContinuous2(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int sum = 0;
        int greatest = Integer.MIN_VALUE;

        int start = 0, end = 0;

        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
                if (sum > greatest) {
                    start = i;
                }
            } else {
                sum += array[i];
            }

            if (sum > greatest) {
                end = i;
                greatest = sum;
            }
        }

        System.out.println("start: " + start + " end: " + end);

        return greatest;

    }

    // 数组中非连续元素组成的子数组的最大和
    public int maxSum(int[] array) {

        int position1 = 0;
        int sum1 = array[position1];
        position1 += 2;
        while (position1 < array.length) {

            int temp = array[position1];

            sum1 += temp;

            if (temp >= sum1) {
                sum1 = temp;
                position1 += 2;
            } else {
                if (temp <= 0) {
                    position1++;
                } else {
                    position1 += 2;
                }
            }

        }

        int position2 = 1;
        int sum2 = array[position2];
        while (position2 < array.length) {

            int temp = array[position2];

            sum2 += temp;

            if (temp >= sum2) {
                sum2 = temp;
                position2 += 2;
            } else {
                if (temp <= 0) {
                    position2++;
                } else {
                    position2 += 2;
                }
            }

        }

        return Math.max(sum1, sum2);
    }

}
