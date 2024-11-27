package com.itjn.leetCode75;


public class oneHundredAndSixtyTwo {
    public static void main(String[] args) {
        int peakElement = findPeakElement1(new int[]{1,2,3,1});
        System.out.println(peakElement);
    }

    //方法一：暴力解法
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1)return 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 && nums[i] > nums[i + 1]){
                return 0;
            }
            if(i == nums.length - 1 && nums[i] > nums[i - 1]){
                return nums.length - 1;
            }
            if(i != 0 && i != nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                return i;
            }
        }
        return 0;
    }


    //方法二：二分
    //因为nums[-1] = nums[n] = -∞ 。故只要找到一个上坡或者下坡就可以了。上坡或者下坡都必存在一个峰值。
    //而题目的要求正好是返回“任何一个峰值 ”
    //这题的过程：不断地找上坡或者下坡(同时通过二分不断地缩小区间)，直到区间的长度为1。
    public static int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){   //条件不能是l <= r，这样当l == r时会陷入死循环。
            int middle = (l + r) >> 1;
            if(nums[middle] > nums[middle + 1]){
                r = middle;
            }else if(nums[middle] < nums[middle + 1]){
                l = middle + 1;
            }
        }
        //当l == r时，跳出while循环，此时 l和r 都指向峰值。
        return l;//返回l或者r都行行
    }


}

