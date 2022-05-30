package BookOffer.P28;

import util.TreeUtil;
import util.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一致，那么它是对称的。
 * 例如：
 *          8
 *        /   \
 *       6     6
 *      / \   / \
 *     5   7 7   5
 * Created by Frank_Hon on 2022/2/16 上午12:07.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        TreeNode root = TreeUtil.buildCompleteBinaryTree(8, 6, 6, 5, 7, 7, 5);
        TreeNode root = TreeUtil.buildCompleteBinaryTree(7, 7, 7, 7, 7, 7, null);
        System.out.println(solution.isSymmetrical(root));
    }

    private boolean isSymmetrical(TreeNode root) {
        List<Integer> preOrder = traversalTreePreOrder(root);
        System.out.println("preOrder=" + preOrder);
        List<Integer> preOrderSymmetrically = traversalTreePreOrderSymmetrically(root);
        System.out.println("preOrderSymmetrically=" + preOrderSymmetrically);

        return preOrder != null && preOrder.equals(preOrderSymmetrically);
    }

    private List<Integer> traversalTreePreOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> target = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            root = treeNodes.pop();
            if (root != null) {
                target.add(root.value);
            } else {
                target.add(null);
                continue;
            }
            treeNodes.push(root.right);
            treeNodes.push(root.left);
        }
        return target;
    }

    private List<Integer> traversalTreePreOrderSymmetrically(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> target = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            root = treeNodes.pop();
            if (root != null) {
                target.add(root.value);
            } else {
                target.add(null);
                continue;
            }

            treeNodes.push(root.left);
            treeNodes.push(root.right);
        }
        return target;
    }
}
