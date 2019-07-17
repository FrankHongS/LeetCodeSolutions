package test.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test01 {

    public static void main(String[] args) {
        // 遍历key时,HashMap不能保证顺序为插入顺序,LinkedHashMap可以保证
        Map<String,String> map=new LinkedHashMap<>();

        map.put("c","Monica");
        map.put("a","Chandler");
        map.put("z","Ross");
        map.put("e","Joey");

        for(String i:map.keySet()){
            System.out.println(i);
        }

        Map<String,String> map2=new HashMap<>();

        map2.put("c","Monica");
        map2.put("a","Chandler");
        map2.put("z","Ross");
        map2.put("e","Joey");

        for(String i:map2.keySet()){
            System.out.println(i);
        }
    }

}
