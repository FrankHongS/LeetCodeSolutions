import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frank_Hon on 2019-07-21 00:55.
 * E-mail: frank_hon@foxmail.com
 */
public class Test {

//    private static void hi(){
//        System.out.println("Hi");
//    }
//
//    static class Inner{
//
//        public void hello(){
//            System.out.println("hello");
//            Test.hi();
//        }
//
//    }

    public static void main(String[] args) {
        A a1=new A("Joey",28);
        A a2=new A("Joey",28);

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());

        System.out.println(a1==a2);// ==对于对象来说，需要存储地址相同
        System.out.println(a1.equals(a2));// equal直接调用对象的equal方法

        Map<A,Integer> map=new HashMap<>();
        map.put(a1,2);
        // HashMap调用get时，首先通过key的hashCode找到bucket，然后遍历链表或红黑树（长度大于8用红黑树存储，否则用链表），
        // 找到key值相同的Entry（通过调用key的equals方法），如果没有返回null
        System.out.println(map.get(a2));
    }

    static class A{

        String name;
        int age;

        public A(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 17;
            result = prime * result + name.hashCode();
            result = prime * result + age;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj){
                return true;
            }

            if(obj instanceof A){
                A other= (A) obj;
                if(name!=null&&name.equals(other.name)){
                    return age == other.age;
                }
            }

            return false;
        }
    }

}
