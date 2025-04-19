package com.itjn.erFenChaZhao;

import java.util.Arrays;
import java.util.List;

public class thirtyThree {
    public static void main(String[] args) {
        int search = search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search);
    }

    //方法一：对原数组进行二分
    public static int search(int[] nums, int target) {
        int xx = 0;//数组和旋转后数组的偏移量
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]){
                xx = i + 1;
                break;
            }
        }
        //Arrays.sort(nums);
        //用三次反转代替快速排序，时间复杂度降低了很多
        if(xx != 0){
            reserve(nums,0,xx - 1);
            reserve(nums,xx, nums.length -  1);
            reserve(nums,0, nums.length -  1);
        }

        //对原数组进行二分
        int index = Arrays.binarySearch(nums, target);
        if(index < 0){
            return -1;
        }
        index = (index + xx) % nums.length;
        return index;
    }
    public static void reserve(int[] nums, int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //方法二(直接对旋转后的数组进行二分)
    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //先根据nums[mid]与nums[0]的关系判断 mid 是在左段还是右段
            //mid落在左段
            if (nums[mid] >= nums[0]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 left 和 right
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//mid落在右段
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    //二刷
    public static int search3(int[] nums, int target){

        return 0;
    }

}
