package Others.topK;

import Util.ArraysUtil;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = 1 + i;
        }

        ArraysUtil.printArray(solution.topK(array, 5));
    }

    private int[] topK(int[] array, int k) {
        int[] target = new int[k];

//        for (int i = 0; i < target.length; i++) {
//            target[i] = Integer.MIN_VALUE;
//        }

        for (int value : array) {
            if (value > target[0]) {
                target[0] = value;
                buildMinHeap(target, 0);
            }
        }

        return target;
    }

    private void buildMinHeap(int[] array, int index) {
        int temp = index;
        int value = array[temp];

        int left = 2 * temp + 1;
        int right = 2 * temp + 2;

        if (left < array.length && value > array[left]) {
            temp = left;
            value = array[left];
        }

        if (right < array.length && value > array[right]) {
            temp = right;
        }

        if (temp != index) {
            ArraysUtil.exchangeElements(array, index, temp);
            buildMinHeap(array, temp);
        }

    }

}
