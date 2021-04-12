package Tree.BFS;

import Util.TreeUtil;
import Util.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * broad search first
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root = TreeUtil.buildCompleteBinaryTree(new Integer[]{
                3, 9, 20, 1, 2, 15, 7
        });

        TreeUtil.printTreePreOrder(root);
//        System.out.println("level order:");
//        System.out.println(solution.levelOrder(root));
        System.out.println();
        solution.levelOrder2(root);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> target = new ArrayList<>();

        if (root == null)
            return target;

        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);

        while (!cache.isEmpty()) {
            int size = cache.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = cache.poll();

                levelList.add(temp.val);

                if (temp.left != null)
                    cache.offer(temp.left);
                if (temp.right != null)
                    cache.offer(temp.right);
            }

            target.add(levelList);
        }

        return target;
    }

    public void levelOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.removeFirst();
                System.out.print(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
}

