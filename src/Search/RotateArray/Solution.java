package Search.RotateArray;

/**
 * Created by Frank_Hon on 2019-06-11 23:49.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;

        Solution solution = new Solution();
        int index = solution.search(nums, target);

        System.out.println(index);

    }

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int length = nums.length;

        int start = 0;
        int end = length - 1;

        while (start <= end) {

            int midIndex = (start + end) / 2;

            int mid = nums[midIndex];

            if (mid == target) {
                return midIndex;
            }

            if (start == end) {
                return -1;
            }

            if (mid >= nums[start] && mid >= nums[end]) {
                if (target < mid) {
                    if (target == nums[start]) {
                        return start;
                    } else if (target > nums[start]) {
                        start = start + 1;
                        end = midIndex - 1;
                    } else {
                        start = midIndex + 1;
                    }
                } else {
                    start = midIndex + 1;
                }
            } else if (mid <= nums[start] && mid <= nums[end]) {
                if (target < mid) {
                    end = midIndex - 1;
                } else {
                    if (target == nums[end]) {
                        return end;
                    } else if (target > nums[end]) {
                        end = midIndex - 1;
                    } else {
                        start = midIndex + 1;
                        end = end - 1;
                    }
                }
            } else if (mid >= nums[start] && mid <= nums[end]) {
                if (mid < target) {
                    start = midIndex + 1;
                } else {
                    end = midIndex - 1;
                }
            }
        }

        return -1;
    }

}
