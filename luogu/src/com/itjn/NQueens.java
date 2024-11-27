package com.itjn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //  System.out.println("请输入 n 的值：");
        int n = scanner.nextInt();
        scanner.close();

        int[][] board = new int[n][n];
        List<int[][]> solutions = new ArrayList<>();

        solveNQueens(board, 0, solutions);

        // 输出解决方案到控制台
        for (int[][] solution : solutions) {
            int t = 0;
            int []arr = new int[5];
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    if (solution[i][j] == 1) {
                        arr[t++] = j;
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            for (int i = 0;i<5;i++) {
                System.out.print(arr[i]+1+" ");
            }
            System.out.println();
        }
    }

    private static void solveNQueens(int[][] board, int row, List<int[][]> solutions) {
        int n = board.length;
        if (row == n) {
            // 找到一个解决方案，将其复制到结果列表中
            int[][] solution = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    solution[i][j] = board[i][j];
                }
            }
            solutions.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // 放置皇后
                solveNQueens(board, row + 1, solutions); // 递归下一行
                board[row][col] = 0; // 回溯
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int n = board.length;

        // 检查同一列上是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // 检查左上方对角线是否有皇后
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 检查右上方对角线是否有皇后
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}