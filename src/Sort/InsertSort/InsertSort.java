package Sort.InsertSort;

/**
 * Created by Frank_Hon on 2018-03-08 (maybe, copied from the previous).
 * E-mail: frank_hon@foxmail.com
 */
public class InsertSort {

    public void insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > currentValue) {
                    array[j + 1] = array[j];
                    position--;
                } else {
                    break;
                }
            }

            array[position] = currentValue;
        }
    }

}
