package BookOffer.P50;

import java.util.Arrays;

/**
 * Created by Frank_Hon on 2021/4/13 11:21 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 题目一：字符串中第一个只出现一次的字符。
 * 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'
 * 题目二：字符流中第一个只出现一次的字符。
 * 请实现一个函数，用来找出字符流中第一个只出现一次的字符。例如，当从字符流
 * 中读出前两个字符"go"时，第一个只出现一次的字符是'g'；当从该字符流中读出
 * 前6个字符"google"时，第一个只出现一次的字符是"l"
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "googleleq";

        System.out.println(solution.firstAppearingOnce(str));
    }

    public char firstAppearingOnce(String str) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException("Parameter str is null or empty");
        }
        int[] temp = new int[256];
        Arrays.fill(temp, -1);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (temp[c] == -1) {
                temp[c] = i;
            } else if (temp[c] >= 0) {
                temp[c] = -2;
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for (int index : temp) {
            if (index < minIndex && index >= 0) {
                minIndex = index;
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            throw new RuntimeException("No Character appearing once...");
        } else {
            return chars[minIndex];
        }
    }

}
