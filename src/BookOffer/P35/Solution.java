package BookOffer.P35;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：复杂链表的复制
 * 请实现函数ComplexListNode clone(ComplexListNode head),复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个next指针指向下一个节点，还有一个sibling指针
 * 指向链表中任意节点或者null
 *
 * Created by Frank_Hon on 2022/5/25 下午11:58.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) throws CloneNotSupportedException {
        Solution solution = new Solution();
        ComplexListNode next = new ComplexListNode();
        next.value = 5;

        ComplexListNode sibling = new ComplexListNode();
        sibling.value = 4;

        ComplexListNode node = new ComplexListNode();
        node.value = 2;
        node.next = next;
        node.sibling = sibling;

        ComplexListNode cloned = solution.cloneNodes(node);
    }

    private static class ComplexListNode implements Cloneable {
        public int value;
        public ComplexListNode next;
        public ComplexListNode sibling;

        //shallow clone
        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new ComplexListNode();
        }

        public ComplexListNode shallowClone() {
            ComplexListNode cloned = new ComplexListNode();
            cloned.value = value;
            cloned.next = next;
            return cloned;
        }

        @Override
        public String toString() {
            return "ComplexListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    ", sibling=" + sibling +
                    '}';
        }
    }

    /**
     * 通过map将node和clonedNode一一映射存储起来
     */
    private ComplexListNode cloneNodes(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        ComplexListNode curNode = head;
        ComplexListNode clonedHead = null;
        Map<ComplexListNode, ComplexListNode> map = new HashMap<>();
        while (curNode != null) {
            ComplexListNode cloned = curNode.shallowClone();
            if (clonedHead == null) {
                clonedHead = cloned;
            }
            map.put(curNode, cloned);
            curNode = curNode.next;
        }
        curNode = head;
        while (curNode != null) {
            ComplexListNode cloned = map.get(curNode);
            cloned.sibling = map.get(curNode.sibling);
            curNode = curNode.next;
        }
        return clonedHead;
    }
}
