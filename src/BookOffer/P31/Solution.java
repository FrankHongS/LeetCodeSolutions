package BookOffer.P31;

import java.util.LinkedList;

/**
 * Created by Frank_Hon on 2021/4/12 10:25 下午.
 * E-mail: frank_hon@foxmail.com
 * <p>
 * 栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否
 * 为栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列{1,2,3,4,5}是某栈的
 * 压栈序列，序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，但{4,3,5,1,2}就不可能
 * 是该压栈序列的弹出序列。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushOrder = {1, 2, 3, 4, 5};
//        int[] popOrder1 = {4, 5, 3, 2, 1};
        int[] popOrder2 = {4, 3, 5, 1, 2};

        System.out.println(solution.isPopOrder(pushOrder, popOrder2));
    }

    public boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null) {
            return true;
        }

        if (pushOrder.length == 0 || popOrder.length == 0) {
            return true;
        }

        if (pushOrder.length != popOrder.length) {
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(pushOrder[0]);

        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (stack.isEmpty()) {
                return true;
            }
            int lastItem = stack.peek();
            if (lastItem == popOrder[index2]) {
                index2++;
                stack.pop();
            } else {
                index1++;
                if (index1 >= pushOrder.length) {
                    return false;
                }
                stack.push(pushOrder[index1]);

            }
        }
    }
}
