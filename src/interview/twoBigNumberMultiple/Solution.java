package interview.twoBigNumberMultiple;

/**
 * Created by Frank_Hon on 2022/8/22 12:25 AM.
 * E-mail: frank_hon@foxmail.com
 *
 * 快手面试题，两个大数相乘
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "45674578912", num2 = "1231245789";
        String result = solution.multiple(num1, num2);
        System.out.println(result);
        System.out.println(Long.MAX_VALUE);
    }

    private String multiple(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        char[] resultChars = new char[length1 + length2];
        for (int i = length2 - 1; i >= 0; i--) {
            char char2 = chars2[i];
            int int2 = char2int(char2);
            for (int j = length1 - 1; j >= 0; j--) {
                char char1 = chars1[j];
                int int1 = char2int(char1);
                add(resultChars, i + j + 1, int2 * int1);
            }
        }
        return String.valueOf(resultChars).trim();
    }

    private void add(char[] chars, int index, int value) {
        if (chars == null || index < 0 || index > chars.length - 1) {
            return;
        }
        char oldChar = chars[index];
        if (oldChar == '\0') {
            oldChar = '0';
        }
        int origin = char2int(oldChar);
        int newValue = origin + value;
        int mod = newValue % 10; // 余数
        int carry = newValue / 10; // 进位
        char newChar = int2char(mod);
        chars[index] = newChar;
        if (carry != 0) {
            add(chars, index - 1, carry);
        }
    }

    private int char2int(char c) {
        return c - '0';
    }

    private char int2char(int i) {
        return (char) (i + '0');
    }
}
