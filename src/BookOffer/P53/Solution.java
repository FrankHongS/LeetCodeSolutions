package BookOffer.P53;

/**
 * Created by Frank_Hon on 2020/12/13 11:35 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 题目1：数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，
 * 由于3在这个数组中出现了4次，则输出4。
 * <p>
 * 题目2：0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在0～n-1之内。
 * 在0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 * <p>
 * 问题3：数组中数值和下标相等的元素
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的，请编写实现一个函数，找出数组中任意的一个
 * 数值等于其下标的元素。例如，在数组{-3,-1,1,3,5}中，数字3和它的下标相等。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 问题1
//        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
//        int target = 3;
//        int count = solution.findNumberCount(array, target);
//        System.out.println(count);
        // 问题2
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 9};
//        int missingNum = solution.getMissingNumber(array);
//        System.out.println(missingNum);
        // 问题3
        int[] array = {-3, -1, 1, 3, 5};
        int target = solution.getNumberSameAsIndex(array);
        System.out.println(target);
    }

    // 题目1
    private int findNumberCount(int[] array, int target) {
        if (array == null) {
            return 0;
        }
        int first = getFirstK(array, target);
        int last = getLastK(array, target);
        if (first == -1 || last == -1) {
            return 0;
        } else {
            return last - first + 1;
        }
    }

    private int getFirstK(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > target) {
                end = middle - 1;
            } else if (array[middle] < target) {
                start = middle + 1;
            } else {
                if (middle - 1 >= 0) {
                    if (array[middle - 1] < target) {
                        return middle;
                    } else {
                        end = middle - 1;
                    }
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }

    private int getLastK(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > target) {
                end = middle - 1;
            } else if (array[middle] < target) {
                start = middle + 1;
            } else {
                if (middle + 1 <= array.length - 1) {
                    if (array[middle + 1] > target) {
                        return middle;
                    } else {
                        start = middle + 1;
                    }
                } else {
                    return middle;
                }
            }
        }
        return -1;
    }

    // 题目2
    private int getMissingNumber(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > middle) {
                if (middle - 1 >= 0) {
                    if (array[middle] - array[middle - 1] > 1) {
                        return array[middle] - 1;
                    } else {
                        end = middle - 1;
                    }
                } else {
                    return array[middle] - 1;
                }
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    // 题目3
    private int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] > middle) {
                end = end - 1;
            } else if (array[middle] < middle) {
                start = start + 1;
            } else {
                return array[middle];
            }
        }
        return -1;
    }
}
