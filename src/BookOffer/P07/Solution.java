package BookOffer.P07;

import util.TreeUtil;
import util.entity.TreeNode;

import java.util.Arrays;

/**
 * Created by Frank_Hon on 2020/12/6 4:49 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都`不含重复的数字`。例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6},则可以重建二叉树并输出它的根节点
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = solution.constructTree(preOrder, inOrder);
        TreeUtil.printTreePostOrder(root);
        System.out.println();
        TreeUtil.printTreeInOrder(root);
    }

    // 解题思路：从前序遍历序列的第一个元素得到根结点，将中序遍历序列从根结点分成两部分。
    // 前半部分为根结点左子树的中序遍历，后半部分为根结点右子树的中序遍历；
    // 然后从前序遍历序列中得到根结点左子树的前序遍历以及根结点右子树的前序遍历。
    // 这样的话，可以对根结点左子树和根结点右子树重复`重建二叉树`操作（递归），最后可以返回出重建好的一棵完整的二叉树
    private TreeNode constructTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length < 1 || inOrder == null) {
            return null;
        }
        int rootVal = preOrder[0];
        TreeNode root = new TreeNode(rootVal);
        int[] leftInOrder = null, rightInOrder = null;
        for (int i = 0; i < inOrder.length; i++) {
            if (rootVal == inOrder[i]) {
                leftInOrder = Arrays.copyOfRange(inOrder, 0, i);
                rightInOrder = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
                break;
            }
        }
        if (leftInOrder != null && rightInOrder != null) {
            int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1,
                    leftInOrder.length + 1);
            root.left = constructTree(leftPreOrder, leftInOrder);

            if (preOrder.length > leftInOrder.length + 1) {
                int[] rightPreOrder = Arrays.copyOfRange(preOrder, leftInOrder.length + 1,
                        rightInOrder.length + leftInOrder.length + 1);
                root.right = constructTree(rightPreOrder, rightInOrder);
            }
        } else {
            throw new RuntimeException("PreOrder and InOrder not match");
        }
        return root;
    }
}
