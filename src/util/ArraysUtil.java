package util;

/**
 * Created by Frank_Hon on 2019-06-09 14:10.
 * E-mail: frank_hon@foxmail.com
 */
public class ArraysUtil {

    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
