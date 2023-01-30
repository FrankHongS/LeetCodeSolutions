package dynamicprogramming.editDistance;

import util.Util;

/**
 * 题目：最小编辑距离
 * 给定两个字符串word1以及word2，返回将word1转化为word2需要的最少步骤，
 * 在每一步中可以针对字符串word1进行以下操作：
 * - 新增一个字符
 * - 删除一个字符
 * - 替换一个字符
 * <p>
 * 假如word1是"horse"，word2是"ros"，那么需要返回3，也就是说将word1转为
 * word2至少需要三个步骤：
 * 1. 将word1中的第一个字符h替换为字符r：horse -> rorse，此时word1变为rorse，word1与word2前两个字符相等；
 * 2. 将word1中的第三个字符r删掉：rorse -> rose，此时word1变为rose，word1与word2的前三个字符相等；
 * 3. 将word1中的最后一个字符删掉：rose -> ros，此时word1与word2相等。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "hce", word2 = "abz";
        int result1 = solution.editDistance(word1, word2);
        System.out.println(result1);
        int result2 = solution.editDistanceByDp(word1, word2);
        System.out.println(result2);
    }

    private int editDistance(String word1, String word2) {
        return editDistance(word1, word2, 0, 0);
    }

    /**
     * O(3^n)
     *
     * @param i word1当前待比较的字符索引
     * @param j word2当前待比较的字符索引
     */
    private int editDistance(String word1, String word2, int i, int j) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (i == length1) {
            return length2 - j;
        }
        if (j == length2) {
            return length1 - i;
        }

        char char1 = word1.charAt(i);
        char char2 = word2.charAt(j);

        if (char1 == char2) {
            return editDistance(word1, word2, i + 1, j + 1);
        }

        return Util.min(
                // word1进行替换操作
                editDistance(word1, word2, i + 1, j + 1),
                // word1进行删除操作
                editDistance(word1, word2, i + 1, j),
                // word1进行新增操作
                editDistance(word1, word2, i, j + 1)
        ) + 1;
    }

    /**
     * O(mn)
     */
    private int editDistanceByDp(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        char char1, char2;
        for (int i = length1; i >= 0; i--) {
            for (int j = length2; j >= 0; j--) {
                if (i == length1) {
                    dp[i][j] = length2 - j;
                    continue;
                }
                if (j == length2) {
                    dp[i][j] = length1 - i;
                    continue;
                }
                char1 = word1.charAt(i);
                char2 = word2.charAt(j);
                if (char1 == char2) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Util.min(
                            // word1进行替换操作
                            dp[i + 1][j + 1],
                            // word1进行删除操作
                            dp[i][j + 1],
                            // word1进行新增操作
                            dp[i + 1][j]
                    ) + 1;
                }
            }
        }
        return dp[0][0];
    }
}
