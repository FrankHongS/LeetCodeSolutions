package BookOffer.P48;

import java.util.Arrays;

/**
 * 最长不含重复字符的子字符串
 * 题目：请从字符串中找出一个最长的不含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中包含a～z的字符。例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串
 * 的是"acfr"，长度为4
 *
 * Created by Frank_Hon on 2022/6/29 下午10:10.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        String str = "abcabcbb";
//        String str = "abcas";
        Solution solution = new Solution();
        String longestStr = solution.longestSubstringWithoutDuplication(str);
        System.out.println(longestStr);
    }

    private String longestSubstringWithoutDuplication(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        int[] positions = new int[26];
        Arrays.fill(positions, -1);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int start = 0;
        String longestStr = "";
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            int position = positions[c - 'a'];//获取当前字符上次出现的位置
            if (position != -1 && position >= start) {//position有初始化且position在start之后，才能当作有效子串
                //有效子串和之前最长子串进行比较
                if (i - start > longestStr.length()) {
                    longestStr = str.substring(start, i);
                }
                //由于索引为position和i的字符一致，继续遍历的时候需要更新start指针
                start = position + 1;
            }
            //更新当前字符的索引
            positions[c - 'a'] = i;
        }
        //由于最后获取到的有效子串在上面的遍历中未进行比较，这里将该子串和之前最长子串比较，更新最长子串
        if (length - start > longestStr.length()) {
            longestStr = str.substring(start, length);
        }
        return longestStr;
    }

}
