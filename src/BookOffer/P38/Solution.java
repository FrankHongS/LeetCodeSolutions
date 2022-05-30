package BookOffer.P38;

import util.ArraysUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符所有排列。例如，
 * 输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba
 * <p>
 * Created by Frank_Hon on 2021/11/27 5:56 下午.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(1_000);
        Solution solution = new Solution();
        List<String> targetList = new ArrayList<>();
        String str = "abca";
        solution.permutation(str, targetList);
        System.out.println(targetList);
        System.out.println(targetList.size());
    }

    private void permutation(String str, List<String> targetList) {
        if (str == null || str.isEmpty()) {
            return;
        }
        List<String> target = new ArrayList<>();
//        doPermutation(str.length(), str, target, targetList);
//        target.clear();
        doPermutation(str.toCharArray(), 0, targetList);
    }

    private void doPermutation(int size, String str, List<String> target, List<String> targetList) {
        if (str == null || str.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String s : target) {
                sb.append(s);
            }
            String targetStr = sb.toString();
            if (!targetList.contains(targetStr)) {
                targetList.add(targetStr);
            }
            return;
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (char c : chars) {
            String first = String.valueOf(c);
            if (size > length) {
                target = target.subList(0, size - length);
            } else {
                target.clear();
            }
            target.add(first);
            String left = str.replaceFirst(first, "");
            doPermutation(size, left, target, targetList);
        }
    }

    /**
     * 优雅写法
     */
    private void doPermutation(char[] chars, int startIndex, List<String> targetList) {
        if (startIndex >= chars.length - 1) {
            String str = String.valueOf(chars);
            if (!targetList.contains(str)) {
                targetList.add(str);
            }
            return;
        }
        for (int i = startIndex; i <= chars.length - 1; i++) {
            ArraysUtil.exchangeElements(chars, startIndex, i);
            doPermutation(chars, startIndex + 1, targetList);
            ArraysUtil.exchangeElements(chars, startIndex, i);
        }
    }
}
