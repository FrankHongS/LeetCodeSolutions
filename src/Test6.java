import javafx.util.Pair;
import util.LinkedListUtil;
import util.entity.ListNode;

/**
 * Created by Frank_Hon on 2022/10/13 7:29 PM.
 * E-mail: frank_hon@foxmail.com
 *
 * 局部翻转链表 Cider
 */
public class Test6 {

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        ListNode head = LinkedListUtil.buildLinkedList(1, 2, 3, 4, 5);
        LinkedListUtil.print(head);
        ListNode result = test6.revert(head, 1, 5);
        LinkedListUtil.print(result);
    }

    private ListNode revert(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }
        int count = 1;
        ListNode tempHead = head;
        ListNode temp = null;
        ListNode prev = null;
        ListNode tail;
        while (head != null) {
            if (count + 1 == start) {
                prev = head;
            }
            if (count == start) {
                temp = head;
            }
            if (count == end) {
                tail = head.next;
                head.next = null;
                Pair<ListNode, ListNode> result = revert(temp);
                if (prev != null) {
                    prev.next = result.getKey();
                    result.getValue().next = tail;
                    return tempHead;
                } else {
                    result.getValue().next = tail;
                    return result.getKey();
                }
            }
            head = head.next;
            count++;
        }
        return null;
    }

    private Pair<ListNode, ListNode> revert(ListNode head) {
        ListNode newHead = null;
        ListNode newTail = head;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return new Pair<>(newHead, newTail);
    }

}
