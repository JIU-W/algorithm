package com.itjn.prefixAnd;

import java.util.Arrays;

public class twoHundredAndNine {
    public static void main(String[] args) {
        int i = minSubArrayLen3(7, new int[]{2,3,1,2,4,3});
        System.out.println(i);
    }

    //方法一：前缀和 + 暴力(超时)
    public static int minSubArrayLen(int target, int[] nums) {
        int sum[] = new int[nums.length + 1];
        //求出前缀和数组
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        //长度为1的特殊情况
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target)return 1;
        }
        int n = 2;
        while(n <= nums.length){
            for (int j = n; j < sum.length; j++) {
                if(sum[j] - sum[j - n] >= target)return n;
            }
            n++;
        }
        return 0;
    }

    //方法二：纯暴力解法(会超时，过不了)
    public static int minSubArrayLen1(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp = temp + nums[j];
                if(temp >= target){
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    //方法三：方法二的改进(二分查找(优化了时间) + 前缀和)
    //数组中每个元素都为正，所以前缀和一定是递增的，这一点保证了二分的正确性。
    public static int minSubArrayLen2(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum[] = new int[nums.length + 1];
        //求出前缀和数组
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < sum.length; i++) {
            int temp = target + sum[i - 1];//原式是求：s[ ] -s[i - 1] >= target
            int search = search(sum, temp);
            if(search != -1){
                minLength = Math.min(minLength, search - i + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    //区间“左闭右闭式”写法(二分查找)
    //目的是在有序数组 sums 中找到一个索引left，使得 sums[left] 是第一个大于或等于 target 的元素。
    public static int search(int[] sum, int target) {
        int left = 1, right = sum.length - 1;//左闭右闭式
        int middle;
        while(left <= right){
            middle = (left + right) / 2;//middle = left + (right - left) >> 1
            if (sum[middle] >= target) {
                right = middle - 1;//这里说明了left不会超过任何大于或等于target的元素的索引
            } else {
                left = middle + 1;//缩小范围
            }
        }
        if (left <= sum.length - 1 && sum[left] >= target) {
            return left;
        }
        return -1;
    }

    //方法四：和方法三基本一样，只是这里的二分查找是调API，不手写。
    public static int minSubArrayLen3(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum[] = new int[nums.length + 1];
        //求出前缀和数组
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < sum.length; i++) {
            int temp = target + sum[i - 1];//原式是求：s[ ] -s[i - 1] >= target
            int index = Arrays.binarySearch(sum, temp);
            if(index < 0){
                index = -index - 1;
            }
            if(index <= nums.length){
                minLength = Math.min(minLength, index - i + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    //滑动窗口(双指针)






}
