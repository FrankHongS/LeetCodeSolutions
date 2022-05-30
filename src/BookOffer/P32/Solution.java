package BookOffer.P32;

import util.TreeUtil;
import util.entity.TreeNode;

import java.util.LinkedList;

/**
 * 题目：从上到下打印二叉树
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行，例如：
 *          8
 *      6      10
 *   5    7  9    11
 * 打印结果为：
 * 8
 * 6 10
 * 5 7 9 11
 * <p>
 * Created by Frank_Hon on 2022/5/25 上午12:31.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildCompleteBinaryTree(8, 6, 10, 5, 7, 9, 11);
        Solution solution = new Solution();
//        solution.printByLevel1(root);
        solution.printByLevel2(root);
    }

    private void printByLevel1(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //下一层节点数
        int nextLevelNodeCount = 0;
        //当前层待打印节点数
        int toBePrinted = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            toBePrinted--;
            if (node.left != null) {
                queue.offer(node.left);
                nextLevelNodeCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelNodeCount++;
            }
            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevelNodeCount;
                nextLevelNodeCount = 0;
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    private void printByLevel2(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.value + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
}
