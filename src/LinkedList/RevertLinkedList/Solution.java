package LinkedList.RevertLinkedList;

import Util.LinkedListUtil;
import Util.entity.ListNode;

/**
 * Created by Frank_Hon on 2019-07-22 00:41.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = LinkedListUtil.buildLinkedList(1, 2, 3);
        LinkedListUtil.printLinkedList(l1);
        ListNode target = solution.revert(l1);
        LinkedListUtil.printLinkedList(target);
    }

    private ListNode revert(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;//保存旧链表除首元素外剩下的值
            head.next = newHead;//将旧链表的首元素连接到新链表的头部
            newHead = head;//更新新链表头部（首元素）
            head = temp;//更新旧链表头部（首元素）
        }
        return newHead;
    }
}
