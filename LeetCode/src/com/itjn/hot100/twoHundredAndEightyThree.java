package com.itjn.hot100;

public class twoHundredAndEightyThree {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes3(a);
        for (int num : a) {
            System.out.println(num);
        }
    }

    //方法一（双指针）：两次遍历
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //方法二（双指针）（参考快速排序的思想）
    public static void moveZeroes2(int[] nums) {
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }


    //（暴力但是超时了）
    public static void moveZeroes3(int[] nums) {
        int count = 0;
        if (nums.length == 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
            }
        }
        for (int i = nums.length - 1; i >= nums.length - count; i--) {
            nums[i] = 0;
        }
    }



}
