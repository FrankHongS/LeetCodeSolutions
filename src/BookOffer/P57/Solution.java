package BookOffer.P57;

import java.util.*;

/**
 * Created by Frank_Hon on 2020/12/5 6:57 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 和为s的数字
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array1 = {3, 1, -1, 0, 7, 1};
//        int sum1 = 0;
//        int[] target1 = solution.findNumbersWithSum1(array1, sum1);
//        Util.printIntArray(target1);

//        int[] array2 = {1, 2, 4, 7, 11, 15};
//        int sum2 = 15;
//        int[] target2 = solution.findNumbersWithSum2(array2, sum2);
//        Util.printIntArray(target2);

        int sum3 = 99;
        System.out.println(solution.findContinuousSequence(sum3));
    }

    // 题目1：输入一个数组和一个数字s，在数组中查找两个数，使得它们的和正好为s。如果有多对
    // 数字的和等于s，则输出任意一对数字索引即可
    private int[] findNumbersWithSum1(int[] array, int sum) {
        if (array == null) {
            return new int[]{};
        }
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            if (helper.containsKey(val)) {
                return new int[]{helper.get(val), i};
            }
            helper.put(sum - val, i);
        }
        return new int[]{};
    }

    // 题目2：输入一个`递增排序`的数组和一个数字s，在数组中查找两个数，使得它们的和
    // 正好为s。如果有多对数字的和等于s，则输出任意一对即可
    private int[] findNumbersWithSum2(int[] array, int sum) {
        if (array == null || array.length <= 1) {
            return new int[]{};
        }
        int headIndex = 0, tailIndex = array.length - 1;
        while (headIndex < tailIndex) {
            int head = array[headIndex];
            int tail = array[tailIndex];
            if (head + tail > sum) {
                tailIndex -= 1;
            } else if (head + tail < sum) {
                headIndex += 1;
            } else {
                return new int[]{head, tail};
            }
        }
        return new int[]{};
    }

    // 题目三：输入一个正整数s，打印出所有和为s的连续正整数序列（至少含有两个数）。例如，输入15，
    // 由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个序列 [1,2,3,4,5],[4,5,6],[7,8]
    private List<List<Integer>> findContinuousSequence(int sum) {
        if (sum < 3) {
            return null;
        }
        List<List<Integer>> target = new ArrayList<>();
        int head = 1, tail = 2;
        int temp = head + tail;
        while (head < tail) {
            if (temp > sum) {
                temp -= head;
                head += 1; //缩短序列
            } else if (temp < sum) {
                tail += 1; //加长序列
                temp += tail;
            } else {
                List<Integer> list = new ArrayList<>();
                for (int j = head; j <= tail; j++) {
                    list.add(j);
                }
                target.add(list);

                temp -= head;
                head += 1; //此处使用tail += 1的话会降低效率，用head += 1更快地破坏循环条件
            }
        }
        return target;
    }
}
