package dynamicprogramming.parttime;

import java.util.*;

/**
 * 题目：如何选择兼职使赚钱最多
 * 现有n份工作，每份工作的起始时间保存在数组startTime中，结束时间保存在数组endTime中，
 * 能获取的报酬保存在数组profit中，那么你该怎样挑选在时间上不冲突的兼职工作从而获取最多的
 * 报酬，返回最大报酬。
 * 注意，数组startTime已经按照从小到大的顺序排好序。
 * 假定现在有5份工作，startTime={1,2,3,4,6},endTime={3,5,10,6,9},
 * profit={20,20,100,70,60},那么应该挑选1、4和5这三份工作，其时间不冲突且能获得最多报酬，
 * 其值为150
 * <p>
 * 关键函数dp(i):从第i份工作开始选，能得到的最大报酬
 */
public class Solution {

    public static void main(String[] args) {

        List<Integer> startTime = Arrays.asList(1, 2, 3, 4, 6);
        List<Integer> endTime = Arrays.asList(3, 5, 10, 6, 9);
        List<Integer> profit = Arrays.asList(20, 20, 100, 70, 60);
        Solution solution = new Solution();
//        System.out.println(solution.jobScheduling(startTime, endTime, profit));
        System.out.println(solution.jobSchedulingByDp(startTime, endTime, profit));
    }

    /**
     * 自顶向下递归
     */
    private int jobScheduling(List<Integer> startTime, List<Integer> endTime, List<Integer> profit) {
        if (startTime.isEmpty()) {
            return 0;
        }
        int firstStartTime = startTime.get(0);
        int firstEndTime = endTime.get(0);
        int firstProfit = profit.get(0);
        List<Integer> startTime1 = new ArrayList<>();
        List<Integer> endTime1 = new ArrayList<>();
        List<Integer> profit1 = new ArrayList<>();
        for (int i = 1; i < startTime.size(); i++) {
            int curStart = startTime.get(i);
            if (curStart >= firstEndTime) {
                startTime1.add(curStart);
                endTime1.add(endTime.get(i));
                profit1.add(profit.get(i));
            }
        }

        List<Integer> startTime2 = startTime.subList(1, startTime.size());
        List<Integer> endTime2 = endTime.subList(1, endTime.size());
        List<Integer> profit2 = profit.subList(1, profit.size());
        return Math.max(jobScheduling(startTime1, endTime1, profit1) + firstProfit,
                jobScheduling(startTime2, endTime2, profit2));
    }

    /**
     * 自底向上动态规划
     */
    private int jobSchedulingByDp(List<Integer> startTime, List<Integer> endTime, List<Integer> profit) {
        int length = startTime.size();
        int[] dp = new int[length + 1];
        dp[length] = 0;
        Map<Integer, List<Integer>> targetMap = new HashMap<>();
        for (int i = length - 1; i >= 0; i--) {
            int curProfit = profit.get(i);
            int next;
            boolean find = false;
            for (next = i + 1; next < length; next++) {
                if (endTime.get(i) <= startTime.get(next)) {
                    find = true;
                    break;
                }
            }
            if (find) {
                dp[i] = curProfit + dp[next];
                List<Integer> list = new ArrayList<>(targetMap.get(next));
                list.add(startTime.get(i));
                targetMap.put(i, list);
            } else {
                if (curProfit >= dp[i + 1]) {
                    dp[i] = curProfit;
                    List<Integer> list = new ArrayList<>();
                    list.add(startTime.get(i));
                    targetMap.put(i, list);
                } else {
                    dp[i] = dp[i + 1];
                    targetMap.put(i, new ArrayList<>(targetMap.get(i + 1)));
                }
            }
        }
        System.out.println(targetMap.get(0));
        return dp[0];
    }
}
