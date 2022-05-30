package BookOffer.P33;

import java.util.Arrays;
import java.util.List;

/**
 * 题目：二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都
 * 互不相同。例如，输入数组{5,7,6,9,11,10,8},则返回true，因为这个
 * 整数序列是下面二叉搜索树的后序遍历结果；如果输入的数组是{7,4,6,5},
 * 则由于没有哪棵二叉搜索树的后序遍历结果是这个序列，因此返回false
 * <p>
 *        8
 *    6        10
 * 5   7    9    11
 * <p>
 * Created by Frank_Hon on 2022/5/23 下午4:33.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//     Integer[] temp = {5, 7, 6, 9, 11, 10, 8};
        Integer[] temp = {7, 4, 6, 5};
        boolean result = solution.verifySequenceOfBST(Arrays.asList(temp));
        System.out.println(result);
    }

    /**
     * 二叉搜索树：左子树小于根节点，根节点小于右子树
     */
    private boolean verifySequenceOfBST(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        int size = list.size();
        if (size == 1) {
            return true;
        }
        int root = list.get(size - 1);
        int from = -1;
        for (int j = 0; j < size - 1; j++) {
            int element = list.get(j);
            if (element > root) {
                from = j;
                break;
            }
        }
        if (from != -1 && from < size - 2) {
            for (int k = from + 1; k < size - 1; k++) {
                int element = list.get(k);
                if (element < root) {
                    return false;
                }
            }
        }
        boolean left = from == -1 || verifySequenceOfBST(list.subList(0, from));
        boolean right = verifySequenceOfBST(list.subList(from, size - 1));
        return left && right;
    }
}
