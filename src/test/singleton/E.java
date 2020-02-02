package test.singleton;

public class E {

    {
        System.out.println("initial non-static block");
    }

    static {
        System.out.println("initial static block");
    }
    private E() {

    }

    public static E getInstance() {
        return EHolder.INSTANCE;
    }

    public static void get(){

    }

    private static class EHolder {
        private static E INSTANCE = new E();

        {
            System.out.println("initial EHolder non-static block");
        }

        static {
            System.out.println("initial EHolder static block");
        }
    }

}
