package LinkedList.RevertLinkedList;

import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * Created by Frank_Hon on 2019-07-22 00:41.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode l1= LinkedListUtil.buildLinkedList(1,2,3);
        LinkedListUtil.printLinkedList(l1);
        ListNode target=solution.revert(l1);
        LinkedListUtil.printLinkedList(target);
    }

    private ListNode revert(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode temp01 = head.next;
        head.next = null;

        ListNode last=head;

        while (temp01 != null) {
            ListNode temp02 = temp01.next;
            temp01.next = last;
            last = temp01;
            temp01 = temp02;
        }

        return last;
    }
}
