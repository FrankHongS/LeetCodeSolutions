package Other.hanoitower;

import java.util.Stack;

/**
 * Created by Frank_Hon on 2019-07-20 12:40.
 * E-mail: frank_hon@foxmail.com
 */
@SuppressWarnings("all")
public final class HanoiTower {

    /**
     * @param stack1 initial
     * @param stack2
     * @param stack3 target
     * @param <T>
     *
     * throws StackOverflow exception in this way
     */
    public static <T> void playHanoiTower(Stack<T> stack1, Stack<T> stack2, Stack<T> stack3) {

        if (stack1.size() == 1) {
            T item=stack1.pop();
            stack3.push(item);
        }else if(stack1.size()==2){
            T item1=stack1.pop();
            stack2.push(item1);
            T item2=stack1.pop();
            stack3.push(item2);
            T item3=stack2.pop();
            stack3.push(item3);
        } else {
            T last = stack1.remove(0);
            playHanoiTower(stack1, stack3, stack2);
            stack3.push(last);
            playHanoiTower(stack2, stack1, stack3);
        }

    }

    // O(2^n)
    public static void playHanoiTower(int n,String a,String b,String c){
        if(n==1){
            System.out.println(String.format("将盘子【%d】从%s---->%s",n,a,c));
        }else {
            playHanoiTower(n-1,a,c,b);
            System.out.println(String.format("将盘子【%d】从%s---->%s",n,a,c));
            playHanoiTower(n-1,b,a,c);
        }
    }
}
