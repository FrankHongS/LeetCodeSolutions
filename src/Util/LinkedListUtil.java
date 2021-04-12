package Util;

import Util.entity.ListNode;

/**
 * Created by Frank_Hon on 2019-06-10 23:27.
 * E-mail: frank_hon@foxmail.com
 */
public class LinkedListUtil {

    public static void printLinkedList(ListNode root) {

        if (root == null) {
            throw new RuntimeException("root can not be null");
        }

        while (root != null) {
            if (root.next == null) {
                System.out.println(root.val);
            } else {
                System.out.print(root.val + " -> ");
            }

            root = root.next;
        }
    }

    public static ListNode buildLinkedList(int... vals) {

        if (vals.length <= 0) {
            return null;
        }

        ListNode temp = new ListNode(vals[0]);
        ListNode target = temp;

        for (int i = 1; i < vals.length; i++) {
            temp.next = new ListNode(vals[i]);
            temp = temp.next;
        }

        return target;
    }

    public static void printCycleLinkedList(ListNode target) {
        ListNode p, q;
        p = target;
        if (p == null) {
            System.out.println("ListNode can't be null");
            return;
        }

        System.out.print(p.val + "->");
        p = p.next;

        int count = 0;

        while (p != null) {
            count++;

            q = target;

            for (int i = 0; i < count; i++) {
                if (p == q) {
                    System.out.println("Cycle:" + p.val + "\n");
                    return;
                }
                q = q.next;
            }

            if (p.next == null) {
                System.out.print(p.val + "\n");
            } else {
                System.out.print(p.val + "->");
            }

            p = p.next;
        }
    }

    public static ListNode buildCycleLinkedList(int index, int... vals) {
        if (vals.length == 0) {
            return null;
        }

        ListNode output = new ListNode(vals[0]);
        ListNode temp = output;

        if (vals.length == 1) {
            if (index == 0) {
                temp.next = temp;
            } else {
                throw new RuntimeException("the cycle index is out of index");
            }
        }

        for (int i = 1; i < vals.length; i++) {
            temp.next = new ListNode(vals[i]);
            temp = temp.next;

            if (i == vals.length - 1) {
                temp.next = indexOf(output, index);
            }
        }

        return output;
    }

    private static ListNode indexOf(ListNode head, int index) {
        int count = 0;
        while (head != null) {
            if (count == index) {
                return head;
            }

            head = head.next;
            count++;
        }

        throw new RuntimeException("out of head's index");
    }
}
