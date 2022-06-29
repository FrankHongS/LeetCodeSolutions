package LinkedList.Merge2List;

import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * Merge two sorted list
 * <p>
 * Merge two sorted list and return it as a new list.
 * The new list should be made by splicing together the nodes of the first
 * two lists.
 * <p>
 * eg:
 * Input: 1>2>4, 1>3>4
 * Output: 1>1>2>3>4>4
 * <p>
 * Created by Frank_Hon on 2019-06-10 23:05.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode l1 = LinkedListUtil.buildLinkedList(1, 2, 4);
        ListNode l2 = LinkedListUtil.buildLinkedList(1, 3, 4);

        LinkedListUtil.print(l1);
        LinkedListUtil.print(l2);

        ListNode merged = solution.mergeTwoList(l1, l2);

        LinkedListUtil.print(merged);

    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);

        ListNode target = temp;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }

        return target.next;
    }
}
