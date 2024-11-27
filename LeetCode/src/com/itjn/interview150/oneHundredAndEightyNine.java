package com.itjn.interview150;

import java.util.Arrays;

public class oneHundredAndEightyNine {
    public static void main(String[] args) {
        int a[]  = new int[]{-1,-100,3,99};
        rotate1(a, 2);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    //方法一：使用额外的数组
    public static void rotate(int[] nums, int k) {
        int arr[]  = new int[nums.length];
        int j = k;
        for (int i = 0; i < nums.length; i++) {
            j = j % nums.length;
            arr[j] = nums[i];
            j++;
        }
        /*for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }*/
        System.arraycopy(arr, 0, nums, 0, nums.length);
    }

    //方法二：数组翻转（想法很妙！！！）（不使用额外的空间）
    //java里面的数组翻转方式：1、直接循环翻转 2、转成链表在调API(Collections.reverse())翻转(只适用于对象数组)
    //3、使用Java 8的流(Stream API):不建议使用
    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    //方法三：环状替换（不使用额外的空间）

}
