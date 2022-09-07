package Others.maxAreaIsland;

import util.Util;

/**
 * Created by Frank_Hon on 2022/7/24 2:41 PM.
 * E-mail: frank_hon@foxmail.com
 *
 * Max Area of Island(岛屿最大面积) (region growing algorithm)
 * You are given an `m*n` binary matrix grid. An island is a group of `1`s(representing land) connected
 * 4-directionally (horizontal or vertical).You may assume all four edges of the grid are surrounded by
 * water. The area of an island is the number of cells with a value `1` on the island.
 * Return the maximum area of an island in the grid. If there is no island, return 0.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid =
                {
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                };
        int maxArea = solution.maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }

    private int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int xLength = grid.length;
        int maxArea = 0;
        for (int i = 0; i < xLength; i++) {
            int yLength = grid[i].length;
            for (int j = 0; j < yLength; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, growRegion(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int growRegion(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return 0;
        }
        int value = grid[x][y];
        if (value != 1) {
            return 0;
        } else {
            grid[x][y] = -1;
            int left = growRegion(x, y - 1, grid);
            int top = growRegion(x - 1, y, grid);
            int right = growRegion(x, y + 1, grid);
            int bottom = growRegion(x + 1, y, grid);
            return 1 + left + top + right + bottom;
        }
    }
}
