package BookOffer.P52;

import javafx.util.Pair;
import util.LinkedListUtil;
import util.entity.ListNode;

import java.util.LinkedList;

/**
 * 题目：两个链表的第一个公共节点
 * 输入两个链表，找出它们第一个公共节点
 *
 * Created by Frank_Hon on 2022/5/31 上午11:50.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Pair<ListNode, ListNode> pair1 = LinkedListUtil.buildLinkedListReturnEnds(1, 2, 3);
        Pair<ListNode, ListNode> pair2 = LinkedListUtil.buildLinkedListReturnEnds(4, 5, 6);
        ListNode head1 = pair1.getKey();
        ListNode tail1 = pair1.getValue();
        ListNode head2 = pair2.getKey();
        ListNode tail2 = pair2.getKey();
        ListNode head3 = LinkedListUtil.buildLinkedList(70, 8, 9);
        tail1.next = head3;
        tail2.next = head3;
        ListNode target = solution.findFirstCommonNode1(head1, head2);
//        ListNode target = solution.findFirstCommonNode2(head1, head2);
        System.out.println(target.value);
    }

    private ListNode findFirstCommonNode1(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();

        ListNode curNode1 = head1;
        ListNode curNode2 = head2;

        while (curNode1 != null) {
            stack1.push(curNode1);
            curNode1 = curNode1.next;
        }
        while (curNode2 != null) {
            stack2.push(curNode2);
            curNode2 = curNode2.next;
        }
        int size1 = stack1.size();
        int size2 = stack2.size();

        int size = Math.min(size1, size2);
        ListNode target = null;
        for (int i = 0; i < size; i++) {
            ListNode temp1 = stack1.pop();
            ListNode temp2 = stack2.pop();
            if (temp1 == temp2) {
                target = temp1;
            } else {
                break;
            }
        }
        return target;
    }

    /**
     * 首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个节点。
     * 在第二次遍历的时候，在较长的链表先走若干步，接着同时在两个链表上遍历，找到第一个相同的节点就是公共节点；
     *
     * 也可以借用两个辅助栈，将两个链表遍历的结果存入栈中，然后从栈尾开始遍历。由于两个链表如果存在交点，尾部节点
     * 一定相同，所以可以通过从栈尾同时遍历两个栈，最后一个相等的节点就是交点。
     *
     */
    private ListNode findFirstCommonNode2(ListNode head1, ListNode head2) {
        int length1 = getLinkedListLength(head1);
        int length2 = getLinkedListLength(head2);

        int deltaLength = Math.abs(length1 - length2);
        ListNode longHead, shortHead;
        if (length1 > length2) {
            longHead = head1;
            shortHead = head2;
        } else {
            longHead = head2;
            shortHead = head1;
        }
        for (int i = 0; i < deltaLength; i++) {
            longHead = longHead.next;
        }
        int length = Math.max(length1, length2);
        for (int j = 0; j < length - deltaLength; j++) {
            if (longHead == shortHead) {
                return shortHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }

    private int getLinkedListLength(ListNode head) {
        int length = 0;
        ListNode curNode = head;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        return length;
    }

}
