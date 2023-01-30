package util;

import java.util.List;

public class Util {

    public static void printIntArray(int[] array) {
        int length = array.length;
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i == length - 1)
                System.out.print(array[i] + "]");
            else
                System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        if (list != null) {
            for (int i : list) {
                sum += i;
            }
        }
        return sum;
    }

    public static int min(int... values) {
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            min = Math.min(min, value);
        }
        return min;
    }
}
