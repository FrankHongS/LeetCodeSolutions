package Interview.recursive;

import util.TreeUtil;
import util.entity.TreeNode;

import java.util.LinkedList;

/**
 * Created by Frank_Hon on 2020/6/11 7:13 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 使用非递归的方式实现Tree的中序、前序、后序遍历
 * 递归方法利用了函数栈来保存信息，如果用自己申请的数据结构代替函数栈，也能实现相同功能
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildCompleteBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Solution solution = new Solution();
//        solution.traversalTreeInOrderByRecursive(root);
//        solution.traversalTreeInOrder(root);

//        solution.traversalTreePreOrderByRecursive(root);
//        solution.traversalTreePreOrder(root);

//        solution.traversalTreePostOrderByRecursive(root);
        solution.traversalTreePostOrder(root);
    }

    public void traversalTreeInOrderByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalTreeInOrderByRecursive(root.left);
        System.out.println(root.val);
        traversalTreeInOrderByRecursive(root.right);
    }

    public void traversalTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        // 常规思路，模仿递归的逻辑
//        while (root != null) {
//            treeNodes.add(root);
//            root = root.left;
//            while (root == null && !treeNodes.isEmpty()) {
//                TreeNode node = treeNodes.removeLast();
//                System.out.println(node.val);
//                root = node.right;
//            }
//        }
        // 很巧妙，很难想
        while (root != null || !treeNodes.isEmpty()) {
            if (root != null) {
                treeNodes.add(root);
                root = root.left;
            } else {
                TreeNode node = treeNodes.removeLast();
                System.out.println(node.val);
                root = node.right;
            }
        }
    }

    public void traversalTreePreOrderByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        traversalTreePreOrderByRecursive(root.left);
        traversalTreePreOrderByRecursive(root.right);
    }

    public void traversalTreePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
//        while (root != null) {
//            treeNodes.add(root);
//            System.out.println(root.val);
//            root = root.left;
//            while (root == null && !treeNodes.isEmpty()) {
//                TreeNode node = treeNodes.removeLast();
//                root = node.right;
//            }
//        }
        while (root != null || !treeNodes.isEmpty()) {
            if (root != null) {
                treeNodes.add(root);
                System.out.println(root.val);
                root = root.left;
            } else {
                TreeNode node = treeNodes.removeLast();
                root = node.right;
            }
        }
    }

    public void traversalTreePostOrderByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalTreePostOrderByRecursive(root.left);
        traversalTreePostOrderByRecursive(root.right);
        System.out.println(root.val);
    }

    public void traversalTreePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        while (root != null) {
            treeNodes.add(root);
            root = root.left;
            if (root == null) {

            }
        }
//        while (root != null || !treeNodes.isEmpty()) {
//            if (root != null) {
//                treeNodes.add(root);
//                System.out.println(root.val);
//                root = root.left;
//            } else {
//                TreeNode node = treeNodes.removeLast();
//                root = node.right;
//            }
//        }
    }
}
