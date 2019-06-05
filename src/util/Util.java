package util;

public class Util {

    public static void printIntArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1)
                System.out.print(array[i]);
            else
                System.out.print(array[i] + ",");
        }
        System.out.println();
    }

}
