package interview.decimalAndHex;

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
        int num = 1023;
        String target1 = solution.transferNumToHexString(num);
        System.out.println(target1);
        int target2 = solution.transferHexStringToNum(target1);
        System.out.println(target2);
    }

    //正整数转化为16进制字符串
    private String transferNumToHexString(int num) {
        List<String> target = new ArrayList<>();
        while (num >= 16) {
            int temp = num % 16;
            String str = intToHexStr(temp);
            target.add(str);
            num = num / 16;
        }
        target.add(intToHexStr(num));

        //线程不安全
        StringBuilder sb = new StringBuilder();
        int length = target.size();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(target.get(i));
        }
        return sb.toString();
    }

    //16进制字符串转化为十进制整数
    private int transferHexStringToNum(String hexStr) {
        if (hexStr == null || hexStr.isEmpty()) {
            return 0;
        }
        char[] hexChars = hexStr.toCharArray();
        int targetNum = 0;
        for (char hexChar : hexChars) {
            targetNum = targetNum * 16 + hexCharToInt(hexChar);
        }
        return targetNum;
    }

    private String intToHexStr(int n) {
        if (n < 10) {
            return String.valueOf(n);
        } else if (n == 10) {
            return "A";
        } else if (n == 11) {
            return "B";
        } else if (n == 12) {
            return "C";
        } else if (n == 13) {
            return "D";
        } else if (n == 14) {
            return "E";
        } else if (n == 15) {
            return "F";
        }
        throw new RuntimeException("Input error");
    }

    private int hexCharToInt(char hexChar) {
        int delta0 = hexChar - '0';
        if (delta0 >= 0 && delta0 <= 9) {
            return delta0;
        }
        int deltaa = hexChar - 'a';
        if (deltaa >= 0 && deltaa <= 5) {
            return deltaa + 10;
        }
        int deltaA = hexChar - 'A';
        if (deltaA >= 0 && deltaA <= 5) {
            return deltaA + 10;
        }
        throw new RuntimeException("Input error");
    }
}
