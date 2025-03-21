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
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
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


    //二刷
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 || n == k)return;
        while(n < k){
            k = k - n;
        }
        int[] temp = new int[k];
        int index = 0;
        for (int i = n - k; i < nums.length; i++) {
            temp[index] = nums[i];
            index++;
        }
        int index2 = n - 1;
        for (int i = n - k - 1; i >= 0; i--) {
            nums[index2] = nums[i];
            index2--;
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }

}
