package com.itjn.hot100;

public class fiftyThree {
    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    //动态规划
    public static int maxSubArray(int[] nums) {
        int max;
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
        }

        max = f[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(f[i], max);
        }
        return max;
    }

    //分治(线段树)
    public static int maxSubArray1(int[] nums) {



        return 0;
    }



}
