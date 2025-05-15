package com.itjn.hot100.图论;

public class 岛屿的周长 {

    //深度优先搜索
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int i, int j){
        // 函数因为「坐标 (r, c) 超出网格范围」返回
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回
        if(grid[i][j] == 0){
            return 1;
        }
        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if(grid[i][j] == 2){
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, i - 1, j) + dfs(grid, i , j - 1) + dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
    }

}
