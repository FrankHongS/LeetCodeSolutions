package Sort.QuickSort;

import util.ArraysUtil;

/**
 * Created by Frank_Hon on 2018-03-08 (maybe, copied from the previous).
 * E-mail: frank_hon@foxmail.com
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] array = {1, 5, 3, 6, 9, 8};
        ArraysUtil.print(array);
        solution.quickSort(array, 0, array.length - 1);
        ArraysUtil.print(array);
    }

    private void quickSort(int[] array, int start, int end) {
        int index = partition(array, start, end);
        if (index > start + 1) {
            quickSort(array, start, index - 1);
        }
        if (index < end - 1) {
            quickSort(array, index + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        if (end < start || array == null) {
            throw new RuntimeException("Invalid");
        }
        int length = end - start + 1;
        if (length > array.length) {
            throw new RuntimeException("Invalid");
        }
        int first = array[start];
        int tempStart = start, tempEnd = end;
        while (tempStart < tempEnd) {
            for (int i = tempStart + 1; i <= end; i++) {
                if (array[i] > first) {
                    tempStart = i;
                    break;
                }
            }
            if (tempStart == start) {
                ArraysUtil.swapElements(array, start, end);
                return end;
            }
            for (int j = tempEnd; j > start; j--) {
                if (array[j] < first) {
                    tempEnd = j;
                    break;
                }
            }
            if (tempEnd == end) {
                return start;
            }
            if (tempStart < tempEnd) {
                ArraysUtil.swapElements(array, tempStart, tempEnd);
            }
        }
        ArraysUtil.swapElements(array, start, tempEnd);
        return tempEnd;
    }

    private void quickSort2(int[] array, int start, int end) {
        if (end < start) {
            return;
        }

        int first = array[start];
        int tempStart = start, tempEnd = end + 1;

        do {
            for (int i = tempStart + 1; i < end + 1; i++) {
                if (array[i] > first) {
                    tempStart = i;
                    break;
                }
            }

            for (int j = tempEnd - 1; j > start; j--) {
                if (array[j] < first) {
                    tempEnd = j;
                    break;
                }
            }

            if (tempStart == start) {
                break;
            }

            if (tempEnd == end + 1) {
                break;
            }

            if (tempStart < tempEnd) {
                ArraysUtil.swapElements(array, tempStart, tempEnd);
            }
        } while (tempStart < tempEnd);

        if (tempStart == start) {
            ArraysUtil.swapElements(array, start, end);
            quickSort(array, start, end - 1);
            return;
        }

        if (tempEnd == end + 1) {
            quickSort(array, start + 1, end);
            return;
        }

        ArraysUtil.swapElements(array, start, tempEnd);
        quickSort(array, start, tempEnd - 1);
        quickSort(array, tempEnd + 1, end);
    }
}
