import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        A a=B.a;

        List<String> list=new ArrayList<>();
        list.add("Chandler");

        for(String str:list){
            list.add("Joey");
        }
    }
}
