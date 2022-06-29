package LinkedList.RevertPrintLinkedList;

import util.LinkedListUtil;
import util.entity.ListNode;

import java.util.LinkedList;

/**
 * Created by Frank_Hon on 2020/12/4 9:18 上午.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = LinkedListUtil.buildLinkedList(1, 2, 3, 4, 5);
        LinkedListUtil.print(head);
        solution.revertPrintByIteration(head);
        System.out.println();
        solution.revertPrintByRecursion(head);
    }

    private void revertPrintByIteration(ListNode head) {
        if (head == null) {
            return;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            System.out.print(cur.value);
        }
    }

    // Recursion may throw StackOverflowException
    private void revertPrintByRecursion(ListNode head) {
        if (head != null) {
            revertPrintByRecursion(head.next);
            System.out.print(head.value);
        }
    }
}
