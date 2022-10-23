import util.entity.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Frank_Hon on 2022/8/8 4:31 PM.
 * E-mail: frank_hon@foxmail.com
 */
public class Test4 {

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(input);
        String[] strArray1 = new String[]{
                "木桩", "白菜", "手套", "胡萝卜", "白菜", "水桶", "手套", "水桶", "火", "玉米", "手套", "剪刀", "叉子", "铃铛", "白云"
        };
        String[] strArray2 = new String[]{
                "白云", "木桩", "胡萝卜", "草", "剪刀", "毛线", "白菜", "草", "奶瓶", "白云", "稻草", "白菜", "白菜", "白菜", "奶瓶"
        };
        LinkedList<String> stack1 = new LinkedList<>(Arrays.asList(strArray1));
        LinkedList<String> stack2 = new LinkedList<>(Arrays.asList(strArray2));
        String str;
        while (!"bye".equals(str = in.readLine())) {
            char[] chars = str.toCharArray();
            if (chars.length > 0) {
                switch (chars[0]) {
                    case '1':
                        stack1.offer(str.substring(1));
                        System.out.println("stack1: " + stack1);
                        break;
                    case '2':
                        stack2.offer(str.substring(1));
                        System.out.println("stack2: " + stack2);
                        break;
                    case 'a':
                        if (stack1.isEmpty()) {
                            System.out.println("stack1 is empty");
                        } else {
                            stack1.poll();
                            System.out.println("stack1 now: " + stack1 + "\nsize = " + stack1.size());
                        }
                        break;
                    case 'b':
                        if (stack2.isEmpty()) {
                            System.out.println("stack2 is empty");
                        } else {
                            stack2.poll();
                            System.out.println("stack2 now: " + stack2 + "\nsize = " + stack2.size());
                        }
                        break;
                    case 'p':
                        System.out.println("stack1: " + stack1 + "\nsize = " + stack1.size());
                        break;
                    case 'q':
                        System.out.println("stack2: " + stack2 + "\nsize = " + stack2.size());
                        break;
                    case 'c':
                        stack1.clear();
                        System.out.println("Clear stack1 successfully !");
                        break;
                    case 'd':
                        stack2.clear();
                        System.out.println("Clear stack2 successfully !");
                        break;
                    default:
                        break;
                }
            }
        }
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
