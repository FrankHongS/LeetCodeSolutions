package dynamicprogramming.longestSuperString;

/**
 * 最短公共超序列（shortest common super sequence）
 * 如果一个字符串s在删除某些字符串后形成t，那么我们说s是t的超序列，现在给定两个字符串
 * str1和str2，返回str1与str2的最短公共超序列，如果有多个的话返回任意一个即可。
 * 假如str1为"abac"，str2为cab，那么这两个字符串的最短公共超序列是"cabac"；而
 * 如果str1为"bc"，str2为"cab"，那么最短公共超序列是"cabc"或者"bcab"
 * <p>
 * 题目链接：https://mp.weixin.qq.com/s/3LzuUduVYouQ1jLWD2LAVA
 * <p>
 * Created by Frank_Hon on 2022/12/29 7:58 PM.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String str1 = "bc", str2 = "cab";
        String str1 = "abac", str2 = "cab";
        System.out.println(solution.scs(str1, str2));
    }

    private int scs(String str1, String str2) {
        return scs(str1, str2, 0, 0);
    }

    private int scs(String str1, String str2, int i, int j) {
        // str1已经为空，超序列只需要包含str2剩下的部分即可
        if (i == str1.length()) {
            return str2.length() - j;
        }
        // str2已经为空，超序列只需要包含str1剩下的部分即可
        if (j == str2.length()) {
            return str1.length() - i;
        }
        // 如果两个字符串的首字符相同，当前问题的解等于字问题的解加1
        if (str1.charAt(i) == str2.charAt(j)) {
            return scs(str1, str2, i + 1, j + 1) + 1;
        }
        // 否则当前问题的解等于两个子问题解较小的那个加1
        return Math.min(
                scs(str1, str2, i + 1, j),
                scs(str1, str2, i, j + 1)
        ) + 1;
    }

}
