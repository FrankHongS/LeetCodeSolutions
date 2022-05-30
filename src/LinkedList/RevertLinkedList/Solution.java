package LinkedList.RevertLinkedList;

import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * Created by Frank_Hon on 2019-07-22 00:41.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.buildLinkedList(1, 2, 3);
        LinkedListUtil.printLinkedList(l1);
        ListNode target = LinkedListUtil.revert(l1);
        LinkedListUtil.printLinkedList(target);
    }
}
