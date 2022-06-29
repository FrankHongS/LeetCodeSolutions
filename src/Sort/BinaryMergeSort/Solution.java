package Sort.BinaryMergeSort;

import util.ArraysUtil;

/**
 * Created by Frank_Hon on 2018-03-08 (maybe, copied from the previous).
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5, 8, 7};
        Solution solution = new Solution();
        ArraysUtil.print(nums);
        solution.sort(nums);
        ArraysUtil.print(nums);
    }

    public void sort(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            sort(nums, low, mid);// sort left
            sort(nums, mid + 1, high);// sort right

            merge(nums, low, mid, high);// merge left and right
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {// 当不知道循环次数用while循环，知道的话用for方便一些
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= high) {
            temp[k++] = nums[j++];
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, nums, low, temp.length);
    }

}
