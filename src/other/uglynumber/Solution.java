package other.uglynumber;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findUglyNumber(1500));
    }

    public int findUglyNumber(int index) {
        int count = 1;
        int target = 1;
        while (count != index + 1) {
            int mode = 0;
            int result = target;

            while (mode == 0) {
                mode = result % 2;
                if (mode == 0) {
                    result /= 2;
                }
            }
            if (result == 1) {
                System.out.print(target + " ,");
                count++;
                if (count != index + 1) {
                    target++;
                }
                continue;
            }

            mode = 0;
            while (mode == 0) {
                mode = result % 3;
                if (mode == 0) {
                    result /= 3;
                }
            }
            if (result == 1) {
                System.out.print(target + " ,");
                count++;
                if (count != index + 1) {
                    target++;
                }
                continue;
            }

            mode = 0;
            while (mode == 0) {
                mode = result % 5;
                if (mode == 0) {
                    result /= 5;
                }
            }
            if (result == 1) {
                System.out.print(target + " ,");
                count++;
                if (count != index + 1) {
                    target++;
                }
                continue;
            }

            target++;
        }

        System.out.println();
        return target;
    }

    //859963392 空间换时间，很快
    public int findUglyNumber02(int index) {
        int next = 1;
        int target = 1;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while (next != index) {
            while (uglyNumbers[index2] * 2 <= uglyNumbers[next - 1])
                index2++;
            while (uglyNumbers[index3] * 3 <= uglyNumbers[next - 1])
                index3++;
            while (uglyNumbers[index5] * 5 <= uglyNumbers[next - 1])
                index5++;

            uglyNumbers[next] = min(
                    uglyNumbers[index2] * 2,
                    uglyNumbers[index3] * 3,
                    uglyNumbers[index5] * 5
            );
            next++;
        }

        return uglyNumbers[index - 1];
    }

    private int min(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }

}
