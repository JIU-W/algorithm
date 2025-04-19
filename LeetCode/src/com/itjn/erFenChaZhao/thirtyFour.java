package com.itjn.erFenChaZhao;

import java.util.Arrays;

public class thirtyFour {
    public static void main(String[] args) {
        int[] arr = searchRange2(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(Arrays.toString(arr));
    }

    //方法二：二分查找
    public static int[] searchRange1(int[] nums, int target) {
        int left = 0, right =  nums.length - 1;
        int start = -1, end = -1;
        //二分查找起始位置
        while(left <= right){
            int middle = (left + right) >> 1;
            if((nums[middle] == target && middle == 0) ||
                    (nums[middle] == target && nums[middle - 1] < target)){
                start = middle;
                break;
            } else if(nums[middle] == target && nums[middle - 1] == target){
                right = middle - 1;
            } else if(nums[middle] < target){
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        if(start == -1)return new int[]{-1,-1};

        //右推找到终点(终点也可以用二分找)
        for (int i = start; i < nums.length; i++) {
            if(i == nums.length - 1 || nums[i] < nums[i + 1]){
                end = i;
                break;
            }
        }

        return new int[]{start,end};
    }


    //方法一:暴力搜索
    public static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]){
                temp++;
            }
            if(temp == 1 && target == nums[i]){
                start = i;
            }
        }
        if(start == -1)return new int[]{-1,-1};
        return new int[]{start,start + temp - 1};
    }


    //二刷
    public static int[] searchRange2(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        int start = -1, end = -1;
        int middle;
        while(l <= r){
            middle = (l + r) >> 1;
            if(target < nums[middle]){
                r = middle - 1;
            } else if (target > nums[middle]) {
                l = middle + 1;
            }else if((target == nums[middle] && middle == 0) ||
                    (target == nums[middle] && nums[middle - 1] < target)) {
                start = middle;
                break;
            } else if(target == nums[middle] && nums[middle - 1] == target){
                r = middle - 1;
            }
        }
        if(start == -1)return new int[]{-1, -1};

        for (int i = start; i < nums.length; i++) {
            if(i == nums.length - 1 || nums[i] < nums[i + 1]){
                end = i;
                break;
            }
        }
        return new int[]{start, end};
    }

}
