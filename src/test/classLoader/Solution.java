package test.classLoader;

public class Solution {

    public static void main(String[] args) {
//        B b=new B();
        B.get();//触发类加载
    }

}
