package test.classLoader;

public class B extends A{

    {
        System.out.println(" B non-static block");
    }

    static {
        System.out.println(" B static block");
    }

    public B(){
        System.out.println(" B constructor");
    }

    public static void get(){

    }

}
