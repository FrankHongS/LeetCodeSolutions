import util.entity.TreeNode;

import java.util.LinkedList;

/**
 * Created by Frank_Hon on 2022/8/8 4:31 PM.
 * E-mail: frank_hon@foxmail.com
 */
public class Test4 {

    public static void main(String[] args) {

    }

    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

}
