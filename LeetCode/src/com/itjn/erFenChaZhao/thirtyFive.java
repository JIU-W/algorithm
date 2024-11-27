package com.itjn.erFenChaZhao;

import java.util.Arrays;

public class thirtyFive {
    public static void main(String[] args){
    }

    //方法一：调用API
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if(i < 0) i = -i - 1;
        return i;
    }

    //方法二：手写二分
    //注：如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public int searchInsert1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int middle = (l + r) >> 1;
            if(target < nums[middle]){
                r = middle - 1;
            }else if(target > nums[middle]){
                l = middle + 1;
            }else{
                return middle;
            }
        }
        return l;//不存在时，返回左指针。因为左指针最后的位置就是被插入的位置。
    }

}
