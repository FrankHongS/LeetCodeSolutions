package interview.findLostNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 知乎
 * 题目：找出数组中缺失的数字
 *
 * Created by Frank_Hon on 2022/4/20 上午11:45.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Integer a = 20;
        Integer b = 20;
        System.out.println(a == b);
        Solution solution = new Solution();
        int[] array = {1, 1, 2, 2, 4, 4, 4};
        System.out.println(solution.findLostNum3(array, array.length));
    }

    /**
     * 方法1，利用数组下标，修改原数组，
     * 遍历两趟：第一趟，未出现的数字，对应下标赋值-1；
     * 第二趟，找出新数组中的-1，将对应下标存储到target中
     */
    private List<Integer> findLostNum1(int[] array, int n) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<Integer> target = new ArrayList<>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int item = array[i];
            if (item != i) {
                array[item] = item;
                array[i] = -1;
            }
        }
        for (int j = 0; j < length; j++) {
            int item = array[j];
            if (item == -1) {
                target.add(j);
            }
        }
        return target;
    }

    private List<Integer> findLostNum2(int[] array, int n) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<Integer> target = new ArrayList<>();
        int[] temp = new int[n];
        Arrays.fill(temp, -1);
        for (int item : array) {
            temp[item] = 0;
        }
        for (int i = 0; i < n; i++) {
            int item = temp[i];
            if (item == -1) {
                target.add(i);
            }
        }
        return target;
    }

    /**
     * 可以找到其中一个丢失的数字
     */
    private int findLostNum3(int[] array, int n) {
        int start = 1;
        int end = n - 1;
        while (end >= start) {
            int middle = (start + end) >> 1;
            int count = countRange(array, start, middle);
            if (start == end) {
                if (count < 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > middle - start + 1) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return -1;
    }

    private int countRange(int[] array, int start, int end) {
        int count = 0;
        for (int item : array) {
            if (item >= start && item <= end) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> findLostNum(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int item : array) {
            if (list.contains(item)) {
                list.remove(new Integer(item));
            }
        }
        return list;
    }
}
