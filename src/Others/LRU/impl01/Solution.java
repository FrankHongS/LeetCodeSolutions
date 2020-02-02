package Others.LRU.impl01;

import java.util.HashMap;

/**
 * Created by Frank_Hon on 2019-09-01 18:37.
 * E-mail: frank_hon@foxmail.com
 */
public class Solution {

    public static void main(String[] args) {
        LRU<Integer, String> lru = new LRU<>(5);

        lru.put(0, "Joey");
        lru.put(1, "Ross");
        lru.put(2, "Chandler");

        lru.put(3, "Monica");
        lru.put(3, "Pheobe");

//        System.out.println(lru.get(0));

        lru.put(5, "Reachel");

        lru.print();

        int i=10&"h4pua".hashCode();
        int j=10&"h44pua".hashCode();
        HashMap<String,Integer> map=new HashMap<>(11);
        map.put("h4pua",98);
        map.put("h44pua",100);
        System.out.println(i);
        System.out.println(j);

        System.out.println(map.get("h4pua"));
        System.out.println(map.get("h44pua"));
    }

}
