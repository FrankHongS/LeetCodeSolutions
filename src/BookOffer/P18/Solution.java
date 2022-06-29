package BookOffer.P18;

import javafx.util.Pair;
import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * 题目：删除链表的节点
 * Created by Frank_Hon on 2022/6/4 下午4:46.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Pair<ListNode, ListNode> pair = LinkedListUtil.buildLinkedListReturnEnds(1, 2, 3, 4, 5);
        ListNode head1 = pair.getKey();
        ListNode tail1 = pair.getValue();
//        ListNode toBeDeleted = head1;
        ListNode toBeDeleted = new ListNode(60);
        tail1.next = toBeDeleted;
//        ListNode head2 = LinkedListUtil.buildLinkedList(6, 7, 8, 9);
//        toBeDeleted.next = head2;

        LinkedListUtil.print(head1);
        if (head1.next == null && head1 == toBeDeleted) {
            head1 = null;
        }
        solution.deleteNode(head1, toBeDeleted);
        LinkedListUtil.print(head1);
    }

    /**
     * 描述：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
     *
     * 平均时间复杂度O(1)
     * 把待删除节点的下一个节点内容复制到需要删除的节点上覆盖原有内容；
     * 如果待删除节点位于尾部，仍然需要从头开始遍历，得到待删除节点的前一个节点；
     * 如果链表刚好只有一个节点，需特殊处理
     */
    private void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        ListNode next = toBeDeleted.next;
        if (next != null) {
            toBeDeleted.value = next.value;
            toBeDeleted.next = next.next;
            next.next = null;
            next = null;
        } else {
            ListNode node = head;
            while (node.next != null) {
                if (node.next == toBeDeleted) {
                    node.next = null;
                    return;
                }
                node = node.next;
            }
        }
    }

    private ListNode deleteDuplication(ListNode head) {
        ListNode target = head;
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            boolean needDelete = false;
            if (next != null && next.value == curNode.value) {
                needDelete = true;
            }
            if (!needDelete) {
                preNode = curNode;
                curNode = next;
            } else {
                int value = curNode.value;
                ListNode toBeDeleted = curNode;
                while (toBeDeleted != null && toBeDeleted.value == value) {
                    next = toBeDeleted.next;
                    toBeDeleted = next;
                }
                if (preNode != null) {
                    preNode.next = next;
                } else {
                    target = next;
                }
                curNode = next;
            }
        }
        return target;
    }
}
