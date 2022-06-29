package BookOffer.P22;

import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * 链表中倒数第k个节点
 * 题目：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
 * 从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * Created by Frank_Hon on 2021/8/29 6:13 下午.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {
    public static void main(String[] args) {
        ListNode root = LinkedListUtil.buildLinkedList(1, 2, 3, 4, 5, 6);
        Solution solution = new Solution();
        int index = 3;
//        ListNode target = solution.indexOfByReverse(root, index);
        ListNode target = solution.findKthToTail(root, index);
        System.out.println(target.value);
    }

    private ListNode indexOfByReverse(ListNode root, int index) {
        ListNode reverted = LinkedListUtil.revert(root);
        return LinkedListUtil.indexOf(reverted, index - 1);
    }

    /**
     * 定义两个指针，第一个指针从链表头指针开始遍历向前走k-1步，第二个指针保持不动；
     * 从第k步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1，
     * 当第一个到达尾节点时，第二个指针正好指向倒数第k个节点。
     */
    private ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode ahead = head;
        ListNode behind = head;

        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {
                return null;
            }
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }
}
