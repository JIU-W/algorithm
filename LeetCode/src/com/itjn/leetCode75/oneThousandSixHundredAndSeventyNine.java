package com.itjn.leetCode75;

import java.util.Arrays;

public class oneThousandSixHundredAndSeventyNine {
    public static void main(String[] args) {
        int i = maxOperations(new int[]{1, 2, 3, 4}, 5);
        System.out.println(i);
    }


    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int j = nums.length - 1;
        int i = 0;
        int count = 0;
        while(i < j) {
            if(nums[i] + nums[j] == k){
                i++;
                j--;
                count++;
            }else if(nums[i] + nums[j] < k) {
                i++;
            }else{
                j--;
            }
        }
        return count;
    }


}
