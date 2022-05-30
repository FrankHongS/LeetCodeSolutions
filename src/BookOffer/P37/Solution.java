package BookOffer.P37;

import util.TreeUtil;
import util.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank_Hon on 2020/12/6 6:25 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 序列化二叉树
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 提示：已知二叉树叶子节点为null且给出一种遍历序列（前序/中序/后序），可以唯一确定这棵树；
 * 已知二叉树为完全二叉树（如果节点为空，可以将该处值设为null，
 * 以凑成完全二叉树）且给出从上到下分层遍历序列（BFS），可以唯一确定这棵树；
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.buildCompleteBinaryTree(
                new Integer[]{1, 2, 3, 4, null, 5, 6, null, 7, null, null, null, null, 8}
        );
//        TreeUtil.printTreePreOrder(root);
        List<Integer> container = new ArrayList<>();
        solution.serializeTree(root, container);
        System.out.println(container);
        TreeNode temp = solution.deserializeTree(container);
        TreeUtil.printTreePreOrder(temp);
    }

    // PreOrder Traversal
    // 使用BFS（从上到下分层遍历）应该也可以
    private void serializeTree(TreeNode root, List<Integer> container) {
        if (container == null) {
            return;
        }
        if (root != null) {
            container.add(root.value);
            serializeTree(root.left, container);
            serializeTree(root.right, container);
        } else {
            container.add(null);
        }
    }

    private TreeNode deserializeTree(List<Integer> container) {
        if (container == null || container.isEmpty()) {
            return null;
        }
        Integer val = container.remove(0);
        if (val != null) {
            TreeNode root = new TreeNode(val);
            root.left = deserializeTree(container);
            root.right = deserializeTree(container);
            return root;
        }
        return null;
    }
}
