package com.itjn.erFenChaZhao;

import java.util.Arrays;

public class oneHundredAndFiftyFour {
    public static void main(String[] args) {
        int min = findMin(new int[]{2, 2, 2, 0, 1});
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int middle = (l + r) >> 1;
            //先判断落在前半段还是后半段
            if (nums[r] < nums[middle]) {//左半段
                l = middle + 1;
            } else if (nums[r] == nums[middle]) {
                r--;
            } else if (nums[r] > nums[middle]) {//右半段
                r = middle;
            }

        }
        return nums[l];
    }


}
