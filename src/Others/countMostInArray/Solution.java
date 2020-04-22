package Others.countMostInArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] array = {1, 2, 1, 2, 1, 2, 1, 2, 3, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 3, 1, 2, 1, 2, 1, 2, 1, 2};

        int target = solution.findMost(array);
        System.out.println(target);
    }

    public int findMost(int[] array) {

        if (array == null) {
            throw new RuntimeException("array can't be null");
        }

        if (array.length == 0) {
            return -1;
        }

        int length = array.length;
        int maxCount = 1;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int value = array[i];

            if (!countMap.containsKey(value)) {
                countMap.put(value, 1);
            } else {
                int count = countMap.get(value);
                countMap.put(value, ++count);

                if (count > length / 2) {
                    return value;
                }

                if (count > maxCount) {
                    maxCount = count;
                }
            }

            if (maxCount + length - 1 - i <= length / 2) {
                return -1;
            }
        }

        return -1;
    }

}
