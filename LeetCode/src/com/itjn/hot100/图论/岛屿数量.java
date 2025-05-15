package com.itjn.hot100.图论;

public class 岛屿数量 {

    //方法一：深度优先搜索
    public int numIslands(char[][] grid) {
        if(grid == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int r, int c){
        //判断边界
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }
        if(grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '2';
        dfs(grid, r - 1,c);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1,c);
        dfs(grid, r, c + 1);
    }


    //方法二：广度优先搜索
    public int numIslands1(char[][] grid){


        return 0;
    }

}
