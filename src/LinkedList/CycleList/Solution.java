package LinkedList.CycleList;

import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * Linked List Cycle 2
 * <p>
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * Note: do not modify the linked list
 * <p>
 * Follow up: can you solve it without using extra space ?
 * <p>
 * Linked List Cycle 1
 * <p>
 * Given a linked list, determine if there is a cycle int it.
 * <p>
 * Follow up: can you solve it without extra space ?
 * <p>
 * Created by Frank_Hon on 2018-03-08 (maybe, copied from the previous).
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {

        ListNode l1 = LinkedListUtil.buildCycleLinkedList(1, 1, 2, 3, 4, 5, 6);

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(l1));
    }

    // O(n)
    public boolean hasCycle(ListNode root) {
        while (root != null) {
            if (root.next == root) {
                return true;
            }
            ListNode temp = root.next;
            root.next = root;
            root = temp;
        }

        return false;
    }

    //找到环的入口节点O(n^2)
    public ListNode detectCycle(ListNode head) {

        int count = 0;
        ListNode p, q;

        p = head;
        if (p == null)
            return null;
        p = p.next;

        while (p != null) {

            count++;

            q = head;

            for (int i = 0; i < count; i++) {

                if (p == q) {
                    return p;
                }
                q = q.next;
            }
            p = p.next;
        }

        return null;
    }
}
