package Util;

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

}
