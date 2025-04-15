package com.itjn.other.线上笔试.作业帮;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nums);
        int max = 0;
        max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        max = Math.max(max, nums[nums.length - 1] * nums[0] * nums[1]);
        System.out.println(max);
    }


}
