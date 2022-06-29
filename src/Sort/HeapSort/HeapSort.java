package Sort.HeapSort;

import util.ArraysUtil;

/**
 * Created by Frank_Hon on 2018-03-08 (maybe, copied from the previous).
 * E-mail: frank_hon@foxmail.com
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array={5,4,1,8,9};
        HeapSort heapSort=new HeapSort();
        heapSort.heapSort(array);
        for (int i:array) {
            System.out.print(i+",");
        }
    }

    public void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        buildMaxHeap(array);

        for (int i = array.length - 1; i >= 1; i--) {
            ArraysUtil.swapElements(array, 0, i);
            maxHeap(array, i, 0);
        }
    }

    private void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        for (int i = half - 1; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;

        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            ArraysUtil.swapElements(array, index, largest);
            maxHeap(array, heapSize, largest);
        }

    }

}
