package com.itjn.hot100.图论;

public class 岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 2;
        int area = 1;
        area += dfs(grid, i - 1, j) + dfs(grid, i , j - 1) + dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
        return area;
    }


}
