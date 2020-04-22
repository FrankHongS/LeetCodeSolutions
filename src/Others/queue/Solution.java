package Others.queue;

import java.util.Stack;

/**
 * Created by Frank_Hon on 2019-07-20 11:55.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        Queue<Integer> queue=new MyQueue<>();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println("Queue: ");
        while (!queue.isEmpty()){
            System.out.println(queue.pop());
        }

        Stack<Integer> stack=new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack: ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
