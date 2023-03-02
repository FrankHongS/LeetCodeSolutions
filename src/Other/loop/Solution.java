package Other.loop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 一边遍历列表，一边删除列表中元素
 */
public class Solution {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ross");
        list.add("Joey");
        list.add("Chandler");

        // Fast-Fail java.util.ConcurrentModificationException
//        for (String name : list) {
//            list.remove(name);
//        }

        // Fast-Fail java.util.ConcurrentModificationException
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String name = iterator.next();
//            if (name.equals("Ross")) {
//                list.remove(name);
//            }
//        }

        // 一边遍历列表，一边删除列表中元素的标准操作
        Iterator<String> iterator= list.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }

        System.out.println(list);
    }

}
