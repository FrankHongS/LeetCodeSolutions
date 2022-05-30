package BookOffer.P56;

import util.Util;

import java.util.Arrays;

/**
 * 题目：数组中数字出现的次数
 * 一个整型数组里除了两个数字之外，其他数字都出现了两次。请找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度为O(1)。
 * Created by Frank_Hon on 2022/5/29 下午12:41.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        Solution solution = new Solution();
        int[] target = solution.findNumsAppearOnce(nums);
        Util.printIntArray(target);
    }

    private int[] findNumsAppearOnce(int[] data) {
        if (data == null || data.length < 2) {
            return null;
        }
        int[] target = new int[2];
        int resultExclusiveOR = 0;
        for (int i : data) {
            resultExclusiveOR ^= i;
        }
        int index = findFirstBitIsOne(resultExclusiveOR);
        for (int j : data) {
            if (isOneOfIndex(j, index)) {
                target[0] ^= j;
            } else {
                target[1] ^= j;
            }
        }
        return target;
    }

    private int findFirstBitIsOne(int num) {
        int index = 1;
        while ((num & 1) == 0 && index < 32) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    private boolean isOneOfIndex(int num, int index) {
        num = num >> (index - 1);
        return (num & 1) != 0;
    }
}
