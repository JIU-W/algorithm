package com.itjn.erFenChaZhao;

import java.util.Arrays;

public class oneHundredAndFiftyThree {
    public static void main(String[] args) {
        int min = findMin(new int[]{11, 13, 15, 17});
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        //先判断旋转后有没有变成原来的数组
        if (nums[0] > nums[r]) {//变了
            while (l <= r) {
                int middle = (l + r) >> 1;
                //先判断落在前半段还是后半段
                if (nums[0] <= nums[middle]) {//前半段
                    l = middle + 1;
                } else if (nums[0] > nums[middle]) {//后半段
                    if (nums[middle] < nums[middle - 1]) return nums[middle];
                    r = middle - 1;
                }
            }
        } else {//没变
            return nums[0];
        }

        return -1;
    }

    //二刷
    public static int findMin1(int[] nums){
        int l = 0,r = nums.length - 1;
        if(nums[0] > nums[r]){
            int middle;
            while(l <= r){
                middle = (l + r) >> 1;
                if(nums[middle] >= nums[0]){//落在左半段
                    l = middle + 1;
                }else{//落在右半段
                    if(nums[middle] < nums[middle - 1]){
                        return nums[middle];
                    }else{
                        r = middle - 1;
                    }
                }
            }
        }else{
            return nums[0];
        }

        return -1;
    }

}
