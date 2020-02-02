package test.classLoader;

public class A {

    {
        System.out.println(" A non-static block");
    }

    static {
        System.out.println(" A static block");
    }

    public A(){
        System.out.println(" A constructor");
    }

}
