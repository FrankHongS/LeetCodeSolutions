package tree.VerticalTraversal;

import util.TreeUtil;
import util.entity.TreeNode;

import java.util.*;

/**
 * Vertical Order Traversal of a Binary Tree
 *
 * Given a binary tree, return the vertical order traversal of its nodes values.
 *
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 *
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 *
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 *
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 *
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root= TreeUtil.buildCompleteBinaryTree(new Integer[]{1,2,3,4,5,6,7});

        Solution solution=new Solution();
        System.out.println(solution.verticalTraversal(root));

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> target = new ArrayList<>();
        List<CoordinateNode> nodeList = new ArrayList<>();
        traversal(root, 0, 0, nodeList);
        Collections.sort(nodeList);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nodeList.size(); i++) {
            CoordinateNode node = nodeList.get(i);
            if (i == 0) {
                list.add(node.val);
                continue;
            }

            CoordinateNode lastNode = nodeList.get(i - 1);
            if (node.x == lastNode.x) {
                list.add(node.val);
            } else {
                target.add(list);
                list = new ArrayList<>();
                list.add(node.val);
            }
        }
        target.add(list);

        return target;
    }

    private void traversal(TreeNode root, int x, int y, List<CoordinateNode> nodeList) {
        if (root == null)
            return;
        nodeList.add(new CoordinateNode(x, y, root.val));
        traversal(root.left, x - 1, y - 1, nodeList);
        traversal(root.right, x + 1, y - 1, nodeList);
    }

    static class CoordinateNode implements Comparable<CoordinateNode> {
        int x;
        int y;
        int val;

        CoordinateNode(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(CoordinateNode o) {

            if (x == o.x) {
                if (y == o.y) {
                    return val - o.val;
                }
                return o.y - y;
            }

            return x - o.x;
        }
    }

}
