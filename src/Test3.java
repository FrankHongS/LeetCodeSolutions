import util.ArraysUtil;

/**
 * Created by Frank_Hon on 2022/6/1 下午3:00.
 * E-mail: frank_hon@foxmail.com
 */
public class Test3 {

    public static void main(String[] args) {
        float a=0.0f;
        System.out.println(String.format("%.6f",a));
    }

    private void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int first = array[0];
        int start = 1;
        int end = array.length - 1;
        while (start < end) {
            int startValue = array[start];
            int endValue = array[end];
            if (startValue < first) {
                start++;
            }
            if (endValue > first) {
                end--;
            }
            if (startValue > first && endValue < first) {
                ArraysUtil.swapElements(array, start, end);
            }
        }
        ArraysUtil.swapElements(array,0,start-1);
    }

}
