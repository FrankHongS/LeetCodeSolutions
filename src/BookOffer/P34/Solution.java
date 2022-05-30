package BookOffer.P34;

import util.TreeUtil;
import util.Util;
import util.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成的一条路径。
 * <p>
 * Created by Frank_Hon on 2022/5/22 下午11:39.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.buildCompleteBinaryTree(10, 5, 12, 4, 7);
        List<List<Integer>> paths = solution.findPath(root, 19);
        System.out.println(paths);
    }

    private List<List<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> paths = new ArrayList<>();
        traversalTreePreOrder(root, target, new LinkedList<>(), paths);
        return paths;
    }

    public void traversalTreePreOrder(TreeNode root, int target,
                                      LinkedList<Integer> stack, List<List<Integer>> paths) {
        if (root != null) {
//            stack.addLast(root.value);
            stack.push(root.value);
            if (root.left == null && root.right == null) {
                int sum = Util.sum(stack);
                if (sum == target) {
                    paths.add(new ArrayList<>(stack));
                }
            }
            traversalTreePreOrder(root.left, target, stack, paths);
            traversalTreePreOrder(root.right, target, stack, paths);
//            stack.removeLast();
            stack.pop();
        }
    }
}
