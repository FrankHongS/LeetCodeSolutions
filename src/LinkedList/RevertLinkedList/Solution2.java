package LinkedList.RevertLinkedList;

import javafx.util.Pair;
import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * 题目：分组翻转，k个一组，将每组翻转的新链表按顺序连接
 * 
 * Created by Frank_Hon on 2022/9/14 4:52 PM.
 * E-mail: frank_hon@foxmail.com
 * 
 * 出门问问
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode head = LinkedListUtil.buildLinkedList(1, 2, 3, 4, 5, 6, 7);
        LinkedListUtil.print(head);
//        ListNode target = solution.revert(head, 3);
        ListNode target = solution.revert(head, 2);
        LinkedListUtil.print(target);
    }

    /**
     * 分组翻转，k个一组，将每组翻转的新链表按顺序连接
     * @param k 每组链表的元素个数
     */
    private ListNode revert(ListNode head, int k) {
        int count = 0;
        // 存储待分组翻转的链表；有可能因为长度小于k，不满足翻转条件
        ListNode temp = head;
        ListNode newHead = null;
        ListNode newTail = null;
        while (head != null) {
            count++;
            head = head.next;
            if (count % k == 0) {
                Pair<ListNode, ListNode> tempPair = limitRangeRevert(temp, k);
                if (newHead == null || newTail == null) {
                    newHead = tempPair.getKey();
                } else {
                    newTail.next = tempPair.getKey();
                }
                newTail = tempPair.getValue();
                temp = head;
            } else {
                if (head == null) {
                    if (newTail != null) {
                        newTail.next = temp;
                    } else {
                        newHead = temp;
                    }
                }
            }
        }
        return newHead;
    }

    /**
     * 翻转链表，最多翻转k个
     * @param k 最多翻转元素个数
     * @return pair 新链表的头节点和尾节点
     */
    private Pair<ListNode, ListNode> limitRangeRevert(ListNode head, int k) {
        ListNode newHead = null;
        ListNode newTail = head;
        int count = 0;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
            count++;
            if (count >= k) {
                break;
            }
        }
        return new Pair<>(newHead, newTail);
    }
}
