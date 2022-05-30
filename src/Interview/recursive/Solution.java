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
 * <p>
 * 尾递归改成迭代写法
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildCompleteBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Solution solution = new Solution();
        solution.traversalTreeInOrderByRecursive(root);
        System.out.println();
        solution.traversalTreeInOrder(root);

//        solution.traversalTreePreOrderByRecursive(root);
//        System.out.println();
//        solution.traversalTreePreOrder(root);

//        solution.traversalTreePostOrderByRecursive(root);
//        System.out.println();
//        solution.traversalTreePostOrder(root);
    }

    public void traversalTreeInOrderByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalTreeInOrderByRecursive(root.left);
        System.out.print(root.value);
        traversalTreeInOrderByRecursive(root.right);
    }

    public void traversalTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        // 常规思路，模仿递归的逻辑
        while (root != null) {
            treeNodes.push(root);
            root = root.left;
            while (root == null && !treeNodes.isEmpty()) {
                TreeNode node = treeNodes.pop();
                System.out.print(node.value);
                root = node.right;
            }
        }
        // 很巧妙，很难想
//        while (root != null || !treeNodes.isEmpty()) {
//            if (root != null) {
//                treeNodes.push(root);
//                root = root.left;
//            } else {
//                TreeNode node = treeNodes.pop();
//                System.out.print(node.val);
//                root = node.right;
//            }
//        }
    }

    public void traversalTreePreOrderByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value);
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
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            root = treeNodes.pop();
            System.out.print(root.value);

            if (root.right != null) {
                treeNodes.push(root.right);
            }
            if (root.left != null) {
                treeNodes.push(root.left);
            }
        }
    }

    public void traversalTreePostOrderByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        traversalTreePostOrderByRecursive(root.left);
        traversalTreePostOrderByRecursive(root.right);
        System.out.print(root.value);
    }

    // 前序和后序都能用这种形式，一个栈遍历，一个列表存储目标值（下面的第二个栈可以用列表替代）
    // 尾递归可以不用栈，而用迭代来实现
    // 左右中 和 中右左 的遍历方式，最后得出的序列相反
    public void traversalTreePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes1 = new LinkedList<>();
        LinkedList<TreeNode> treeNodes2 = new LinkedList<>();
        treeNodes1.add(root);
        while (!treeNodes1.isEmpty()) {
            root = treeNodes1.pop();
            treeNodes2.push(root);
            if (root.left != null) {
                treeNodes1.push(root.left);
            }
            if (root.right != null) {
                treeNodes1.push(root.right);
            }
        }
        while (!treeNodes2.isEmpty()) {
            TreeNode node = treeNodes2.pop();
            System.out.print(node.value);
        }
    }

    //todo 尾递归
}
