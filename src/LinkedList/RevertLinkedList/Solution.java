package LinkedList.RevertLinkedList;

import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * Created by Frank_Hon on 2019-07-22 00:41.
 * E-mail: frank_hon@foxmail.com
 * 反转链表
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = LinkedListUtil.buildLinkedList(1, 2, 3, 4, 5, 6, 7);
        LinkedListUtil.print(l1);
        ListNode target = solution.revert(l1, 2);
        LinkedListUtil.print(target);
    }

    private ListNode revert(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;//保存旧链表未反转的值
            head.next = newHead;//将旧链表的首元素连接到新链表的头部
            newHead = head;//更新新链表头部（首元素）
            head = temp;//更新旧链表头部（首元素）
        }
        return newHead;
    }

    /**
     * 以n个元素为一组，分组反转链表，
     * 比如n=2时，输入1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
     * 输出7 -> 5 -> 6 -> 3 -> 4 -> 1 -> 2
     * 当n=1时，问题降级为普通反转链表
     * @param n 每组元素个数
     * 快手
     */
    private ListNode revert(ListNode head, int n) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tempHead = head;//保存 元素组 的头部
            //通过n-1次循环，head被指向元素组的最后一个元素
            for (int i = n; i > 1; i--) {
                if (head.next != null) {
                    head = head.next;
                } else {
                    break;
                }
            }
            ListNode temp = head.next;//保存旧链表未反转的值
            head.next = newHead;//将旧链表的首元素连接到新链表的头部（头插法）
            newHead = tempHead;//更新新链表头部（首元素）
            head = temp;//更新旧链表头部（首元素）
        }
        return newHead;
    }
}
