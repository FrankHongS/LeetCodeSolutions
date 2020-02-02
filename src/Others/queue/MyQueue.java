package Others.queue;

import java.util.Stack;

/**
 * Created by Frank_Hon on 2019-07-20 11:59.
 * E-mail: frank_hon@foxmail.com
 *
 * FIFO
 */
public class MyQueue<T> implements Queue<T>{

    private Stack<T> stack1;
    private Stack<T> stack2;

    public MyQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    @Override
    public synchronized void push(T item) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(item);

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    @Override
    public T pop() {
        return stack1.pop();
    }

    @Override
    public int size() {
        return stack1.size();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
