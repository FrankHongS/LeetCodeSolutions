package Sort.QuickSort;

import util.ArraysUtil;

/**
 * Created by Frank_Hon on 2018-03-08 (maybe, copied from the previous).
 * E-mail: frank_hon@foxmail.com
 */
public class QuickSort {

    public void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int s, int e) {
        if (e < s) {
            return;
        }

        int a = array[s];
        int c = s, d = e + 1;

        do {
            for (int i = c + 1; i < e + 1; i++) {
                if (array[i] > a) {
                    c = i;
                    break;
                }
            }

            for (int j = d - 1; j > s; j--) {
                if (array[j] < a) {
                    d = j;
                    break;
                }
            }

            if (c == s) {
                break;
            }

            if (d == e + 1) {
                break;
            }

            if (c < d) {
                ArraysUtil.exchangeElements(array, c, d);
            }
        } while (c < d);

        if (c == s) {
            ArraysUtil.exchangeElements(array, s, e);
            quickSort(array, s, e - 1);
            return;
        }

        if (d == e + 1) {
            quickSort(array, s + 1, e);
            return;
        }

        ArraysUtil.exchangeElements(array, s, d);
        quickSort(array, s, d - 1);
        quickSort(array, d + 1, e);
    }

}
