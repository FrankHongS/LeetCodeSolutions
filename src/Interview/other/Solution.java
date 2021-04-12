package Interview.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank_Hon on 2020/12/8 3:52 下午.
 * E-mail: frank_hon@foxmail.com
 *
 * 题目：正整数转化为16进制字符串
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 15;
        String target = solution.transferNumToString(num);
        System.out.println(target);
    }

    private String transferNumToString(int num) {
        List<String> target = new ArrayList<>();
        while (num >= 16) {
            int temp = num % 16;
            String str = map(temp);
            target.add(str);
            num = num / 16;
        }
        target.add(map(num));

        StringBuilder sb = new StringBuilder();
        int length = target.size();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(target.get(i));
        }
        return sb.toString();
    }

    private String map(int n) {
        if (n < 10) {
            return String.valueOf(n);
        } else if (n == 10) {
            return "A";
        } else if (n == 11) {
            return "B";
        } else if (n == 12) {
            return "C";
        } else if (n == 13) {
            return "Interview.other.D";
        } else if (n == 14) {
            return "E";
        } else if (n == 15) {
            return "F";
        }

        throw new RuntimeException("Input error");
    }
}
