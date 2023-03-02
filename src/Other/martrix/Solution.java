package Other.martrix;

/**
 * Created by Frank_Hon on 2019-08-28 09:33.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] array = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
//        int[][] array = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        int[][] array = {
                {1},
                {2},
                {3},
                {4}
        };

        Solution solution = new Solution();
        solution.clockPrint(array);
    }

    public void clockPrint(int[][] array) {

        int n = array.length; // height
        int m = array[0].length; // width

        int count = Math.min((n + 1) / 2, (m + 1) / 2);

        for (int i = 0; i < count; i++) {

            int xNums = m - 2 * i;
            int yNums = n - 2 * i - 2;

            // 竖一行
            if (xNums == 1) {
                for (int j = 0; j < yNums + 2; j++) {
                    System.out.print(array[i + j][i] + ",");
                }
                break;
            }

            // 横一行
            if (yNums == -1) {
                for (int j = 0; j < xNums; j++) {
                    System.out.print(array[i][i + j] + ",");
                }
                break;
            }

            //横
            for (int j = 0; j < xNums; j++) {
                System.out.print(array[i][i + j] + ",");
            }

            //竖
            for (int j = 0; j < yNums; j++) {
                System.out.print(array[i + j + 1][m - 1 - i] + ",");
            }

            //横
            for (int j = 0; j < xNums; j++) {
                System.out.print(array[n - 1 - i][m - 1 - i - j] + ",");
            }

            //竖
            for (int j = 0; j < yNums; j++) {
                System.out.print(array[n - 1 - i - j - 1][i] + ",");
            }

            System.out.println();
        }
    }

}
