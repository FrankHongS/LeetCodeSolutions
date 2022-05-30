package BookOffer.P15;

/**
 * 题目：二进制中的1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如，把9表示成二进制1001，有2位是1。因此，如果输入9，则
 * 该函数输出2。
 *
 * Created by Frank_Hon on 2022/5/27 下午5:03.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        int n = -8;//负数的二进制表示为补码表示法（在原码表示法的基础上取反，再加1），而非原码表示法
//        int n = 9;
        Solution solution = new Solution();
        int count = solution.numberOfOne3(n);
        System.out.println(count);
    }

    private int numberOfOne1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
//            n = n >> 1;//负数可能引起死循环
            n = n >>> 1;//无符号右移，负数不会引起死循环
        }
        return count;
    }

    private int numberOfOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 二进制整数减去1，只会影响该数最低位上的1以及其后的位数；再将减1得到的结果与原数进行按位与运算。
     * 上面两步的作用是将输入整数最低位的1变为0
     */
    private int numberOfOne3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
