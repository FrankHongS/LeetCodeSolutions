package util;

/**
 * Created by Frank_Hon on 2019-06-09 14:10.
 * E-mail: frank_hon@foxmail.com
 */
public class ArraysUtil {

    public static void swapElements(int[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void swapElements(char[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <E> void swapElements(E[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void print(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
