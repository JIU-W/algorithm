package com.itjn.sort;

import java.util.Arrays;

public class 三个数的最大乘积 {
    public static void main(String[] args) {

    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        //三个最大正数
        max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        //两个最小负数和一个最大正数
        max = Math.max(max, nums[0] * nums[1] * nums[nums.length - 1]);
        return max;
    }

}
