package Tree.Problem34;

import util.TreeUtil;
import util.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.buildCompleteBinaryTree(new Integer[]{10, 5, 12, 4, 7, null, null});

        System.out.println(solution.findShortestPath(root, 22));
    }

    public List<List<Integer>> findShortestPath(TreeNode root, int distance) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> target = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        traversal(root, distance, list, target);

        return target;
    }

    private void traversal(TreeNode root, int distance, LinkedList<Integer> list, List<List<Integer>> target) {
        if (root == null) {
            return;
        }

        list.push(root.val);

        if (root.left == null && root.right == null) {
            int sum = sumLinkedList(list);
            if (sum == distance) {
                target.add(new ArrayList<>(list));
            }
            list.pop();
            return;
        }

        traversal(root.left, distance, list, target);
        traversal(root.right, distance, list, target);

        list.pop();
    }

    private int sumLinkedList(LinkedList<Integer> list) {
        int sum = 0;

        for (int i : list) {
            sum += i;
        }

        return sum;
    }
}
