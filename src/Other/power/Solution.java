package Other.power;

/**
 * Created by Frank_Hon on 2020-05-17 18:09.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.power(2, 5));
        System.out.println(solution.power(-2, 5));
        System.out.println(solution.power(-2, -5));
        System.out.println(solution.power(2, -5));

        System.out.println(solution.power(2, 0));
        System.out.println(solution.power(-2, 0));
        System.out.println(solution.power(0, 5));
        solution.power(0, -5);
        solution.power(0, 0);
    }

    public double power(double base, int exponent) {
        if (base == 0 && exponent <= 0) {
            System.out.println("Math error: exponent is not positive when base is zero");
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            return powerWithPositiveExponent(base, exponent);
        } else {
            return 1 / powerWithPositiveExponent(base, -exponent);
        }
    }

    private double powerWithPositiveExponent(double base, int exponent) {
        int new_exponent = exponent >> 1;//等同于exponent/2
        if ((exponent & 0x1) == 0) {//通过位与运算判断奇偶
            return powerWithPositiveExponent(base, new_exponent) * powerWithPositiveExponent(base, new_exponent);
        } else {
            if (new_exponent == 0) {
                return base;
            } else {
                return powerWithPositiveExponent(base, new_exponent) * powerWithPositiveExponent(base, new_exponent) * base;
            }
        }
    }
}
