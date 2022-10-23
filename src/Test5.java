import util.ArraysUtil;

/**
 * Created by Frank_Hon on 2022/9/22 2:28 PM.
 * E-mail: frank_hon@foxmail.com
 */
public class Test5 {

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        int[] target = test5.merge(a, b);
        ArraysUtil.print(target);

    }

    private int[] merge(int[] a, int[] b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int[] target = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        while (aIndex < a.length && bIndex < b.length) {
            int aValue = a[aIndex];
            int bValue = b[bIndex];
            if (aValue < bValue) {
                target[index] = aValue;
                aIndex++;
            } else {
                target[index] = bValue;
                bIndex++;
            }
            index++;
        }
        if (aIndex >= a.length) {
            for (int i = bIndex; i < b.length; i++) {
                target[index] = b[i];
                index++;
            }
        }
        if (bIndex >= b.length) {
            for (int j = aIndex; j < a.length; j++) {
                target[index] = a[j];
                index++;
            }
        }
        return target;
    }
}
