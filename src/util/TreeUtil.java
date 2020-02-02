package util;

import util.entity.TreeNode;

/**
 * Created by Frank_Hon on 2018-03-08 (maybe, copied from the previous).
 * E-mail: frank_hon@foxmail.com
 */
public class TreeUtil {

    /**
     * All binary trees can transfer into complete binary Tree.
     * If not, set the empty node null
     *
     * @param data Tree's value array
     * @return root node
     */
    public static TreeNode buildCompleteBinaryTree(Integer[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(data[0]);
        build(root, data, 0);

        return root;
    }

    private static void build(TreeNode tree, Integer[] array, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < array.length && array[left] != null) {
            tree.left = new TreeNode(array[left]);
            build(tree.left, array, left);
        }

        if (right < array.length && array[right] != null) {
            tree.right = new TreeNode(array[right]);
            build(tree.right, array, right);
        }
    }

    public static void printTreeInOrder(TreeNode target) {
        if (target != null) {
            printTreeInOrder(target.left);
            System.out.print(target.val + ",");
            printTreeInOrder(target.right);
        }
    }

    public static void printTreePreOrder(TreeNode target) {
        if (target != null) {
            System.out.print(target.val + ",");
            printTreePreOrder(target.left);
            printTreePreOrder(target.right);
        }
    }

    public static void printTreePostOrder(TreeNode target) {
        if (target != null) {
            printTreePostOrder(target.left);
            printTreePostOrder(target.right);
            System.out.print(target.val + ",");
        }
    }

}
