package test.singleton;

public class D {
    // 饿汉模式

    private static final D INSTANCE = new D();//类装载的时候就会分配内存，并不会初始化

    static {
        System.out.println("initial static block");
    }

    {
        System.out.println("initial non-static block");
    }

    private D() {

    }

    public static D getInstance() {
        return INSTANCE;
    }

    public static void get(){

    }

}
