package hw.hj107;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 求解立方根
 * 计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 * 数据范围：｜val｜<=20
 * 输入描述：
 * 待求解参数为double类型（一个实数）
 * 输出描述：
 * 输出参数的立方根，保留一位小数
 * <p>
 * 解题思路：二分查找
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        double a = 2.7;
        double target = solution.cube(a);
        System.out.println(new BigDecimal(target).setScale(1, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(Math.cbrt(a)).setScale(1, RoundingMode.HALF_UP));
    }

    private double cube(double input) {
        double absInput = Math.abs(input);
        double result;
        if (absInput == 1) {
            result = input;
        } else if (absInput > 1) {
            if (input > 0) {
                result = binarySearchCube(input, 1, input);
            } else {
                result = -binarySearchCube(-input, 1, -input);
            }
        } else {
            if (input > 0) {
                result = binarySearchCube(input, input, 1);
            } else {
                result = -binarySearchCube(-input, -input, 1);
            }
        }
        return result;
    }

    private double binarySearchCube(double target, double start, double end) {
        double mid;
        double temp;
        double delta;
        while (start <= end) {
            mid = (start + end) / 2;
            temp = mid * mid * mid;
            // 此处差值是通过(x-y)^3<0.01^3求得，x为真实值，y为近似值
            delta = 0.000001 + 0.03 * mid * (mid + 0.01);
            if (target - temp < delta && target - temp > 0) {
                return mid;
            } else if (target - temp < 0) {
                end = mid;
            } else {
                start = mid;
            }
        }
        throw new RuntimeException("Value not found...");
    }
}
