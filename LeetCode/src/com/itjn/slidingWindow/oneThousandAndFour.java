package com.itjn.slidingWindow;

public class oneThousandAndFour {
    public static void main(String[] args) {
        int i = longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        System.out.println(i);
    }

    //滑动窗口(和1004题解法一样)
    public static int longestOnes(int[] nums, int k) {
        int count = 0;
        int max = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if(nums[r] == 0)count++;
            while(count > k){
                count -= 1 - nums[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }



}
