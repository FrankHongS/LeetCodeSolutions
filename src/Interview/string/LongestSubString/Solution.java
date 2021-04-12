package Interview.string.LongestSubString;

/**
 * Created by Frank_Hon on 2020/12/17 3:53 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 题目：给定一个字符串，请你找出其中不含有重复字符的 最长连续子串
 * 例如输入`abcabcbb`，输出`abc`
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String str = "abcabcbb";
        String str = "abcas";
        String longestStr = solution.findLongestSequence(str);
        System.out.println(longestStr);
    }

    private String findLongestSequence(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        int start = 0, end = 1;
        char[] charArray = str.toCharArray();
        String longestStr = str.substring(start, end);
        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];
            String curStr = str.substring(start, end);
            int index = curStr.indexOf(c);
            if (index != -1) {
                start = i - (curStr.length() - 1 - index);
                end = i + 1;
                if (curStr.length() > longestStr.length()) {
                    longestStr = curStr;
                }
            } else {
                end = i + 1;
            }
            if (end == charArray.length) {
                curStr = str.substring(start, end);
                if (curStr.length() > longestStr.length()) {
                    longestStr = curStr;
                }
            }
        }
        return longestStr;
    }
}
