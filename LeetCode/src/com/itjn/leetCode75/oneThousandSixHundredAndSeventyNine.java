package com.itjn.leetCode75;

import java.util.Arrays;
import java.util.*;

public class oneThousandSixHundredAndSeventyNine {
    public static void main(String[] args) {
        int i = maxOperations1(new int[]{1, 2, 3, 4}, 5);
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

    //二刷
    public static int maxOperations1(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] == k){
                i++;
                j--;
                count++;
            } else if (nums[i] + nums[j] < k) {
                i++;
            }else{
                j--;
            }
        }
        return count;
    }



}
