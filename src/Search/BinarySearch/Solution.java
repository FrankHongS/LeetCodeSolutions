package Search.BinarySearch;

/**
 * Created by Frank_Hon on 2020/6/16 11:42 上午.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 8, 9, 12, 13, 19};
        int index = solution.binarySearch(nums, 9);
        System.out.println(index);
    }

    public int binarySearch(int[] array, int target) {
        if (array == null) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
