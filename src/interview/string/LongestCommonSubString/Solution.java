package interview.string.LongestCommonSubString;

/**
 * Created by Frank_Hon on 2022/10/17 7:33 PM.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 两个字符串的最长公共子串 百度
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "abcdef";
        String str2 = "dabc";
        System.out.println(solution.maxSubString(str1, str2));
    }

    private String maxSubString(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }
        int length1 = str1.length();
        int length2 = str2.length();
        String temp;
        String other;
        if (length1 > length2) {
            other = str1;
            temp = str2;
        } else {
            temp = str1;
            other = str2;
        }
        int length = temp.length();
        String maxSubStr = "";
        for (int i = 0; i < length; i++) {
            if (length - i <= maxSubStr.length()) {
                break;
            }
            for (int j = i + 1; j <= length; j++) {
                String subStr = temp.substring(i, j);
                if (!other.contains(subStr)) {
                    break;
                } else {
                    if (subStr.length() > maxSubStr.length()) {
                        maxSubStr = subStr;
                    }
                }
            }
        }
        return maxSubStr;
    }
}
