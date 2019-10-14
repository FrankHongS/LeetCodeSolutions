package dynamicprogramming.maxSum;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array =
//                {7, 6, 8, 6, 7}
                {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(solution.maxSum(array));
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
