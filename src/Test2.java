import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank_Hon on 2022/4/20 上午11:45.
 * E-mail: frank_hon@foxmail.com
 */
public class Test2 {

    public static void main(String[] args) {
        Integer a=20;
        Integer b=20;
        System.out.println(a==b);
    }

    private List<Integer> findLostNum(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int item : array) {
            if (list.contains(item)) {
                list.remove(new Integer(item));
            }
        }
        return list;
    }
}
