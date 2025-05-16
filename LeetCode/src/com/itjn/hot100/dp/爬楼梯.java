package com.itjn.hot100.dp;

public class 爬楼梯 {

    public static void main(String[] args) {
        爬楼梯 plt = new 爬楼梯();
        System.out.println(plt.climbStairs(5));
    }

    //动态规划
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
