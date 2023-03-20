package hw.hj3;

import util.ArraysUtil;

import java.util.*;

/**
 * 随机数
 * 题目描述：
 * 明明生成了N个1到200之间的随机整数。请你删除其中重复的数字，急相同的数字
 * 只保留一个，把其余相同的数去掉，然后把这些数从小到大排序，按照排好的顺序输出。
 * 数据范围：1<=n<=1000, 输入的数字大小满足1<=val<=500
 * 输入描述：
 * 第一行先输入随机整数的个数N。接下来的N行每行输入一个整数，代表明明生成的随机数
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = in.nextInt();
            }
            solution.insertSortWithDistinct(input);
            for (Integer item : input) {
                if (item != -1) {
                    System.out.println(item);
                }
            }
        }
    }

    private void insertSortWithDistinct(int[] input) {
        int maxIndex;
        int max;
        int length = input.length;
        int times = 1;
        while (times < length) {
            maxIndex = 0;
            max = input[maxIndex];
            for (int j = 0; j <= length - times; j++) {
                if (input[j] > max) {
                    maxIndex = j;
                    max = input[j];
                } else if (input[j] == max) {
                    if (j != maxIndex) {
                        input[j] = -1;
                    }
                }
            }
            ArraysUtil.swapElements(input, maxIndex, length - times);
            times++;
        }
    }

}
