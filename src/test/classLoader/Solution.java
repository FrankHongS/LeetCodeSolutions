package test.classLoader;

public class Solution {

    public static void main(String[] args) {
        /*
             执行顺序：
             A static block
             B static block
             A non-static block
             A constructor3
             B non-static block
             B constructor
         */
        B b=new B();
//        B.get();//触发类加载
    }

}
